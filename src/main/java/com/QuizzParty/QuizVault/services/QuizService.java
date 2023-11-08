package com.QuizzParty.QuizVault.services;

import com.QuizzParty.QuizVault.entities.Quiz;
import com.QuizzParty.QuizVault.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public List<Quiz> findAll() {
        return repository.findAll();
    }

    public Quiz findById(Long id) {
        return repository.findById(id).get();
    }
}
