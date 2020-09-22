/**
 * 
 */
package com.test;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;



import com.dao.IDao;
import com.dao.IDao2;
import com.model.User;
import com.model.enrity.Question;
import com.model.enrity.Quiz;
import com.model.enrity.Response;

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
		
		User u=new User(1, "moi", "moi");
		
		
		
		
		
		
		
		ServiceLoader<IDao> services=ServiceLoader.load(IDao.class);
		
		List<Quiz> val=null;
		Optional<IDao> ss = services.findFirst();
		if(ss.isPresent())
		{
			System.out.println(ss.getClass().getName());
			 val =ss.get().findAll();
			for (Quiz quiz : val) {
				System.out.println( quiz.toString());
				/* SortedSet<Question> qq = quiz.getQuestions();
				 
				System.out.println( "first........" +qq.first());
				Question qt=new Question(2,"ggg",true);
				
				SortedSet<Question> sss = qq.headSet(qt); 
				 System.out.println("-------"+sss.first());
				 
				Iterator<Question> tt = qq.iterator();
				while(tt.hasNext())
				{
					Question q = tt.next();
					System.out.println("----------"+q.toString());
					List<Response> rs = q.getResponses();
					for (Response r : rs) {
						System.out.println("-----------------"+r.toString());
					}
					
				}*/
			}
		}
		
		
		
		System.out.println("*************************");
	
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("entrer le id de quiz");
		int id=sc.nextInt();
		
		QuizUser qu=new QuizUser();
		
		//Map<Integer, List<Integer>> repuser=new HashMap<>();
		
		Quiz qz = val.get(id);
		qu.setU(u);
		qu.setQz(qz);
		qu.setDate(Calendar.getInstance().getTime());
		
		Iterator<Question> tt = qz.getQuestions().iterator();
		while(tt.hasNext())
		{
			Question q = tt.next();
			System.out.println(q.getIdq()+"----------"+q.getQuestion());
			List<Response> rs = q.getResponses();
			for (Response r : rs) {
				System.out.println(r.getIdr()+"-----------------"+r.getResponse());
				
			}
			System.out.println("entrer votre reponse   ");
			int res=sc.nextInt();
			q.setIdru(res);
			
		//	repuser.put(q.getIdq(), res);
			
			System.out.println("la reponse est "+res);
		}
		
		Iterator<Question> tt2 = qz.getQuestions().iterator();
		while(tt2.hasNext())
		{
			Question qt = tt2.next();
			System.out.println("les reponse a la question  :"+qt.getIdq()+"-----"+qt.getIdru());
			
		}
		
		
	/*	
		
		System.out.println("-----is multiple--------");
		Predicate<Question> ismultiple= q->q.isIsmult();
		qz.getQuestions().stream().filter(ismultiple).forEach(System.out::println);
		
		List<Question> resultats = qz.getQuestions().stream().filter(ismultiple).collect(Collectors.toList());
		
		
		qz.getQuestions().stream().map( x-> x.getIdq()).filter( v -> v<3).forEach(System.out::println);
		
*/
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
