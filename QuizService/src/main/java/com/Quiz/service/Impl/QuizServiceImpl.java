package com.Quiz.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz.Entity.Quiz;
import com.Quiz.Repository.QuizRepository;
import com.Quiz.service.QuestionClient;
import com.Quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;

	@Override
	public Quiz saveQuizes(Quiz quiz) {
		Quiz savedQuiz=quizRepository.save(quiz);
		return savedQuiz;
	}

	@Override
	public List<Quiz> getAllQuizes() {
		List<Quiz> allQuizes=quizRepository.findAll();
		
		List<Quiz> newQuizList = allQuizes.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizList;
	}

	@Override
	public Quiz getQuizById(Integer id) {
		Quiz quizbyId = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("quiz not found"));
		quizbyId.setQuestions(questionClient.getQuestionOfQuiz(quizbyId.getId()));
		return quizbyId;
	}

}
