package com.devsquadllc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class MyUser {

	@Id	
	private String username;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Todo> todos;
}
