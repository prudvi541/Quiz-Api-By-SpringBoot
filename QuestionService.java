package com.example.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.quiz.Doa.QuestionDoa;
import java.util.*;
import com.example.quiz.question;


@Service
public class QuestionService {
	
	@Autowired
	QuestionDoa questiondoa;
	
	public ResponseEntity<List<question>> getAllQuestions() {
		return  new ResponseEntity<>(questiondoa.findAll(),HttpStatus.OK);
	}

	public  ResponseEntity<List<question>> getByCategory(String category) {
		// TODO Auto-generated method stub
		return  new ResponseEntity<>(questiondoa.findBycategory(category),HttpStatus.OK);
	}

	public ResponseEntity< String> add(question question) {
		questiondoa.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}

	
}
