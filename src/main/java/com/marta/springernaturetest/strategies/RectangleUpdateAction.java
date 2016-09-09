package com.marta.springernaturetest.strategies;

import com.marta.springernaturetest.domainbeans.Arguments;
import com.marta.springernaturetest.domainbeans.CanvasImpl;
import com.marta.springernaturetest.domainbeans.PairPointArguments;

public class RectangleUpdateAction implements Action{

	@Override
	public void execute(Arguments arguments) {
		PairPointArguments rectangleArguments = (PairPointArguments)arguments;
		CanvasImpl.getInstance().addRectangule(rectangleArguments);
		CanvasImpl.getInstance().display();
	}

}
