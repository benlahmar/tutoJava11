/**
 * 
 */
package com.model.enrity;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class QuizConfig {

	int qc;
	boolean isreview;
	boolean isback;
	int duree;
	
	
	public int getQc() {
		return qc;
	}
	public void setQc(int qc) {
		this.qc = qc;
	}
	public boolean isIsreview() {
		return isreview;
	}
	public void setIsreview(boolean isreview) {
		this.isreview = isreview;
	}
	public boolean isIsback() {
		return isback;
	}
	public void setIsback(boolean isback) {
		this.isback = isback;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public QuizConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizConfig(int qc, boolean isreview, boolean isback, int duree) {
		super();
		this.qc = qc;
		this.isreview = isreview;
		this.isback = isback;
		this.duree = duree;
	}
	@Override
	public String toString() {
		return "QuizConfig [qc=" + qc + ", isreview=" + isreview + ", isback=" + isback + ", duree=" + duree + "]";
	}
	
	
}
