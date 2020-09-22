/**
 * 
 */
package com.model.enrity;

import java.util.Comparator;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Comparaison1 implements Comparator<Question>{

	@Override
	public int compare(Question o1, Question o2) {
		
		return o1.getIdq()-o2.getIdq();
		
		
	}

}
