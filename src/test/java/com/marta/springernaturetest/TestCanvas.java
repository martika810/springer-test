package com.marta.springernaturetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marta.springernaturetest.domainbeans.AreaArguments;
import com.marta.springernaturetest.domainbeans.Canvas;
import com.marta.springernaturetest.domainbeans.CanvasArguments;
import com.marta.springernaturetest.domainbeans.CanvasImpl;
import com.marta.springernaturetest.domainbeans.CommandLine;
import com.marta.springernaturetest.domainbeans.PairPointArguments;

public class TestCanvas {
	
	@Test
	public void testInitializeCanvas(){
		String commandLineText = "C 20 4";
		CommandLine commandLine = CommandLine.valueOf(commandLineText);
		
		Canvas canvas = CanvasImpl.getInstance();
		canvas.initialize((CanvasArguments) commandLine.getArguments());
		canvas.display();
		
		char[][] matrix =canvas.getMatrixRepresentation();
		assertEquals("----------------------",extractRow(0, matrix));
		assertEquals("|                    |",extractRow(1, matrix));
		assertEquals("|                    |",extractRow(2, matrix));
		assertEquals("|                    |",extractRow(3, matrix));
		assertEquals("|                    |",extractRow(4, matrix));
		assertEquals("----------------------",extractRow(5, matrix));
		
	}
	
	@Test
	public void testAddLine(){
		String commandLineText = "C 20 4";
		CommandLine commandLine = CommandLine.valueOf(commandLineText);
		
		Canvas canvas = CanvasImpl.getInstance();
		canvas.initialize((CanvasArguments) commandLine.getArguments());
		
		commandLineText = "L 1 2 6 2";
		CommandLine addLineCommand = CommandLine.valueOf(commandLineText);
		canvas.addLine((PairPointArguments) addLineCommand.getArguments());
		canvas.display();
		char[][] matrix =canvas.getMatrixRepresentation();
		assertEquals("----------------------",extractRow(0, matrix));
		assertEquals("|                    |",extractRow(1, matrix));
		assertEquals("|xxxxxx              |",extractRow(2, matrix));
		assertEquals("|                    |",extractRow(3, matrix));
		assertEquals("|                    |",extractRow(4, matrix));
		assertEquals("----------------------",extractRow(5, matrix));
	
		
		commandLineText = "L 6 3 6 4";
		addLineCommand = CommandLine.valueOf(commandLineText);
		canvas.addLine((PairPointArguments) addLineCommand.getArguments());
		canvas.display();
		matrix =canvas.getMatrixRepresentation();
		assertEquals("----------------------",extractRow(0, matrix));
		assertEquals("|                    |",extractRow(1, matrix));
		assertEquals("|xxxxxx              |",extractRow(2, matrix));
		assertEquals("|     x              |",extractRow(3, matrix));
		assertEquals("|     x              |",extractRow(4, matrix));
		assertEquals("----------------------",extractRow(5, matrix));
	}
	
	@Test
	public void testAddRectangule(){
		String commandCanvasText = "C 5 3";
		CommandLine commandLine = CommandLine.valueOf(commandCanvasText);
		
		Canvas canvas = CanvasImpl.getInstance();
		canvas.initialize((CanvasArguments) commandLine.getArguments());
		
		String commandRectanguleText = "R 1 1 3 3";
		CommandLine addRectanguleCommand = CommandLine.valueOf(commandRectanguleText);
		canvas.addRectangule((PairPointArguments) addRectanguleCommand.getArguments());
		
		char[][] matrix =canvas.getMatrixRepresentation();
		assertEquals("-------",extractRow(0, matrix));
		assertEquals("|xxx  |",extractRow(1, matrix));
		assertEquals("|x x  |",extractRow(2, matrix));
		assertEquals("|xxx  |",extractRow(3, matrix));
		assertEquals("-------",extractRow(4, matrix));
		
	}
	@Test
	public void testAddFillingArea(){
		String commandLineText = "C 20 4";
		CommandLine commandLine = CommandLine.valueOf(commandLineText);
		
		Canvas canvas = CanvasImpl.getInstance();
		canvas.initialize((CanvasArguments) commandLine.getArguments());
		
		commandLineText = "L 1 2 6 2";
		CommandLine addLineCommand = CommandLine.valueOf(commandLineText);
		canvas.addLine((PairPointArguments) addLineCommand.getArguments());
		canvas.display();
		
		commandLineText = "L 6 3 6 4";
		addLineCommand = CommandLine.valueOf(commandLineText);
		canvas.addLine((PairPointArguments) addLineCommand.getArguments());
		canvas.display();
		
		
		String commandFillingAreaText = "B 10 3 o";
		CommandLine fillAreaCommand = CommandLine.valueOf(commandFillingAreaText);
		canvas.addFillingArea((AreaArguments) fillAreaCommand.getArguments());
		canvas.display();
		
		char[][] matrix =canvas.getMatrixRepresentation();
		assertEquals("----------------------",extractRow(0, matrix));
		assertEquals("|oooooooooooooooooooo|",extractRow(1, matrix));
		assertEquals("|xxxxxxoooooooooooooo|",extractRow(2, matrix));
		assertEquals("|     xoooooooooooooo|",extractRow(3, matrix));
		assertEquals("|     xoooooooooooooo|",extractRow(4, matrix));
		assertEquals("----------------------",extractRow(5, matrix));
		
		
		
	}
	
	public static String extractRow(int rowNum,char[][] matrix){
		int matrixColumns = matrix[0].length;
		StringBuilder line = new StringBuilder();
		for(int i=0;i<matrixColumns;i++){
			line.append(String.valueOf(matrix[rowNum][i]));
		}
		return line.toString();
	}

}
