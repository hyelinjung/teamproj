package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.ChatService;
import com.asklepios.hospitalreservation_asklepios.VO.ChatVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/api/chat/recommend")
    public String recommendMedicalDepartment(@RequestBody ChatVO chatVO) {
        System.out.println("1");
        return chatService.recommendDepartment(chatVO.getSymptoms());
    }
}
