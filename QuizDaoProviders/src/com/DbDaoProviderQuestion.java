/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.IDao2;

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
		
		//m.put(t., t)
	}

	@Override
	public T findById(K id) {
		
		return m.get(id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(m.values());
	}

	@Override
	public void delete(K id) {
		m.remove(id);
		
		
		
		
	}

	

	

	

	
}
