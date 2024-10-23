package com.example.proyect.demo.infrastructure.repositories.operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.proyect.demo.domain.entities.security.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    @Query("SELECT o FROM Operation o where o.permitAll = true")
    List<Operation> findByPubliccAcces();
}
