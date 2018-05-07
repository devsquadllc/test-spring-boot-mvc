package com.devsquadllc.repository;

import org.springframework.data.repository.CrudRepository;

import com.devsquadllc.model.MyUser;

public interface UserRepository extends CrudRepository<MyUser, String>{

}
