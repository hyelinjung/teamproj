package com.asklepios.hospitalreservation_asklepios.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class ChatService {
    private final RestTemplate restTemplate;

    public ChatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // 여기서 부터 수정 필요
    public String guideMessage(String guide) {
        String url = "http://localhost:5100/";

        // JSON 데이터 생성
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("guide", guide);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        // Flask API 호출
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        return response.getBody().get("medical").toString();
    }

    public String recommendDepartment(String symptoms) {
        String url = "http://localhost:5000/predict"; // Python Flask 서버 주소

        // JSON 데이터 생성
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("symptoms", symptoms);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        // Flask API 호출
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        return response.getBody().get("medical").toString();
    }
}