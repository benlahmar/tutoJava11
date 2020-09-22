/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Quiz;

/**
 * @author BEN LAHMAR EL HABIB
 * 
 *
 */
public interface IDao {

	
	public Quiz findById(int id);
	public List<Quiz> findAll();
	public Quiz save(Quiz q);
}
