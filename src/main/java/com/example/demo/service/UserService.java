package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User create(String firstName, String lastName, String dOB) {
		return userRepository.save(new User(firstName, lastName, dOB));
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User update(String firstName, String lastName, String dOB) {
		User user = userRepository.findByFirstName(firstName);
		user.setLastName(lastName);
		user.setdOB(dOB);
		return userRepository.save(user);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

	public void delete(String firstName) {
		User user = userRepository.findByFirstName(firstName);
		userRepository.delete(user);
	}

}
