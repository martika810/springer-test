package com.marta.springernaturetest.strategies;

import com.marta.springernaturetest.domainbeans.ActionType;
import com.marta.springernaturetest.domainbeans.CommandLine;

public class ActionFactory {
	
	private ActionFactory(){}
	
	public static Action createAction(CommandLine commandLine){
		if(commandLine.getActionType()==ActionType.CANVAS){
			return new CanvasIniUpdateAction();
			
		}
		if(commandLine.getActionType() == ActionType.LINE){
			return new LineUpdateCanvasAction();
		}
		if(commandLine.getActionType() == ActionType.RECTANGULE){
			return new RectangleUpdateAction();
		}
		if(commandLine.getActionType() == ActionType.FILL_AREA){
			return new AreaFillingUpdateAction();
		}
		return null;
	}

}
