package com.devsquadllc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsquadllc.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByUserUsername(String username);
}
