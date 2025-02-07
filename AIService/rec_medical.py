from flask import Flask, request, jsonify
import joblib
from flask_cors import CORS

app = Flask(__name__)

# 모델 로드
model = joblib.load('model.joblib')
tfidf = joblib.load('tfidf.joblib')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    symptoms = data['symptoms']
    
    # 입력 증상 로깅
    print(f"[DEBUG] 입력 증상: {symptoms}")
    
    # 예측
    X_input = tfidf.transform([symptoms])
    pred = model.predict(X_input)[0]
    
    # 예측 결과 로깅
    print(f"[DEBUG] 예측 진료과: {pred}")
    
    return jsonify({'medical': pred})

if __name__ == '__main__':
    app.run(port=5000, debug=True)