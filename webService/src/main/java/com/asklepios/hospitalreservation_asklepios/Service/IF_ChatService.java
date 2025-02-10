package com.asklepios.hospitalreservation_asklepios.Service;

import java.util.concurrent.CompletableFuture;

public interface IF_ChatService {
    String guideMessage(String guide);
    String recommendDepartment(String symptoms);
}
