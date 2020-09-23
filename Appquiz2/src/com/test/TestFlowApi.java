package com.test;

import java.util.List;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class TestFlowApi {

	public static void main(String args[]) {
	      List<String> items = List.of("1", "2", "bla bla 3", "4", "5", "6", "7", "8", "9", "10");
	      
	      
	      SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
	      
	      MySubscriber s1 = new MySubscriber<>();
	      s1.setNom("process1");
	      publisher.subscribe(s1);
	      
	      MySubscriber s2 = new MySubscriber<>();
	      s2.setNom("process2");
	      publisher.subscribe(s2);
	      
	    
	      ProcFlow<String, String > p=new ProcFlow();
	      
	      
	      items.forEach(s -> {
	         try {
	            Thread.sleep(1000);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	       
	         publisher.submit(s);
	         System.out.println("le publiser a publier "+s);
	      });
	      publisher.submit("une autre chose");
	      
	      publisher.close();
	   }
}
