package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.quiz.service.QuestionService;



import com.example.quiz.*;
import java.util.*;
@RestController
@RequestMapping("/questions")
public class controllerquiz {
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<question>> getAllQuestions() {
		return questionservice.getAllQuestions();
	}
	@GetMapping("/category/{category}")
	public ResponseEntity< List<question>> getQuestionByCategory(@PathVariable String category){
		
		return questionservice.getByCategory(category);
	}
	@PostMapping("/ad")
	public String add(@RequestBody   question question) {
		questionservice.add(question);
		return "success";
	}
	

}
