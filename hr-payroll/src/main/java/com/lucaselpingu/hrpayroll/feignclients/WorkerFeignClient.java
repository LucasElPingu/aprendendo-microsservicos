package com.lucaselpingu.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lucaselpingu.hrpayroll.entites.Worker;



@FeignClient(name = "hr-worker", path = "/workers", fallback = WorkerFeignFallback.class)
public interface WorkerFeignClient {
	
    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
    
    
}
