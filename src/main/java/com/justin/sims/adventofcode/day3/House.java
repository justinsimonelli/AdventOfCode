package com.justin.sims.adventofcode.day3;

public class House {

	private int x;
	private int y;

	public House(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + this.x;
		hash = 31 * hash + this.y;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof House)){
			return false;
		}
            
		else if (obj == this) {
			return true;
		} 
		
		House house = (House)  obj;
		
		if ((house.getX() == this.getX())
				&& (house.getY() == this.getY())) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("x:" + x);
		sb.append(",y:" + y);

		return sb.toString();
	}
}
