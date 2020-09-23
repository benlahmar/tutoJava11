/**
 * 
 */
package com.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Function;
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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//Map<Integer, Quiz> qz=getdata();
		
		User u=new User(1, "moi", "moi");
		System.out.println(LocalDateTime.now());
		
		testnio2(); 
		System.out.println("####################################");
		
		String str="gg \n pggg \nkkk";
		str.lines().map(x->x.charAt(0)).forEach(System.out::println);
		
		
		var ex=44;
		System.out.println(ex);
		var ex2 = "gggggggg";
		System.out.println(ex2);
		
		
		ServiceLoader<IDao> services=ServiceLoader.load(IDao.class);
		
		List<Quiz> val=null;
		Optional<IDao> ss = services.findFirst();
		if(ss.isPresent())
		{
			System.out.println(ss.getClass().getName());
			 val =ss.get().findAll();
			for (Quiz quiz : val) {
				System.out.println( quiz.toString());
				 SortedSet<Question> qq = quiz.getQuestions();
				 
				//System.out.println( "first........" +qq.first());
				Question qt=new Question(2,"ggg",true);
				
				SortedSet<Question> sss = qq.headSet(qt); 
				// System.out.println("-------"+sss.first());
				 
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
		
		
		
		System.out.println("*************************");
	
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("entrer le id de quiz");
		int id=sc.nextInt();
		
		QuizUser qu=new QuizUser();
		
		//Map<Integer, List<Integer>> repuser=new HashMap<>();
		
		Quiz qz = val.get(id);
		qu.setU(u);
		qu.setQz(qz);
		qu.setDate(LocalDateTime.now());
		
		Iterator<Question> tt = qz.getQuestions().iterator();
		String datarep = "";
		while(tt.hasNext())
		{
			Question q = tt.next();
			datarep+=q.getIdq()+"--rep: --";
			System.out.println(q.getIdq()+"----------"+q.getQuestion());
			List<Response> rs = q.getResponses();
			for (Response r : rs) {
				System.out.println(r.getIdr()+"-----------------"+r.getResponse()+"-----"+r.isIstrue());
				
			}
			System.out.println("entrer votre reponse   ");
			int res=sc.nextInt();
			q.setIdru(res);
			datarep+=res+";";
		//	repuser.put(q.getIdq(), res);
			
			System.out.println("la reponse est "+res);
			
		}
		
		
		Path pw=Path.of("respo.txt");
		Files.writeString(pw, qu.getU().getIdu() +"---"+qu.getDate()+"---"+qu.getQz().getIdquiz()+"---"+datarep+"\n",  StandardOpenOption.APPEND);
		
		
		qu.getresponse4user().stream().forEach(System.out::println);
		
		System.out.println("****************");
		System.out.println("******Question manquantes*********");
		qu.qmanque().stream().forEach(System.out::println);
		System.out.println("*******score*********");
		System.out.println("le resultat est     "+qu.scoreuser() +" sur "+qz.getQuestions().size());
		
		String dt = Files.readString(pw);
		 List<LocalDateTime> dates = dt.lines().map(x -> LocalDateTime.parse((x.split("---")[1]) )).collect(Collectors.toList());
		
		 
		 System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		 
		 LocalDateTime date1= LocalDateTime.parse("2020-09-23T14:32:24.116413600");
		    dt.lines().filter(x -> LocalDateTime.parse((x.split("---")[1])).isBefore(date1)).forEach(System.out::println);
		   
		  
		 
		   
		/*
		
		System.out.println("resultat    "+qu.calcscor()+"   sur "+qu.getQz().getQuestions().size());
		System.out.println(qu.calculscore2());
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
				Question qs=new Question(j, "question"+j, false);
				for(int k=1;k<5;k++)
				{
					Response r=new Response(k, "response"+k, k==2);
					qs.getResponses().add(r);
				}
				q.getQuestions().add(qs);
				
				
			}
			qz.put(i, q);
			
			
			
		}
		return qz;
	}

	
	
	
	
	public static void  testnio2()
	{
		Path path=Path.of("quiz.txt");
		Map<Quiz, Map<Question, List<Response>>> gg;
		
		String data="";
		 try {
			data=Files.readString(path);
			//construire un objet Quiz
			List<String> qq = data.lines().filter(x->x.contains("Quiz")).collect(Collectors.toList());
			
			
			List<String> qs = data.lines().filter(x-> x.contains("Question")).collect(Collectors.toList());
			
			Function<String,String> ff = s-> {if(s.contains("Quiz")) return s ; else return "";};
			
			
			
			Map<String, List<String>> resu = data.lines(). collect(Collectors.groupingBy(ff ,Collectors.toList()));
			
			//qq.forEach(System.out::println);
			
			//qs.forEach(System.out::println);
			resu.keySet() .forEach(System.out::println);
			System.out.println("**************");
			resu.values().forEach(System.out::println );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
