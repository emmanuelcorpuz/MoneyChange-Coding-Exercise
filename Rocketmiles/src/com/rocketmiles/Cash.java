package com.rocketmiles;

public class Cash {

	private int count;
	private int denomination;

	public Cash() {
		
	}
	
	public Cash(int count, int denomination) {
		this.count = count;
		this.denomination = denomination;
	}
	
	
	public String toString()
	{
		return String.valueOf(count);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

}
