package com.rocketmiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Map<Integer, Integer> denomTable = new HashMap<Integer, Integer>();
		denomTable.put(0, 20);
		denomTable.put(1, 10);
		denomTable.put(2, 5);
		denomTable.put(3, 2);
		denomTable.put(4, 1);
		
		Map<Integer, Integer> denomTableReverse = new HashMap<Integer, Integer>();
		denomTableReverse.put(20, 0);
		denomTableReverse.put(10, 1);
		denomTableReverse.put(5, 2);
		denomTableReverse.put(2, 3);
		denomTableReverse.put(1, 4);

		Scanner in = new Scanner(System.in);

		System.out.println("ready");
		String command = "";

		CashRegister cashRegister = new CashRegister();


		do {
			String inputText = in.nextLine();
			String[] input = inputText.split(" ");
			command = input[0];
			String[] params = new String[input.length - 1];
			
			for(int j=1; j < input.length; j++) {
				params[j - 1] = input[j];
			}

			if ("show".equals(command)) {
				cashRegister.show();
			} else if ("put".equals(command)) {
				cashRegister.put(params, denomTable);
			} else if ("take".equals(command)) {
				if (cashRegister.take(params, denomTable)) {
					cashRegister.show();
				}
			} else if ("change".equals(command)) {
				cashRegister.change(Integer.parseInt(input[1]), denomTableReverse, denomTable);
			}

		} while (!"quit".equals(command));

		System.out.println("Bye");

	}

}
