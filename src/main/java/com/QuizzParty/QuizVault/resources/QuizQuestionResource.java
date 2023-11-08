package com.QuizzParty.QuizVault.resources;

import com.QuizzParty.QuizVault.entities.QuizQuestion;
import com.QuizzParty.QuizVault.services.QuizQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz-questions")
public class QuizQuestionResource {
    private final QuizQuestionService service;

    public QuizQuestionResource(QuizQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<QuizQuestion>> findAll(){
        List<QuizQuestion> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizQuestion> findById(@PathVariable Long id) {
        QuizQuestion user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
