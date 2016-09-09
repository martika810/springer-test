package com.marta.springernaturetest.strategies;

import java.util.ArrayList;
import java.util.List;

import com.marta.springernaturetest.domainbeans.Arguments;
import com.marta.springernaturetest.domainbeans.CanvasArguments;
import com.marta.springernaturetest.domainbeans.CanvasImpl;

public class CanvasIniUpdateAction implements Action {

	@Override
	public void execute(Arguments arguments) {
		CanvasArguments canvasArguments = (CanvasArguments)arguments;
		CanvasImpl.getInstance().initialize(canvasArguments);
		CanvasImpl.getInstance().display();
	}

}
