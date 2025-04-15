package com.lucaselpingu.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucaselpingu.hrpayroll.entites.Payment;
import com.lucaselpingu.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@GetMapping("/{id}")
	//anotação usada para pega parametros passados na url dps do "?" e o value e o nome do param "http://localhost:8101/payments/1?days=2" e caso n seja informado string vazia
	public ResponseEntity<Payment> getPayment(@PathVariable long id, @RequestParam(value = "days", defaultValue = "") int days){
		Payment payment = service.getPayment(id, days);
		return ResponseEntity.ok().body(payment);
	}
	
}
