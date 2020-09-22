/**
 * 
 */
package com.test;

import java.util.Date;

import com.model.User;
import com.model.enrity.Quiz;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class QuizUser {

	int id;
	int score;
	Date date;
	
	Quiz qz;
	User u;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Quiz getQz() {
		return qz;
	}
	public void setQz(Quiz qz) {
		this.qz = qz;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	
	
	
}
