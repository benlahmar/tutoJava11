/**
 * 
 */
package com.model.enrity;

import java.util.ArrayList;

import java.util.List;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Question {

	int idq;
	String question;
	boolean ismult;
	
	int idru;
	

	@Override
	public String toString() {
		return "Question [idq=" + idq + ", question=" + question + ", ismult=" + ismult + ", idru=" + idru + "]";
	}

	List<Response> responses=new ArrayList<Response>();
	
	public int getIdru() {
		return idru;
	}

	public void setIdru(int idru) {
		this.idru = idru;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idq;
		result = prime * result + (ismult ? 1231 : 1237);
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return idq;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (idq != other.idq)
			return false;
		else
		return true;
	}

	

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
