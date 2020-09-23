/**
 * 
 */
package com.test;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
import java.util.concurrent.Flow;


class MySubscriber<T> implements Flow.Subscriber<T> {
	

	   private Flow.Subscription subscription;
	   String nom;
	   public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	   public void onSubscribe(Flow.Subscription subscription) {
	      this.subscription = subscription;
	      this.subscription.request(1);
	      System.out.println("subscription...........");
	   }
	   @Override
	   public void onNext(T item) {
	      System.out.println("recuperation de "+item+"   par "+nom);
	      subscription.request(1);
	   }
	   @Override
	   public void onError(Throwable throwable) {
	      throwable.printStackTrace();
	   }
	   @Override
	   public void onComplete() {
	      System.out.println("Done fin de publisher");
	   }
	
}