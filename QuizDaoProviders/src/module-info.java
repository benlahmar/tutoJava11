


import com.CsvDapProvider;
import com.DbDaoProvider;
import com.DbDaoProviderQuiz;
import com.dao.IDao;
import com.dao.IDao2;
import com.dao.IQuizDao;

module quiz.daoprovidersmodule {
	exports com;
	
	requires quiz.dao.service;
	requires quiz.entitymodule ;
	
	provides IDao  with DbDaoProvider;
	
	provides IQuizDao with DbDaoProviderQuiz;
	
	provides IDao2 with CsvDapProvider;
	
}