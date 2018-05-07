package com.devsquadllc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsquadllc.model.MyUser;
import com.devsquadllc.model.Todo;
import com.devsquadllc.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;

	public void saveTodo(String description) {

		MyUser user = getUser();
		Todo todo = new Todo(description, user);
		todoRepo.save(todo);

	}

	public List<Todo> getTodoList() {
		MyUser user = getUser();
		if (user != null) {
			return todoRepo.findByUserUsername(user.getUsername());
		}
		return null;
	}

	public void deleteTodoById(long id) {
		Optional<Todo> todoOpt = todoRepo.findById(id);
		if (todoOpt.isPresent()) {
			Todo todo = todoOpt.get();
			MyUser user = getUser();
			if (todo.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
				todoRepo.deleteById(id);
			}
		}
	}

	private MyUser getUser() {
		return null;
	}

}
