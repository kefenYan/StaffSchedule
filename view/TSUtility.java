package com.team.view;

import java.util.*;
public class TSUtility {
	
	/*
	 * TSUtility tool class
	 * 
	 * 
	 */

	private static Scanner scanner = new Scanner(System.in);
		/*choose 1-4
		 * 
		 */
		public static char readMenuSelection() {
			char c;
			for(;;) {
				String str = readKeyBoard(1,false);
				c = str.charAt(0);
				if(c !='1'&&c!='2'&&c!='3'&&c!='4') {
					System.out.println("the wrong selection,enter again:");
				}else break;
			}
			return c;
		}
		/*Prompt and wait, instruct the user to return after pressing the enter key
		 * 
		 */
		public static void readReturn() {
			System.out.println("Press enter to continue......");
			 readKeyBoard(100,true);
		}
		
		public static char readChar(char defaultValue) {
			String str = readKeyBoard(1,true);
			return (str.length()==0) ? defaultValue:str.charAt(0);
		}
		/*
		 * Read an integer not exceeding two digits from the keyboard and return it.
		 * If there is no input, the default Value is returned.
		 */
		public static int readInt() {
			int n;
			for(;;) {
				String str = readKeyBoard(2,false);
				try {
					n = Integer.parseInt(str);
					break;
				}catch(NumberFormatException e) {
					System.out.println("the wrong number input,enter again:");
				}
			} return n;
		}
		
		
		/*
		 * Used to read ‘Y’ or ‘N’ from the keyboard and return
		 * 
		 */
		public static char readConfirmSelection() {
			char c;
			for(;;) {
				String str = readKeyBoard(1,false).toUpperCase();
				c = str.charAt(0);
				if(c=='Y'||c=='N') {
					break;
				}else {
					System.out.println("the wrong selection,enter again:");
				}
			}
			return c;
		}
		/*
		 * Read data from keyboard
		 * 
		 */
		private static String readKeyBoard(int limit,boolean blankReturn) {
			String line = "";
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				if(line.length()==0) {
					if(blankReturn) return line;
					else continue;
				}
			
				if(line.length()<1||line.length()>limit) {
					System.out.print("Input length (not greater than"+limit+")Error, please re-enter:");
					continue;
				}
				break;
			}
			return line;
		}
}
