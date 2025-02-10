package com.asklepios.hospitalreservation_asklepios.Service;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

public interface IF_ChatService {
    String guideMessage(String userMessage);
    String recommendDepartment(String symptoms);
}
