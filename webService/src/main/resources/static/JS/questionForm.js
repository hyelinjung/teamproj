function getCleanText() {
    let chatInput = document.getElementById("question_content").cloneNode(true); // 원본 보호
    chatInput.querySelectorAll("span").forEach(span => span.remove()); // 모든 <span> 삭제
    return chatInput.innerText.trim(); // 깨끗한 텍스트 반환
}

function recommendMedical() {
    let chatInput = document.getElementById("question_content");
    let userMessage = chatInput.innerText.trim(); // 공백 제외한 사용자 입력값
    let message = chatInput.textContent.trim(); // display: none; 속성의 텍스트 포함하여 가져오기

    if (getCleanText() === "") {
        alert("내용을 입력해주세요.");
        return;
    }

    // identifier와 mainMessage 분리
    let insertMessage = message.split(" "); // 공백 기준 단어 나누기
    let identifier = insertMessage.shift(); // 첫 번째 단어를 identifier로 저장
    let mainMessage = insertMessage.join(" "); // 나머지 단어들을 다시 문자열로 결합

    // 챗봇 응답 받기
    $.ajax({
        url: "/asklepios/api/medical/recommend",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            identifier: identifier,
            mainMessage: mainMessage
        }),
        success: function(response) {
            // 추천된 진료과 드롭다운 변경
            let medicalDropdown = document.getElementById("question_medical");
            let validOptions = Array.from(medicalDropdown.options).map(opt => opt.value);

            if (validOptions.includes(response)) {
                medicalDropdown.value = response;
            } else {
                alert("추천된 진료과가 목록에 없습니다.");
            }
        },
        error: function() {
            alert("진료과 추천 요청 실패");
        }
    });
}
