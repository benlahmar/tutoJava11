
import com.CsvDapProvider;
import com.DbDaoProvider;
import com.dao.IDao;

module quiz.daoprovidersmodule {
	exports com;
	
	requires quiz.dao.service;
	requires quiz.entitymodule ;
	
	provides IDao  with DbDaoProvider,CsvDapProvider;
}