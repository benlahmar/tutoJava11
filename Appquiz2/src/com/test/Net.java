package com.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import com.model.enrity.Quiz;

public class Net {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException, URISyntaxException {
		// TODO Auto-generated method stub
		//getdata();
		getdatmdns();
		
	}
	
	
	
	public static void getdatmdns() throws URISyntaxException, InterruptedException, ExecutionException
	{
		ExecutorService exs=Executors.newFixedThreadPool(4);
		
		HttpClient http=HttpClient.newBuilder()
				.executor(exs)
				.version(Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		List<URI> urls=Arrays.asList(
				new URI("http://httpbin.org/get"),
				new URI("https://raw.githubusercontent.com/benlahmar/tutoJava11/master/quiz.json"),
				new URI("https://jsonplaceholder.typicode.com/users")
				);
		
		List<CompletableFuture<String>> resultats = urls.stream()
		.map(u -> http.sendAsync(HttpRequest.newBuilder(u)
				.GET()
				.setHeader("User-Agent", "moi  ")
				.build(), HttpResponse.BodyHandlers.ofString()).thenApply(r->r.body())
				).collect(Collectors.toList());
		
		for (CompletableFuture<String> c : resultats) {
			System.out.println(c.get());
			System.out.println("***************");
		}
		
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
		
	//	HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());
		
		BodyHandler<Quiz> tt=null;
		
		
		HttpResponse<Quiz> result = http.send(req, tt);
		
		
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
	
	public void post() throws IOException, InterruptedException
	{
		HttpClient http=HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		BodyPublisher data=BodyPublishers.ofString("");
		HttpRequest req=HttpRequest.newBuilder()
				.POST(data)
				.uri(URI.create(""))
				.setHeader("User-Agent", "moi  ")
				.build();
		
		HttpResponse<String> rrr = http.send(req, HttpResponse.BodyHandlers.ofString());
		
	}

}
