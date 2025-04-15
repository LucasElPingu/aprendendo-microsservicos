package com.lucaselpingu.hrworker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaselpingu.hrworker.entities.Worker;
import com.lucaselpingu.hrworker.repositories.WorkerRepository;
import com.lucaselpingu.hrworker.service.exceptions.ResourceNotFoundException;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;
	
	public List<Worker> findAll(){
		List<Worker> list = repository.findAll();
		return list;
	}

	public Worker findById(Long id){
		Optional<Worker> worker = repository.findById(id);
		return worker.orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
