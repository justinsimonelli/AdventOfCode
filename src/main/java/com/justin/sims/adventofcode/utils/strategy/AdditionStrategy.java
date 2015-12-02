package com.justin.sims.adventofcode.utils.strategy;

import java.util.concurrent.atomic.AtomicInteger;

public class AdditionStrategy extends AbstractListStrategy {

	@Override
	public int populateList(Integer[] dims) {
		if( dims == null || dims.length == 0 )
		{
			return -1;
		}
		
		AtomicInteger totalNeeded = new AtomicInteger(0);
		
		
		return totalNeeded.get();
	}

}
