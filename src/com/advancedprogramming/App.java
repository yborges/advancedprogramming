/*
 * Allowed functions:
 * java.lang.String
 * java.lang.Buffer
 * java.io.PrintStream
 * java.util.Scanner
 *
 * you cannot!! use java.util.StringTokenizer
 * Treating the input as a stream of characters is advised
 *
 * */
//TODO uitzoeken hoe we de elementen van de com.advancedprogramming.Set in de com.advancedprogramming.Set class gaan opslaan
//TODO class com.advancedprogramming.Set implementeren: add(), remove(), size() etc..
//TODO input lezen en opslaan in class com.advancedprogramming.Set

//TODO make inputContainsCorrectSet
//Alphanumeric, max amount of elements, we still have to read the input into set.
//TODO make calculateAndGiveOutput
//make the four functions
//TODO destructor schrijven... scanner.close() mss ook in.close?

package com.advancedprogramming;
import java.util.Scanner;
import java.io.PrintStream;

public class App {

    PrintStream out = new PrintStream(System.out);
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.start();
   }

   void start() {
       Set set1 = new Set(), set2 = new Set();

       while (askBothSets( set1, set2)) {

           Set differenceSet = set1.difference(set2);
           differenceSet.printSet("difference = ");

           Set intersectionSet = set1.intersection(set2);
           intersectionSet.printSet("intersection = ");

           Set unionSet = differenceSet.union(set2);
           unionSet.printSet("union = ");

           Set symdifSet = set1.symmetric_difference(set2, intersectionSet);
           symdifSet.printSet("sym. diff. = ");

       }
   }

    boolean askBothSets (Set set1, Set set2) {
        return askSet("Give first set : ", set1) && askSet("Give second set : ", set2);
    }
        /* Function should parse the input into the Set object as long as the conditions for the input are met.
   * The conditions are:
   * 1 =< number of elements in the set <= 10
   * first char of each element need to be a letter
   * all elements should contain only alphanumeric characters
   * each set should have brackets around its elements */
    boolean askSet (String question, Set set) {
        do {
            out.printf("%s", question);
            if (! in.hasNextLine()) {
                out.println("we are here");
                out.printf("\n"); // otherwise line with ^D will be overwritten
                return false;
            }
        } while (! inputContainsCorrectSet(set));
        return true;
    }

    boolean inputContainsCorrectSet(Set set) {
        if (in.hasNextLine()) {

            String bufferLine = in.nextLine();
            String bufferToken;

            /* Calculates the amount of tokens in the stream. If the stream has more than 10 elements or less than
            1 element then we need to ask for an element again. Comparison comes in the IF statement bellow  */
            int numTokens = bufferLine.split(in.delimiter().pattern()).length;

            /* Checks for some conditions that the string has to meet even before we apply a Scanner on the
            string to extract the values of each element of the given Set */
            if (bufferLine.charAt(0) == '{' && bufferLine.charAt(bufferLine.length() - 1) == '}'
                    && numTokens <= 10 && numTokens >= 1) {

                /* At this point the conditions above have been met and so we remove the first and last character
                of the string and feed it to the scanner */
                bufferLine = bufferLine.substring(1, bufferLine.length() - 1);

                /* instantiates a new Scanner and assigns this new instance to the variable sc */
                Scanner scString = new Scanner(bufferLine);

                /* This while loop iterates through every token in the Scanner */
                while (scString.hasNext()) {

                    //the value of the token in each iteration will be assigned to the String buffer
                    bufferToken = scString.next();

                    if (!bufferToken.matches("[A-Za-z0-9]+") ||
                            !bufferToken.substring(0, 1).matches("[a-zA-Z]")) {

                        System.out.println("input is not alphanumeric or first character of one or more elements " +
                                "is not a letter");
                        return false;
                    }
                    populateArray(bufferToken, set);
                }
            } else {
                System.out.println("ERROR brackets missing or total amount of elements in the set not allowed");
                return false;
            }
        }
        return true;
    }

    void populateArray(String element, Set set) {
        set.add(element);
    }

}
