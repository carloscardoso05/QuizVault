package com.QuizzParty.QuizVault.services;

import com.QuizzParty.QuizVault.entities.Answer;
import com.QuizzParty.QuizVault.entities.QuizQuestion;
import com.QuizzParty.QuizVault.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private AnswerRepository repository;

    public AnswerService(AnswerRepository repository) {
        this.repository = repository;
    }

    public List<Answer> findByQuizQuestion(QuizQuestion quizQuestion) {
        return repository.findAll();
    }
}
