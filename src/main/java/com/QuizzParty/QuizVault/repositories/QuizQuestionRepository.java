package com.QuizzParty.QuizVault.repositories;

import com.QuizzParty.QuizVault.entities.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
}
