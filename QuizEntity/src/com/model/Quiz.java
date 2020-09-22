/**
 * 
 */
package com.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Quiz {

	int idquiz;
	

	String title,description;
	
	Set<Question> questions=new HashSet<Question>();
	
	QuizConfig conf;

	
	
	public QuizConfig getConf() {
		return conf;
	}

	public void setConf(QuizConfig conf) {
		this.conf = conf;
	}

	public int getIdquiz() {
		return idquiz;
	}

	public void setIdquiz(int idquiz) {
		this.idquiz = idquiz;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Quiz(int idquiz, String title, String description) {
		super();
		this.idquiz = idquiz;
		this.title = title;
		this.description = description;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quiz [idquiz=" + idquiz + ", title=" + title + ", description=" + description + "]";
	}
	
}
