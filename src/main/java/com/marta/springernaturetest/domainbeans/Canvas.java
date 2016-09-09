package com.marta.springernaturetest.domainbeans;

import java.util.List;

public interface Canvas {
	
	public void initialize(CanvasArguments dimensions);
	public void addLine(PairPointArguments points);
	public void addRectangule(PairPointArguments points);
	public void addFillingArea(AreaArguments area);
	public void display();
	public char[][] getMatrixRepresentation();

}
