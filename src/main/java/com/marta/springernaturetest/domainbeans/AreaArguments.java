package com.marta.springernaturetest.domainbeans;

import com.marta.springernaturetest.Constants;

public class AreaArguments implements Arguments{
	public final static AreaArguments EMPTY = new AreaArguments(-1, -1, 'x');
	private final int begin;
	private final int end;
	private final char character;
	
	public AreaArguments(int begin, int end, char character) {
		this.begin = begin;
		this.end = end;
		this.character = character;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	public char getCharacter() {
		return character;
	}
	
	public static AreaArguments createInstance(int begin,int end,char character){
		return new AreaArguments(begin,end,character);
	}
	
	public static AreaArguments valueOf(String commandLineText){
		String[] split = commandLineText.split(Constants.COMMAND_LINE_SEPARATOR);
		if(split.length>=4){
			int begin = Integer.parseInt(split[2]);
			int end = Integer.parseInt(split[1]);
			char character = split[3].toCharArray()[0];
			return createInstance(begin,end,character);
		}
		return EMPTY;
	}
	
	
	

}
