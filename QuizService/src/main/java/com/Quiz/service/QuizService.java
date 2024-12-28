package com.Quiz.service;

import java.util.List;

import com.Quiz.Entity.Quiz;

public interface QuizService {

	Quiz saveQuizes(Quiz quiz);

	List<Quiz> getAllQuizes();

	Quiz getQuizById(Integer id);

}
