package com.lucaselpingu.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaselpingu.hrworker.entities.Worker;
import com.lucaselpingu.hrworker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerService service;
	
	@GetMapping({"", "/"})
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker worker = service.findById(id);
		return ResponseEntity.ok().body(worker);
	}
}
