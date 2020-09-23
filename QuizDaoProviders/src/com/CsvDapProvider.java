/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.dao.IDao2;
import com.model.enrity.Quiz;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class CsvDapProvider implements IDao2<Quiz, Integer> {


	Map<Integer, Quiz> quizs=new HashMap<Integer, Quiz>();
	
	@Override
	public void save(Quiz t) {
		quizs.put(t.getIdquiz(), t);
		
	}

	@Override
	public Quiz findById(Integer id) {
		// TODO Auto-generated method stub
		return quizs.get(id);
	}

	@Override
	public List<Quiz> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(quizs.values());
	}

	@Override
	public void delete(Integer id) {
		quizs.remove(id);
		
	}

	public Map<Integer, Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(Map<Integer, Quiz> quizs) {
		this.quizs = quizs;
	}
	
}
