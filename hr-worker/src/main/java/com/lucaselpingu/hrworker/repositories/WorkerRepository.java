package com.lucaselpingu.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaselpingu.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
