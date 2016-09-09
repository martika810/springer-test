package com.marta.springernaturetest.strategies;

import com.marta.springernaturetest.domainbeans.Arguments;
import com.marta.springernaturetest.domainbeans.CanvasImpl;
import com.marta.springernaturetest.domainbeans.PairPointArguments;

public class LineUpdateCanvasAction implements Action{

	@Override
	public void execute(Arguments arguments) {
		PairPointArguments lineArguments = (PairPointArguments)arguments;
		CanvasImpl.getInstance().addLine(lineArguments);
		CanvasImpl.getInstance().display();
	}

}
