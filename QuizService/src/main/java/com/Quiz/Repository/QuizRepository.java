package com.Quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Quiz.Entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	
}
