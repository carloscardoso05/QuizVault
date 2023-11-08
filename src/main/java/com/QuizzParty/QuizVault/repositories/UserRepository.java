package com.QuizzParty.QuizVault.repositories;

import com.QuizzParty.QuizVault.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
