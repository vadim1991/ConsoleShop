package com.epam.Vadym_Vlasenko.eShop.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Util {

	private static final String MESSAGE_ERROR = "You entered incorrectly value";

	private static Scanner scanner = new Scanner(System.in);

	public static void print(String message) {
		System.out.println(message);
	}

	public static void printError(String message) {
		System.err.println(message);
	}

	public static int getInt(String message) {
		print(message);
		int result = 0;
		while (scanner.hasNext()) {
			try {
				result = Integer.parseInt(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				printError(MESSAGE_ERROR);
			}
		}
		return result;
	}

	public static double getDouble(String message) {
		print(message);
		double result = 0;
		while (scanner.hasNext()) {
			try {
				result = Double.parseDouble(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				printError(MESSAGE_ERROR);
			}
		}
		return result;
	}

	public static String getString(String message) {
		print(message);
		String result = null;
		while (scanner.hasNext()) {
			result = scanner.nextLine();
			if (!result.isEmpty()) {
				return result;
			}
		}
		return result;
	}

	public static Date getDate(String message) {
		print(message);
		print("for example - 19.03.2015");
		SimpleDateFormat sd = new SimpleDateFormat("dd.mm.yyyy");
		Date date = null;
		while (scanner.hasNext()) {
			try {
				date = sd.parse(scanner.nextLine());
				return date;
			} catch (ParseException e) {
				printError(MESSAGE_ERROR);
			}
		}
		return date;
	}

}
