package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.ChatService;
import com.asklepios.hospitalreservation_asklepios.VO.ChatVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatservice;

    // 챗봇 페이지 렌더링
    @GetMapping("/chat")
    public String chatPage(Model model) {
        model.addAttribute("chatRequest", new ChatVO());
        return "chat";
    }

    // 추천 요청 처리
    @PostMapping("/recommend")
    public String recommendDepartment(
            @ModelAttribute ChatVO chatRequest,
            Model model
    ) {
        try {
            String department = chatservice.recommendDepartment(chatRequest.getSymptoms());

            // 추천 결과 로깅
            System.out.println("[DEBUG] 추천 진료과: " + department);

            model.addAttribute("recommendation", department);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("chatRequest", chatRequest);
        return "chat";
    }
}
