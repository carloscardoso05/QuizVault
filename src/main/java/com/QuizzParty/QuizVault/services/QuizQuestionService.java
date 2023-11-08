package com.QuizzParty.QuizVault.services;

import com.QuizzParty.QuizVault.entities.QuizQuestion;
import com.QuizzParty.QuizVault.repositories.QuizQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {
    private final QuizQuestionRepository repository;

    public QuizQuestionService(QuizQuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuizQuestion> findAll() {
        return repository.findAll();
    }

    public QuizQuestion findById(Long id) {
        return repository.findById(id).get();
    }
}
