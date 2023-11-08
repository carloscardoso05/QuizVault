package com.QuizzParty.QuizVault.services;

import com.QuizzParty.QuizVault.entities.User;
import com.QuizzParty.QuizVault.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).get();
    }
}
