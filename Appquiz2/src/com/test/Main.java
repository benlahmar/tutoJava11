/**
 * 
 */
package com.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;

import com.dao.IDao;
import com.model.Question;
import com.model.Quiz;
import com.model.Response;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Map<Integer, Quiz> qz=getdata();
		
		
		
		ServiceLoader<IDao> services=ServiceLoader.load(IDao.class);
		
	
		Optional<IDao> ss = services.findFirst();
		if(ss.isPresent())
		{
			System.out.println(ss.getClass().getName());
			List<Quiz> val =ss.get().findAll();
			for (Quiz quiz : val) {
				System.out.println( quiz.toString());
				Set<Question> qq = quiz.getQuestions();
				Iterator<Question> tt = qq.iterator();
				while(tt.hasNext())
				{
					Question q = tt.next();
					System.out.println("----------"+q.toString());
					List<Response> rs = q.getResponses();
					for (Response r : rs) {
						System.out.println("-----------------"+r.toString());
					}
					
				}
			}
		}
		
		
		
		System.out.println("gggg");
	
		
		

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
