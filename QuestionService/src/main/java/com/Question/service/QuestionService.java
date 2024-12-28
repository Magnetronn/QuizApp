package com.Question.service;

import java.util.List;

import com.Question.Entity.Question;

public interface QuestionService {

	Question saveQuestion(Question question);

	List<Question> getAllQuestion();

	Question getQuestionById(int id);
	
	List<Question> getQuestionsOfQuiz(int quizId);

}
