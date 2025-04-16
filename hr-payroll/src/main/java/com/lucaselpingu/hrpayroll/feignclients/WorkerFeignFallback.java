package com.lucaselpingu.hrpayroll.feignclients;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.lucaselpingu.hrpayroll.entites.Worker;

@Component
public class WorkerFeignFallback implements WorkerFeignClient {

    @Override
    public ResponseEntity<Worker> findById(Long id) {
        Worker worker = new Worker(id, "Fallback Worker", 0.0);
        return ResponseEntity.ok(worker);
    }
}
