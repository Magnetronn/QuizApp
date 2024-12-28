package com.Question.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
 
	List<Question> findByQuizId(int quizId);
}
