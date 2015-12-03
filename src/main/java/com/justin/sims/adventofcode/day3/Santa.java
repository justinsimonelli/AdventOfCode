package com.justin.sims.adventofcode.day3;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Santa {
	
	private Point currentPosition;
	private Set<Point> housesVisited = new HashSet<>();
	
	public Santa(int x, int y){
		this.currentPosition = new Point(x, y);
		this.housesVisited.add(new Point(x, y));
	}
	
	public Point getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Point currentPosition) {
		this.currentPosition = currentPosition;
	}
	public Set<Point> getHousesVisited() {
		return housesVisited;
	}
	public void setHousesVisited(Set<Point> housesVisited) {
		this.housesVisited = housesVisited;
	}

}
