/**
 * 
 */
package com.test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.model.enrity.Question;
import com.model.enrity.Quiz;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class XX {

	
	public static void main(String[] args) {
		
		
		MyInterface op1= (x,y)->x*y;
		
		MyInterface op2 = (x,y)-> x+ y ;
		
		Function<Integer, Integer> prod= x->x*2;
		Function<Integer, Integer> add= x->x+2;
		
		
		Function<Integer, Integer> rr = prod.compose(add);//
		
		Function<Integer, Integer> rr2 = prod.andThen(add);//
		
		int rs = op1.operation(3, 7);
		System.out.println(rs);
				System.out.println("**************");
	System.out.println(rr.apply(5))		;
	
	System.out.println(rr2.apply(5))		;
	
	Predicate<Integer> isp= x-> x%2==0;
	Predicate<Integer> isp2= x-> x%3==0;
	
	
	
	System.err.println(isp.test(8));
	
	
	Consumer<String> c= x->{System.out.println(x.toUpperCase());};
	String s="azerty";
	c.accept(s);
	
	Supplier<Quiz> qq =null;
		Quiz qqq = qq.get();
		
		List<Question> qst = null;
		List<Question> resq = null;
		
		int siz=qst.size();
		
		for(int i=0; i<siz;i++)
		{
			if(qst.get(i).isIsmult())
				resq.add(qst.get(i));
		}
		
		
		
		Predicate<Question> ismultiple= q->q.isIsmult();
		
		//Function<List<Question>, List<Question>> getmul=  q-> { q.get(index)};
		
		//IMultiple mm = q-> if(q.get()ismmultiple q.get()   ;
		
		qst.stream().filter(ismultiple).forEach(System.out::println);
		
		
		
	}
	
	
	
	
}
