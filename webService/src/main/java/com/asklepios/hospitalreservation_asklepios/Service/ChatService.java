package com.asklepios.hospitalreservation_asklepios.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final RestTemplate restTemplate;

    @Value("${python.api.url}") // application.properties에서 주입
    private String pythonApiUrl;

    public String recommendDepartment(String symptoms) {
        try {
            // Python API 호출
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    pythonApiUrl + "/predict",
                    Map.of("symptoms", symptoms),
                    Map.class
            );

            // 응답 데이터 로깅
            System.out.println("[DEBUG] Python API 응답: " + response.getBody());

            return (String) response.getBody().get("medical");
        } catch (Exception e) {
            throw new RuntimeException("진료과목 추천 실패: " + e.getMessage());
        }
    }
}
