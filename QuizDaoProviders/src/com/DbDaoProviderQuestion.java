/**
 * 
 */
package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.IDao2;
import com.model.Question;
import com.model.Quiz;

/**
 * @author BEN LAHMAR EL HABIB
 * @param <T>
 * @param <K>
 *
 */
public class DbDaoProviderQuestion<T, K> implements IDao2<T, K>{

	Map<K, T> m=new HashMap<K, T>();

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(K id) {
		// TODO Auto-generated method stub
		
	}

	

	

	

	
}
