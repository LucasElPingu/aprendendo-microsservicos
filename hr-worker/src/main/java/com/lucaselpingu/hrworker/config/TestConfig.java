package com.lucaselpingu.hrworker.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaselpingu.hrworker.entities.Worker;
import com.lucaselpingu.hrworker.repositories.WorkerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private WorkerRepository wrRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Worker w1 = new Worker(null, "bob", 200.0);
		Worker w2 = new Worker(null, "Maria", 300.0);
		Worker w3 = new Worker(null, "Alex", 250.0);
		
		wrRepo.saveAll(Arrays.asList(w1, w2, w3));
		
	}

}
