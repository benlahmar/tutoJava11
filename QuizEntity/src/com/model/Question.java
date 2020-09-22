/**
 * 
 */
package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Question {

	int idq;
	@Override
	public String toString() {
		return "Question [idq=" + idq + ", question=" + question + ", ismult=" + ismult + "]";
	}

	String question;
	boolean ismult;
	
	List<Response> responses=new ArrayList<Response>();

	public int getIdq() {
		return idq;
	}

	public void setIdq(int idq) {
		this.idq = idq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	

	public boolean isIsmult() {
		return ismult;
	}

	public void setIsmult(boolean ismult) {
		this.ismult = ismult;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Question(int idq, String question, boolean ismult) {
		super();
		this.idq = idq;
		this.question = question;
		this.ismult = ismult;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
