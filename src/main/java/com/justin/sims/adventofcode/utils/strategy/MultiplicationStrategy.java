package com.justin.sims.adventofcode.utils.strategy;

public class MultiplicationStrategy extends AbstractListStrategy {

	@Override
	public int populateList(Integer[] dims) {
		if( dims == null || dims.length == 0 )
		{
			return -1;
		}
		
		int totalNeeded = ( ( 2 * (dims[0] * dims[1] ) ) );
		totalNeeded += ( ( 2 * (dims[1] * dims[2] ) ) );
		totalNeeded += ( ( 2 * (dims[0] * dims[2] ) ) );
		totalNeeded += ( dims[0] * dims[1] );
		
		return totalNeeded;
	}

}
