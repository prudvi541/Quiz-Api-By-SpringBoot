package com.example.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.Response;
import com.example.quiz.questionWrapper;
import com.example.quiz.service.QuizCreate;

@RestController
@RequestMapping("/quiz")
public class QuizService {
	@Autowired
	QuizCreate quizcreate;
	
	@PostMapping("/create")
	public ResponseEntity<String>  createquiz(@RequestParam String category,@RequestParam int numq,@RequestParam String title){
		return quizcreate.createquiz(category,numq,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<questionWrapper>> getQuizQuestion(@PathVariable Integer id){
		return quizcreate.getQuizQuestion(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
		return quizcreate.calculateresult(id,response);
	}

}
