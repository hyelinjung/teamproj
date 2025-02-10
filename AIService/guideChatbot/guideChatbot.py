from flask import Flask, request, jsonify
import torch
from transformers import AutoModelForCausalLM, AutoTokenizer

# ✅ Flask 앱 생성
app = Flask(__name__)

class ChatbotModel:
    _instance = None  # ✅ 싱글톤 객체 저장

    def __new__(cls):
        if cls._instance is None:
            print("🔹 [INFO] Fine-Tuned 챗봇 모델 로딩 중...")
            cls._instance = super(ChatbotModel, cls).__new__(cls)
            cls._instance.load_model()
        return cls._instance

    def load_model(self):
        """Fine-Tuned 모델 로드"""
        model_path = "./gemma-finetuned"
        self.tokenizer = AutoTokenizer.from_pretrained(model_path)
        self.model = AutoModelForCausalLM.from_pretrained(model_path).to("cuda" if torch.cuda.is_available() else "cpu")
        print("✅ Fine-Tuned 모델 로드 완료!")

    def get_response(self, user_input):
        """챗봇 응답 생성"""
        inputs = self.tokenizer(f"사용자: {user_input}\n챗봇:", return_tensors="pt").to("cuda" if torch.cuda.is_available() else "cpu")
        outputs = self.model.generate(**inputs, max_length=200)
        response_text = self.tokenizer.decode(outputs[0], skip_special_tokens=True)

        # ✅ "챗봇:" 이후의 응답만 추출
        if "챗봇:" in response_text:
            response_text = response_text.split("챗봇:")[1].strip()

        return response_text

# ✅ 싱글톤 인스턴스 생성
chatbot = ChatbotModel()

@app.route("/chatbot", methods=["POST"])
def chatbot_api():
    """Flask API 엔드포인트"""
    data = request.json
    user_input = data.get("message", "")

    if not user_input:
        return jsonify({"error": "입력 메시지가 없습니다."}), 400

    response = chatbot.get_response(user_input)
    return jsonify({"response": response})

if __name__ == "__main__":
    app.run(port=5100, debug=True)
