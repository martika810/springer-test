package com.marta.springernaturetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marta.springernaturetest.domainbeans.ActionType;
import com.marta.springernaturetest.domainbeans.CanvasArguments;
import com.marta.springernaturetest.domainbeans.CommandLine;
import com.marta.springernaturetest.domainbeans.PairPointArguments;

public class TestCommandLine {
	
	@Test
	public void testValueOfCanvasCase() {
		String commandLineText = "C 5 10";
		CommandLine commandLine = CommandLine.valueOf(commandLineText);
		assertEquals(ActionType.CANVAS, commandLine.getActionType());
		CanvasArguments arguments = (CanvasArguments) commandLine.getArguments();
		assertEquals(5,arguments.getNumCol());
		assertEquals(10,arguments.getNumRows());
		
	}
	
	@Test 
	public void testValueOfEmptyCase(){
		CommandLine commandLine = CommandLine.valueOf("");
		assertEquals(ActionType.EMPTY, commandLine.getActionType());
	}

	@Test
	public void testValueOfLineCase(){
		String commandLineTest = "L 1 2 6 2";
		CommandLine commandLine = CommandLine.valueOf(commandLineTest);
		assertEquals(ActionType.LINE, commandLine.getActionType());
		PairPointArguments arguments = (PairPointArguments) commandLine.getArguments();
		assertEquals(2,arguments.getPointX().getX());
		assertEquals(1,arguments.getPointX().getY());
		assertEquals(2,arguments.getPointY().getX());
		assertEquals(6,arguments.getPointY().getY());
		
		
	}
	
	@Test
	public void testValueOfRectangulecase(){
		String commandLineTest = "R 1 2 6 2";
		CommandLine commandLine = CommandLine.valueOf(commandLineTest);
		assertEquals(ActionType.RECTANGULE, commandLine.getActionType());
		PairPointArguments arguments = (PairPointArguments) commandLine.getArguments();
		assertEquals(2,arguments.getPointX().getX());
		assertEquals(1,arguments.getPointX().getY());
		assertEquals(2,arguments.getPointY().getX());
		assertEquals(6,arguments.getPointY().getY());
	}
}
