/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.IDao;
import com.model.Question;
import com.model.Quiz;
import com.model.Response;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class DbDaoProvider implements IDao {

	Map<Integer, Quiz> quizs=getdata();;
	@Override
	public Quiz findById(int id) {
		
		return quizs.get(id);
		
	}

	@Override
	public List<Quiz> findAll() {
		return new ArrayList<Quiz>(quizs.values());
		
	}

	@Override
	public Quiz save(Quiz q) {
		quizs.put(new Integer(q.getIdquiz()), q);
		return q;
	}

	public Map<Integer, Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(Map<Integer, Quiz> quizs) {
		this.quizs = quizs;
	}

	public DbDaoProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DbDaoProvider(Map<Integer, Quiz> quizs) {
		super();
		this.quizs = quizs;
	}

	
	
	public static  Map<Integer, Quiz> getdata()
	{
			Map<Integer, Quiz> qz=new HashMap<Integer, Quiz>();
		
		for(int i=1;i<5;i++)
		{
			Quiz q=new Quiz(i, "title"+i, "description"+i);
			for(int j=1;j<6;j++)
			{
				Question qs=new Question(j, "question"+j, i==2);
				for(int k=1;k<5;k++)
				{
					Response r=new Response(k, "response"+k, true);
					qs.getResponses().add(r);
				}
				q.getQuestions().add(qs);
				
				
			}
			qz.put(i, q);
			
			
			
		}
		return qz;
	}

}
