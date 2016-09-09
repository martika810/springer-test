package com.marta.springernaturetest.domainbeans;

import com.marta.springernaturetest.Constants;


public class CanvasArguments implements Arguments {
	public final static CanvasArguments EMPTY = new CanvasArguments(-1,-1);

	private final int numCols;
	private final int numRows;
	
	private CanvasArguments(int cols,int rows){
		this.numCols = cols;
		this.numRows = rows;
	}

	public int getNumCol() {
		return numCols;
	}


	public int getNumRows() {
		return numRows;
	}

	public static CanvasArguments createInstance(int[] dimensions){
		if(dimensions.length>=2){
			return new CanvasArguments(dimensions[0], dimensions[1]);
		}
		else{
			return EMPTY;
		}
	}
	
	public static CanvasArguments valueOf(String commandText){
		String[] split = commandText.split(Constants.COMMAND_LINE_SEPARATOR);
		if(split.length>=3){
			return new CanvasArguments(Integer.parseInt(split[1]),Integer.parseInt(split[2]));
		}
		return EMPTY;
	}
	
	
}
