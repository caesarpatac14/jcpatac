/**
*
* Created by jcpatac on 9/14/16.
*
**/

import java.io.*;
import java.util.*;
import java.lang.*;

public class TofN {
	public static void main (String[] args) {
        teeOfEn();
	}

    public static void teeOfEn() {
        System.out.print("Enter the file name: ");
        Scanner scan = new Scanner(System.in);
        String file = scan.next();
        System.out.println("");
        String line = null;
        String space = " ";
        String brace = "}";
        String upper = "";
        int upperInt = 0;
        String lower = "";
        int lowerInt = 0;
        String init = "";
        String iterator = "";
        String operator = "";
        String condCount = "";
        int processCounter = 0;
        int extraCounter = 0;

        try {
            FileReader readFile = new FileReader(file);

            BufferedReader read = new BufferedReader(readFile);

            while ((line = read.readLine()) != null) {
                StringTokenizer strToken = new StringTokenizer(line, "();{\t");
                while (strToken.hasMoreTokens()) {
                    String token = new String(strToken.nextToken());
                    if (token.contains(brace)) {
                        String upperBound = "";
                        upperBound = upperBoundGetterStr(upper, condCount, operator);

                        if (isInteger(upperBound) && isInteger(lower)) {
                            upperInt = Integer.parseInt(upperBound);
                            lowerInt = Integer.parseInt(lower);
                            if (upperInt < lowerInt) {
                                if (iterator.equals("--") || iterator.equals("-")) {
                                    System.out.println("T(n) = Infinite");
                                }else {
                                    System.out.println("T(n) = " + extraCounter);
                                }
                            }else {
                                System.out.println("T(n) = " + intSolver(upperInt, lowerInt, processCounter, extraCounter));
                            }
                        }else if (isChar(lower)) {
                            System.out.println("T(n) = " + extraCounter);
                        }else if (isChar(upperBound) && isInteger(lower) && iterator.equals("--")) {
                            System.out.println("T(n) = Infinite");
                        }else {
                            lowerInt = Integer.parseInt(lower);
                            System.out.println("T(n) = " + strSolver(upperBound, lowerInt, processCounter, extraCounter));
                        }
                        processCounter = 0;
                        extraCounter = 0;
                        System.out.println("");

                    }else if (token.contains("for")) {
                        //do nothing
                    }else if (((line.contains("for")) && ((!(token.contains("<"))) || 
                             (!(token.contains(">"))) || (token.equals(space) == false))) && 
                             (token.contains("int"))) {
                        init = getLastWord(token);
                        extraCounter += operatorCount(token);
                    }

                    else if ((line.contains("for")) &&
                                            ((token.contains("+")) ||
                                            (token.contains("-")) ||
                                            (token.contains("*")) ||
                                            (token.equals(space) == false) || 
                                            (token.contains("/"))) && (!(token.contains("<") || 
                                            (token.contains(">"))))) {

                        processCounter += operatorCount(token);

                        if ((token.contains("++")) || (token.contains("--"))) {
                            operator = "1";
                            if (token.contains("++")) {
                                iterator = "++";
                            }else {
                                iterator = "--";
                            }
                        }else if (token.contains("=")) {
                            if ((token.contains("-")) || (token.contains("+"))) {
                                operator = getLastWord(token);
                                if (token.contains("+")) {
                                    iterator = "+";
                                }else {
                                    iterator = "-";
                                }
                            }else if (token.contains("*")) {
                                operator = "* " + getLastWord(token);
                                iterator = "*";
                            }else {
                                operator = "/ " + getLastWord(token);
                                iterator = "/";
                            }
                        }
                    }else if ((line.contains("for")) && ((token.contains("<") || (token.contains(">")) || (token.equals(space) == false)))) {
                        processCounter += operatorCount(token);
                        condCount = String.valueOf(operatorCount(token));
                        extraCounter += operatorCount(token);
                        
                        if (token.contains("<")) {
                            upper = getLastWord(token);
                            lower = init;
                        }else if (token.contains(">")) {
                            upper = init;
                            lower = getLastWord(token);
                        }

                        
                    }else if ((token.equals(brace) == false && token.equals(space) == false) && (!(line.contains("for")))) {
                        //Processes
                        processCounter += operatorCount(token);                       
                    }
                }
            }
            read.close();
        }

        catch(FileNotFoundException e) {
            System.out.println("Unable to open file '" + file + "'");                
        }

        catch(IOException e) {
            System.out.println("Error reading file '" + file + "'");
        }
    }

    public static boolean isChar(String str) {
        int index = 0;
        if ((str.charAt(index) >= 'a' && str.charAt(index) <= 'z') || (str.charAt(index) >= 'A' && str.charAt(index) <= 'Z')) {
            return true;
        }
        return false;
    }

    public static int operatorCount(String str) {
        int counter = 0;
        char prev = ' ';
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || 
                str.charAt(i) == '/' || str.charAt(i) == '=' || str.charAt(i) == '<' || str.charAt(i) == '>') {
                prev = str.charAt(i - 1);
                if (prev != '+' && prev != '-' && prev != '*' && prev != '/' && prev != '=' && prev != '<' && prev != '>') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static String upperBoundGetterStr(String up, String condition, String iterate) {
        int iteration = 0;
        int upper = 0;
        if (iterate.equals("1")) {
            if (condition.equals("1")) {
                return up;
            }else {
                if (condition.equals("2")) {
                    up = ("sqrt(" + up + ")");
                }else {
                    up = ("cubert(" + up + ")");
                }
            }
        }else if (iterate.contains("*") || iterate.contains("/")) {
            iterate = getLastWord(iterate);
            up = "log" + "(" + iterate + ")" + " " + up;
            if (condition.equals("1")) {
                return up;
            }else {
                if (condition.equals("2")) {
                    up = ("sqrt(" + up + ")");
                }else {
                    up = ("cubert(" + up + ")");
                }
            }
        }else {
            if (isChar(up)) {
                up = up + "/" + iterate;
            }else {
                upper = Integer.parseInt(up);
                iteration = Integer.parseInt(iterate);
                upper = upper / iteration;
                up = String.valueOf(upper);
            }
        }
        return up;
    }

    public static String getLastWord(String str) {
        return str.substring(str.lastIndexOf(" ") + 1);
    }

    public static boolean isInteger(String str) {
        boolean isValidInt = false;
        try {
            Integer.parseInt(str);
            isValidInt = true;
        }
        catch (NumberFormatException ex) {

        }
        return isValidInt;
    }

    public static int intSolver(int upperBound, int lowerBound, int process, int extra) {
        return (((upperBound - lowerBound) + 1) * process) + extra;
    }

    public static String strSolver(String upperBound, int lowerBound, int process, int extra) {
        int extraCtr = (((1 - lowerBound) * process) + extra);
        String processes = String.valueOf(process);
        String extraCnt = String.valueOf(Math.abs(extraCtr));
        if (extraCtr > 0) {
            return ((processes + " " + upperBound) + " + " + extraCnt);
        }else if (extraCtr < 0) {
            return ((processes + " " + upperBound) + " - " + extraCnt);
        }
        return (processes + upperBound);
    }
}

/**
*
* There are two ways to write error-free programs; only the third one works. – Alan J. Perlis
*
**/
