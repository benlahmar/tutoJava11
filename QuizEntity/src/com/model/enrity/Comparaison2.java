/**
 * 
 */
package com.model.enrity;

import java.util.Comparator;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Comparaison2 implements Comparator<Question>{

	@Override
	public int compare(Question o1, Question o2) {

		if((o1.ismult && o2.ismult) || (!o1.ismult && !o2.ismult))
			return 0;
		else
		if(o1.ismult && !o2.ismult)
			return 1;
		else
			return -1;
		
	}

}
