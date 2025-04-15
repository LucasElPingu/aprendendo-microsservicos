package com.lucaselpingu.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.lucaselpingu.hrpayroll.entites.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long id, int days) {
		//vai precisar chamar no microsservico workers o worker pelo id
		return new Payment("Maria", 100.0, days);
	}
}
