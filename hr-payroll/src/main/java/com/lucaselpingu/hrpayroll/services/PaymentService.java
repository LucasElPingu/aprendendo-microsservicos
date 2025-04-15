package com.lucaselpingu.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lucaselpingu.hrpayroll.entites.Payment;
import com.lucaselpingu.hrpayroll.entites.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;
	//permite atribuir o valor da propiedade a uma variavel 
	@Value("${hr-worker.host}")
	private String workerHost;
	
	public Payment getPayment(long id, int days) {
		//vai precisar chamar no microsservico workers o worker pelo id
		//faz a chamada no webservice no workers
		//faz a requisição a uma API externa usando resttemplate
		//como passar parametros em uma requisição resttemplate usando o getforobject, tem que criar um mapa
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(id));
		//url começa com o host + o caminho e paramentro entre chaves, tipo do objeto, o parametros
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
