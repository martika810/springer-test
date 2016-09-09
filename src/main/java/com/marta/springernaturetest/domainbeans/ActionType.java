package com.marta.springernaturetest.domainbeans;

public enum ActionType {
	CANVAS('C'),
	LINE('L'),
	RECTANGULE('R'),
	FILL_AREA('B'),
	EMPTY('e');
	
	
	private char character;
	private ActionType(char character){
		this.character =character;
	}
	
	public static ActionType valueOf(char character){
		if(character == 'C'){
			return CANVAS;
		}
		if(character == 'L'){
			return LINE;
		}
		if(character == 'R'){
			return RECTANGULE;
		}
		if(character == 'B'){
			return FILL_AREA;
		}
		return EMPTY;
	}
}
