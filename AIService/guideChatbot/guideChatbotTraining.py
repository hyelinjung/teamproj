import pandas as pd
import torch
import os
from transformers import AutoModelForCausalLM, AutoTokenizer
from datasets import Dataset
from torch.utils.data import DataLoader
from huggingface_hub import login

# ✅ Hugging Face 로그인
huggingface_token = os.getenv("HUGGINGFACE_TOKEN")
login(token=huggingface_token)

# ✅ 모델 및 토크나이저 로드
model_name = "google/gemma-2b"
tokenizer = AutoTokenizer.from_pretrained(model_name)
model = AutoModelForCausalLM.from_pretrained(model_name)

# ✅ Mac OS에서 적절한 디바이스 선택
if torch.backends.mps.is_available():  # ✅ Apple M1/M2 GPU 지원 (Metal Performance Shaders)
    device = torch.device("mps")
    print("🔹 Using MPS (Apple Metal GPU)")
elif torch.cuda.is_available():  # ✅ NVIDIA GPU (Mac에서는 일반적으로 사용 불가능)
    device = torch.device("cuda")
    print("🔹 Using CUDA (NVIDIA GPU)")
else:
    device = torch.device("cpu")
    print("🔹 Using CPU")

model.to(device)

# ✅ CSV 데이터 로드
try:
    df = pd.read_csv("guideChatbot.csv")

    print("🔹 CSV 데이터 로드 완료! 데이터 샘플:")
    print(df.head())

    # ✅ Dataset 변환
    dataset = Dataset.from_pandas(df)

    # ✅ 토크나이징 (labels 추가)
    def tokenize_function(examples):
        tokenized_inputs = tokenizer(
            examples["inputs"],
            padding=True,
            truncation=True,
            max_length=512
        )

        # ✅ labels 추가 (input_ids 복사)
        tokenized_inputs["labels"] = tokenized_inputs["input_ids"]

        return tokenized_inputs

    tokenized_datasets = dataset.map(tokenize_function, batched=True)

    # ✅ 데이터셋을 학습용(train)과 검증용(eval)으로 분리
    split_data = tokenized_datasets.train_test_split(test_size=0.2)  # 80% 학습, 20% 검증
    train_dataset = split_data["train"]
    eval_dataset = split_data["test"]

    print(f"🔹 학습 데이터셋 크기: {len(train_dataset)}")
    print(f"🔹 검증 데이터셋 크기: {len(eval_dataset)}")

    # ✅ PyTorch DataLoader 생성
    train_dataloader = DataLoader(train_dataset, batch_size=4, shuffle=True)
    eval_dataloader = DataLoader(eval_dataset, batch_size=4)

    # ✅ 옵티마이저 설정
    optimizer = torch.optim.AdamW(model.parameters(), lr=5e-5)

    # ✅ 학습 루프
    num_epochs = 3
    model.train()
    for epoch in range(num_epochs):
        print(f"🔹 Epoch {epoch+1}/{num_epochs} 시작...")
        total_loss = 0

        for batch in train_dataloader:
            # ✅ 리스트를 PyTorch Tensor로 변환 (torch.stack() 사용)
            inputs = {
                k: torch.stack([torch.tensor(t, dtype=torch.long) for t in v]).to(device)
                for k, v in batch.items() if k in ["input_ids", "attention_mask", "labels"]
            }

            outputs = model(**inputs)
            loss = outputs.loss

            loss.backward()
            optimizer.step()
            optimizer.zero_grad()

            total_loss += loss.item()

        avg_loss = total_loss / len(train_dataloader)
        print(f"✅ Epoch {epoch+1}/{num_epochs} 완료, 평균 손실(loss): {avg_loss:.4f}")

    print("✅ Fine-Tuning 완료!")

    # ✅ 모델 저장
    model.save_pretrained("./gemma-finetuned")
    tokenizer.save_pretrained("./gemma-finetuned")
    print("✅ 모델 저장 완료!")

except Exception as e:
    print(f"❌ 학습 오류 발생: {e}")
