package com.marta.springernaturetest;

import org.junit.Test;

import com.marta.springernaturetest.domainbeans.CommandLine;
import com.marta.springernaturetest.strategies.CanvasIniUpdateAction;

public class TestCanvasDrawAction {
	
	@Test
	public void testDraw(){
		String commandLineText = "C 10 5";
		CommandLine commandLine = CommandLine.valueOf(commandLineText);
		commandLine.draw(new CanvasIniUpdateAction());
		
	}

}
