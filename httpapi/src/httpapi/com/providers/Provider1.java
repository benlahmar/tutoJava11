/**
 * 
 */
package httpapi.com.providers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.time.Duration;

import httpapi.com.Ihttpservice;


/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Provider1 implements Ihttpservice<HttpResponse<String>, Integer>{

	HttpClient http;
	@Override
	public HttpResponse<String> getdata(String url) {
		config();
		HttpRequest req=HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(url))
				.setHeader("User-Agent", "moi  ")
				.build();
		
		
		HttpResponse<String> res = null;
		
		try {
			res = http.send(req, HttpResponse.BodyHandlers.ofString());
			res.body();
			//convertion  vers quiz
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public HttpResponse<String> getDataById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletedata(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public void config() {
		 http=HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		
		
		
	}

}
