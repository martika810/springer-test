package com.marta.springernaturetest.domainbeans;

public class Point {
	public static Point EMPTY = new Point(0,0);
	private final int x;
	private final int y;
	
	
	private Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public static Point createInstance(int x,int y){
		return new Point(x,y);
	}

}
