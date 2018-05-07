package com.devsquadllc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String description;
	
	@ManyToOne
	private MyUser user;

	public Todo(String description, MyUser user) {
		this.description = description;
		this.user = user;
	}

}
