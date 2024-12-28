package com.Question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question.Entity.Question;
import com.Question.service.QuestionService;import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	//save question
	@PostMapping
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
		Question questionSaved=questionService.saveQuestion(question);
		return new ResponseEntity<Question>(questionSaved,HttpStatus.CREATED);
	}
	
	//get All Question
	@GetMapping
	public ResponseEntity<List<Question>>getAllQuestion(){
		List<Question> allQuestions= questionService.getAllQuestion();
		return new ResponseEntity<List<Question>>(allQuestions,HttpStatus.OK);
	}
	
	//get By Id
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int id){
		Question ById=questionService.getQuestionById(id);
		return new ResponseEntity<Question>(ById,HttpStatus.OK);
	}
	
	//get All Question of Specific Quiz
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable int quizId){
		return questionService.getQuestionsOfQuiz(quizId);
	}
	

}
