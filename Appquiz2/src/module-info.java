import com.dao.IDao;

module quiz.app2 {
	exports com.test;
	
	requires quiz.entitymodule;
	requires quiz.dao.service;
	
	uses IDao;
}