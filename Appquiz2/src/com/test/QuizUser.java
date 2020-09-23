/**
 * 
 */
package com.test;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import com.model.User;
import com.model.enrity.Question;
import com.model.enrity.Quiz;
import com.model.enrity.Response;




/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class QuizUser {

	int id;
	int score;
	LocalDateTime date;
	
	Quiz qz;
	User u;
	
	
	public  Map<Integer, List<Integer>> getresponse()
	{
		Map<Integer, List<Integer>> res = qz.getQuestions().stream()
			
			.collect(Collectors.groupingBy(Question::getIdq, Collectors.mapping(Question::getIdru, Collectors.toList())));
		return res;
		
	}
	
	public long scoreuser()
	{
		
	  List<Long> nb = qz.getQuestions().stream()
		.map(x -> x.getResponses().stream().filter(r -> r.isIstrue() && r.getIdr() == x.getIdru()).count() 
				).
		collect(Collectors.toList());
	 
	 long z=nb.stream().reduce((  var x, var y)->x+y).get();
		
	 
				;
		return z;
	}
	
	
	public long scoreuser2()
	{
		 long r = qz.getQuestions().stream()
				.map(x->x.getResponses().stream().anyMatch(y->y.isIstrue() && y.getIdr()==x.getIdru())).count();
		return 0;
	}
	
	public  List<Question>  qmanque()
	{
		
		List<Question> r = qz.getQuestions().stream()
				.filter(x-> x.getIdru()==0).collect(Collectors.toList());
		return r;
	}
	
	
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
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
	
	
	public List<Integer> getresponse4user()
	{
		return qz.getQuestions().stream().map(x -> x.getIdru() ).collect(Collectors.toList());
		 
		
		  
	}
	//question just   reponse istrue=true et idrep= idru   // istrue=false et idrep != idru
	public int calcscor()
	{
		
	  
	Predicate<? super Question> predicate= s->s.getResponses().stream().anyMatch(t->t.isIstrue() && t.getIdr()==s.getIdru());
	
	List<Question> res = qz.getQuestions().stream()
		.filter(x->!x.isIsmult()).filter(predicate).collect(Collectors.toList());
		
		
		
		return res.size();
	}
	
	public long calculscore2()
	{
		 
		 Function<Question,Long> mapper = x->x.getResponses().stream().filter(s->s.isIstrue() && s.getIdr()==x.getIdru()).count();
		 
		 long res = qz.getQuestions().stream().map(mapper).filter(x->x!=0).count();
				  
		  
		  
		
		return res;
	}
	
	
	
}
