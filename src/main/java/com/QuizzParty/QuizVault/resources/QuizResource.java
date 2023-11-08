package com.QuizzParty.QuizVault.resources;

import com.QuizzParty.QuizVault.entities.Quiz;
import com.QuizzParty.QuizVault.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quizes")
public class QuizResource {
    private final QuizService service;

    public QuizResource(QuizService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> findAll(){
        List<Quiz> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> findById(@PathVariable Long id) {
        Quiz user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
