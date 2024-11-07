package com.example.quiz;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;

	@ManyToMany
    private List<question> questions;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<question> questions) {
		this.questions = questions;
	}

	
	
}
