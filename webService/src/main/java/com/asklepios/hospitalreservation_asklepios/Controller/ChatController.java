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
        if(chatVO.getIdentifier().equals("symptomChatbot")) {
            System.out.println("1");
            return chatService.recommendDepartment(chatVO.getMainMessage());
        } else if(chatVO.getIdentifier().equals("guideChatbot")) {
            return chatService.recommendDepartment(chatVO.getMainMessage());
        }
        return null;
    }
}
