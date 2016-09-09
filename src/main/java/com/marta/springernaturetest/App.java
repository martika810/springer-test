package com.marta.springernaturetest;

import java.util.Scanner;

import com.marta.springernaturetest.domainbeans.CommandLine;
import com.marta.springernaturetest.strategies.ActionFactory;
import com.marta.springernaturetest.strategies.CanvasIniUpdateAction;


public class App {
	public static final String QUIT_COMMAND = "Q";
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter command:");
		String commandLineText = scanner.nextLine();
		
		while (!commandLineText.equals(QUIT_COMMAND)) {
			CommandLine commandLine = CommandLine.valueOf(commandLineText);
			if (!(commandLine.isEmpty())) {
				commandLine.draw(ActionFactory.createAction(commandLine));
			}
			System.out.println("Enter command:");
			commandLineText = scanner.nextLine();
		}

	}
}
