/**
*
* Created by jcpatac on 9/16/16.
*
**/

import java.util.*;
import java.lang.*;
import java.io.*;

public class PakGanern {

	public static void main(String[] args) {
		pakGanern3();
	}

	public static void pakGanern3() {
		int score = 0;
		int x = 1;
		System.out.println("\nPlayer 1, Enter P for Pak!");
		System.out.println("Player 2, Enter G for Ganern!");
		System.out.println("\nGame starts in 5 seconds!");

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("");
		System.out.println("START!");
		System.out.println("");
		System.out.println("PAK!");

		while (x < Integer.MAX_VALUE) {
			System.out.println("");
			System.out.print("\nPlayer 1: ");
			Scanner sc1 = new Scanner(System.in);
			String strPak1 = sc1.next();

			if (occurP(strPak1) == x && occurG(strPak1) == 0) {
				printPak(x);
				System.out.println("");
				System.out.print("\nPlayer 2: ");
				Scanner sc2 = new Scanner(System.in);
				String strGanern2 = sc2.next();

				if (occurG(strGanern2) == x && occurP(strGanern2) == 0) {
					printGanern(x);
				}else {
					System.out.println("\nGAME OVER!\nPlayer 1 wins!");
					System.out.print("Try Again? (Y/N): ");
					Scanner again = new Scanner(System.in);
					String tryAgain = again.next();

					if (tryAgain.equals("Y") || tryAgain.equals("y")) {
						char c = '\n';
						int length = 25;
						char[] chars = new char[length];
						Arrays.fill(chars, c);
						System.out.print(String.valueOf(chars));
						pakGanern3();
					}else {
						System.exit(0);
					}
				}
			}else {
				System.out.println("\nGAME OVER!\nPlayer 2 wins!");
				System.out.print("Try Again? (Y/N): ");
				Scanner again = new Scanner(System.in);
				String tryAgain = again.next();

				if (tryAgain.equals("Y") || tryAgain.equals("y")) {
					char c = '\n';
					int length = 25;
					char[] chars = new char[length];
					Arrays.fill(chars, c);
					System.out.print(String.valueOf(chars));
					pakGanern3();
				}else {
					System.exit(0);
				}
			}
			x++;
		}
	}

	public static int occurP(String str) {
		int occurCount = (str.length() - str.replaceAll("p", "").length()) + (str.length() - str.replaceAll("P", "").length());
		return occurCount;
	}

	public static int occurG(String str) {
		int occurCount = (str.length() - str.replaceAll("g", "").length()) + (str.length() - str.replaceAll("G", "").length());
		return occurCount;
	}

	public static void printPak(int n) {
		if (n > 0) {
			System.out.print("PAK! ");
			printPak(n - 1);
		}
	}
	public static void printGanern(int n) {
		if (n > 0) {
			System.out.print("GANERN! ");
			printGanern(n - 1);
		}
	}
}

/**
*
* There are two ways to write error-free programs; only the third one works. – Alan J. Perlis
*
**/
