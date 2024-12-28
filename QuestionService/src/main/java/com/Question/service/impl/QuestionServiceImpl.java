package com.Question.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question.Entity.Question;
import com.Question.Repository.QuestionRepository;
import com.Question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question saveQuestion(Question question) {
		Question savedQuestion = questionRepository.save(question);
		return savedQuestion;
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> all = questionRepository.findAll();
		return all;
	}

	@Override
	public Question getQuestionById(int id) {
		Question byId = questionRepository.findById(id).get();
		return byId;
	}

	@Override
	public List<Question> getQuestionsOfQuiz(int quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
