/**
 * 
 */
package com.dao;

import java.util.List;

/**
 * @author BEN LAHMAR EL HABIB
 * @param <T>
 * @param <K>
 *
 */
public interface IDao2<T, K> {
	
	public void save(T t);
	public T findById(K id);
	public List<T> findAll();
	public void delete(K id);
	

}
