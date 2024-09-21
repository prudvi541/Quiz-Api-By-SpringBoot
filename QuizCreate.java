package com.example.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz.Response;
import com.example.quiz.question;
import com.example.quiz.questionWrapper;
import com.example.quiz.quiz;
import com.example.quiz.Doa.QuestionDoa;
import com.example.quiz.Doa.QuizDoa;



@Service
public class QuizCreate {

	@Autowired
	QuizDoa quizdoa;
	
	@Autowired
	QuestionDoa questiondoa;
              
	

	public ResponseEntity<String> createquiz(String category, int numq, String title) {
		List<question> questions=questiondoa.findRandomQuestionsByCategory(category,numq);
		quiz qu=new quiz();
		qu.setTitle(title);
		qu.setQuestions(questions);
		quizdoa.save(qu);
		return new ResponseEntity<>("succes",HttpStatus.CREATED);
	}



	public ResponseEntity<List<questionWrapper>> getQuizQuestion(Integer id) {
		
		Optional<quiz> qu=quizdoa.findById(id);
		List<question> questionfromdb=qu.get().getQuestions();
		
		List<questionWrapper> questionforuser=new ArrayList<>();
		
		for(question q:questionfromdb) {
			questionWrapper qw = new questionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()); 
		    questionforuser.add(qw);
		}
		
		
		return new ResponseEntity<List<questionWrapper>>(questionforuser,HttpStatus.OK);
		
		
	}



	public ResponseEntity<Integer> calculateresult(Integer id, List<Response> response) {
		
		quiz ques=quizdoa.findById(id).get();
		List<question> Que=ques.getQuestions();
		int right=0,i=0;
		for(Response rep:response) {
			if(rep.getResponse().equals(Que.get(i).getRigth_answer()))
			right++;
			i++;
			
		}
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}
}
