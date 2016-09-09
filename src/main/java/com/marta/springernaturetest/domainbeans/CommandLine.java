package com.marta.springernaturetest.domainbeans;

import com.marta.springernaturetest.Constants;
import com.marta.springernaturetest.strategies.Action;

public class CommandLine {
	
	public final static CommandLine EMPTY = new CommandLine(ActionType.EMPTY,null);
	private final static String SEPARATOR = " ";
	private final ActionType actionType;
	private final Arguments arguments;

	private CommandLine(ActionType actionType, Arguments arguments) {
		this.actionType = actionType;
		this.arguments = arguments;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public Arguments getArguments() {
		return arguments;
	}

	public void draw(Action updateAction) {
		updateAction.execute(arguments);
	}
	
	public boolean isEmpty(){
		return EMPTY.equals(this);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result
				+ ((arguments == null) ? 0 : arguments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof CommandLine)
			return false;
		CommandLine other = (CommandLine) obj;
		if (actionType != other.actionType)
			return false;
		if (arguments == null) {
			if (other.arguments != null)
				return false;
		} else if (!arguments.equals(other.arguments))
			return false;
		return true;
	}

	public static CommandLine valueOf(String commandText) {
		if (!commandText.isEmpty()) {
			String[] split = commandText
					.split(Constants.COMMAND_LINE_SEPARATOR);
			ActionType actionType = ActionType.valueOf(split[0].charAt(0));
			Arguments arguments = ArgumentFactory.createArgument(actionType,
					commandText);
			return new CommandLine(actionType, arguments);
		}
		return EMPTY;
	}

	private static class ArgumentFactory {
		private ArgumentFactory() {
		}

		private static Arguments createArgument(ActionType actionType,
				String commandText) {
			if (actionType == ActionType.LINE) {
				return PairPointArguments.valueOf(commandText);
			}
			if (actionType == ActionType.CANVAS) {
				return CanvasArguments.valueOf(commandText);
			}
			if (actionType == ActionType.RECTANGULE) {
				return PairPointArguments.valueOf(commandText);
			}
			if (actionType == ActionType.FILL_AREA) {
				return AreaArguments.valueOf(commandText);
			}
			return null;

		}
	}

}
