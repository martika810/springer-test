package com.marta.springernaturetest.strategies;

import com.marta.springernaturetest.domainbeans.AreaArguments;
import com.marta.springernaturetest.domainbeans.Arguments;
import com.marta.springernaturetest.domainbeans.CanvasArguments;
import com.marta.springernaturetest.domainbeans.CanvasImpl;

public class AreaFillingUpdateAction implements Action{

	@Override
	public void execute(Arguments arguments) {
		AreaArguments areaArguments = (AreaArguments)arguments;
		CanvasImpl.getInstance().addFillingArea(areaArguments);
		CanvasImpl.getInstance().display();
		
	}

}
