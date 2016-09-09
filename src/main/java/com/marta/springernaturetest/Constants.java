package com.marta.springernaturetest;

public class Constants {
	private Constants(){}
	public final static String COMMAND_LINE_SEPARATOR = " ";
	public final static String ROW_CHARACTER = "-";
	public final static String COLUMN_CHARACTER = "|";
	//This represents the white space itself, not a separator
	//Having two, in case the separator for the line change, it wont impact the rest 
	//of the code
	public final static String WHITE_SPACE = " ";
	public final static String LINE_CHARACTER = "x";
}
