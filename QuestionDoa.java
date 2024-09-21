package com.example.quiz.Doa;
import com.example.quiz.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionDoa extends JpaRepository<question, Integer> {

	List<question> findBycategory(String category);

	
	@Query(value="select * from question where question.category=:category order by random() limit :numq" , nativeQuery=true)
	List<question> findRandomQuestionsByCategory(String category, Integer numq);

	
	
}
