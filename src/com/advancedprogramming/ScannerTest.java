//package com.advancedprogramming;
//
//import java.util.Scanner;
//
//public class ScannerTest {
//    public static void main(String[] args) {
//        String teststring = "{bc def hijk l hhh llhh 9jjj}";
//        String buffer;
//        String[] testset = new String[10];
//        Scanner sc = new Scanner(teststring);
//
//        /* Calculates the amount of tokens in the stream. If the stream has more than 10 elements or less than 1 element
//         then we need to ask for an element again. */
//        int numTokens = sc.nextLine().split(sc.delimiter().pattern()).length;
//
//        /* closes the present Scanner */
//        sc.close();
//
//        /* Checks for some conditions that the string has to meet even before we apply a Scanner on the string to
//         * extract the values of each element of the given Set */
//        if (teststring.charAt(0) == '{' && teststring.charAt(teststring.length()-1) == '}'
//                && numTokens <= 10 && numTokens >= 1 ) {
//            /* At this point the conditions above have been met and so we remove the first and last character of the
//            * string and feed it to the scanner */
//            teststring = teststring.substring(1, teststring.length() - 1);
//            /* instantiates a new Scanner and assigns this new instance to the variable sc */
//            sc = new Scanner(teststring);
//
//            /* This while loop iterates through every token in the Scanner */
//            while (sc.hasNext()) {
//
//                buffer = sc.next(); //the value of the token in each iteration will be assigned to the String buffer
//
//                if ( ! buffer.matches("[A-Za-z0-9]+") || ! buffer.substring(0,1).matches("[a-zA-Z]") ) {
//                    System.out.println("input is not alphanumeric or first character of one or more elements " +
//                            "is not a letter");
//                    break;
//                }
//                //System.out.println(buffer.charAt(0));
//                System.out.println(buffer);
//            }
//        } else {
//            System.out.print("ERROR brackets missing or total amount of elements in the set not allowed");
//        }
//    }
//}
