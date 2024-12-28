package com.Quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.Entity.Quiz;
import com.Quiz.service.QuizService;

import lombok.experimental.PackagePrivate;


@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	//save Quizzes
	@PostMapping
	public ResponseEntity<Quiz> saveQuizes(@RequestBody Quiz quiz){
		Quiz quizSaved=quizService.saveQuizes(quiz);
		return new ResponseEntity<Quiz>(quizSaved, HttpStatus.CREATED);
	}
	
	//getAll Quiz
	@GetMapping
	public ResponseEntity<List<Quiz>> getAllQuizes(){
		List<Quiz> allQuiz=quizService.getAllQuizes();
		return new ResponseEntity<List<Quiz>>(allQuiz,HttpStatus.OK);
	}
	
	// get Quiz By Id
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable Integer id ){
		Quiz quiz=quizService.getQuizById(id);
		return new ResponseEntity<Quiz>(quiz,HttpStatus.OK);
	}
	
	

}
