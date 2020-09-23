package com.test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Net {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		getdata();
		
		
	}
	
	public  static HttpResponse<String> getdata() throws IOException, InterruptedException, ExecutionException, TimeoutException
	{
		HttpClient http=HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		
		HttpRequest req=HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("http://httpbin.org/get"))
				.setHeader("User-Agent", "moi  ")
				.build();
		
		//HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());
		
		CompletableFuture<HttpResponse<String>> resp2 = http.sendAsync(req, HttpResponse.BodyHandlers.ofString());
		String rr = resp2.thenApply(x->x.body()).get(5, TimeUnit.SECONDS);
		System.out.println(rr);
		System.out.println("apres.........");
		
		/*System.out.println(resp.statusCode());
		HttpHeaders hh = resp.headers();
		
		hh.map().forEach((x,y)-> System.out.println(x + ":  "+y));
				
				System.out.println(resp.body());
				return resp;*/
		return null;
	}

}
