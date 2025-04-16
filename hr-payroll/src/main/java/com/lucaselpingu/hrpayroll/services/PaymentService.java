package com.lucaselpingu.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaselpingu.hrpayroll.entites.Payment;
import com.lucaselpingu.hrpayroll.entites.Worker;
import com.lucaselpingu.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeign;
	
	public Payment getPayment(long id, int days) {
		Worker worker = workerFeign.findById(id).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
