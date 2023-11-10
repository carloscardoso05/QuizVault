package com.QuizzParty.QuizVault.repositories;

import com.QuizzParty.QuizVault.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
