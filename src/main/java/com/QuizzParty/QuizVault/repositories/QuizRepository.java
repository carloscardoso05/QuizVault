package com.QuizzParty.QuizVault.repositories;

import com.QuizzParty.QuizVault.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
