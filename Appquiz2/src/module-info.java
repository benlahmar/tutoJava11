import com.dao.IDao;
import com.dao.IDao2;
import com.dao.IQuizDao;

module quiz.app2 {
	exports com.test;
	

	requires quiz.dao.service;
	
	requires quiz.daoprovidersmodule;
	
	requires usermodule;
	
	requires quiz.entitymodule;
	requires jdk.internal.le;
	requires json.simple;
	requires java.net.http;
	uses IDao;
	uses IDao2;
	uses IQuizDao;
}