package com.marta.springernaturetest.domainbeans;

import com.marta.springernaturetest.Constants;

public class PairPointArguments implements Arguments {
	private Point pointX;
	private Point pointY;
	
	private PairPointArguments(Point pointX, Point pointY) {
		this.pointX = pointX;
		this.pointY = pointY;
	}
	
	private PairPointArguments(){
		this.pointX = Point.EMPTY;
		this.pointY = Point.EMPTY;
	}

	public Point getPointX() {
		return pointX;
	}

	public Point getPointY() {
		return pointY;
	}

	public static PairPointArguments createInstance(Point pointX, Point pointY){
		return new PairPointArguments(pointX,pointY);
	}
	
	public static PairPointArguments valueOf(String commandLineText){
		String[] split = commandLineText.split(Constants.COMMAND_LINE_SEPARATOR);
		if(split.length>=5){
			Point pointX = Point.createInstance(Integer.parseInt(split[2]), Integer.parseInt(split[1]));
			Point pointY = Point.createInstance(Integer.parseInt(split[4]),Integer.parseInt(split[3]));
			return new PairPointArguments(pointX,pointY);
		}
		return new PairPointArguments();
	}
	

}
