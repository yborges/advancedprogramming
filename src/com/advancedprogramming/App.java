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


//TODO destructor schrijven... scanner.close() mss ook in.close?

//TODO VRAGEN TA wat ze met 10 identifiers bedoelen voor input en 20 voor set. bedoelen ze dat een set maar 20 elementen
//kan hebben waarvan elk element maar 10 characters lang is?

//TODO VRAGEN TA of error handling met IF's genoeg is óf we met error handling moeten gaan werken. Als het laatste
// het geval is, dan moeten we ook weten de makkelijkste manier om die errors te catchen. Ivm Exception type zou ik
// niet weten hoe error handling makkelijk kan in dit geval zonder dat we een eigen exeption type gaan maken en dat
// lijkt me niet makkelijk

//TODO TA onze code laten zien en vragen of er ruimte is voor verbeteringen
//TODO commentaar overal schrijven voordat we naar de TA gaan




package com.advancedprogramming;
import java.util.Scanner;
import java.io.PrintStream;

public class App {

    PrintStream out = System.out;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.start();
   }

   void start() {

       Set set1 = new Set(), set2 = new Set();

       while (askBothSets( set1, set2)) {

           Set differenceSet = set1.difference(set2);
           differenceSet.print("difference = ");

           Set intersectionSet = set1.intersection(set2);
           intersectionSet.print("intersection = ");

           Set unionSet = differenceSet.union(set2);
           unionSet.print("union = ");

           Set symdifSet = set1.symmetric_difference(set2, intersectionSet);
           symdifSet.print("sym. diff. = ");
           out.println();
           set1 = new Set();
           set2 = new Set();
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
        } while (! inputContainsCorrectSet(set));
        return true;
    }

    boolean inputContainsCorrectSet(Set set) {
        if (in.hasNextLine()) {

            String bufferLine = in.nextLine();
            String bufferToken;

             if ( bufferLine.length() < 1 ) return false;

            //TODO this comment talks about 10 identifiers. Rewrite after TA meeting if needed.
            /* Calculates the amount of tokens in the stream. If the stream has more than 10 elements or less than
            0 elements then we need to ask for an element again. Comparison comes in the IF statement bellow  */
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

                    if (!bufferToken.matches("[A-Za-z0-9]+")) {
                        out.println("input is not alphanumeric");
                        return false;
                    }
                    if(!bufferToken.substring(0, 1).matches("[a-zA-Z]")) {
                        out.println("the first character of one or more elements is not a letter");
                        return false;
                    }
                    populateArray(bufferToken, set);
                }
            } else if ( bufferLine.charAt(0) != '{' ) {
                if ( bufferLine.contains("{") ) { //check whether user put the final brackets somewhere else
                    out.println("No input allowed before first bracket");
                    return false;
                } else {
                    out.println("First bracket missing");
                    return false;
                }
            } else if ( bufferLine.charAt(bufferLine.length() - 1) != '}') {
                if ( bufferLine.contains("}") ) { //check whether user put the final brackets somewhere else
                    out.println("No input allowed after last bracket");
                } else {
                    out.println("Last bracket missing");
                    return false;
                }
                return false;
            } else if ( numTokens > 10 || numTokens < 0 ) {
                out.println("Invalid number of elements");
                return false;
            }
        }
        return true;
    }

    void populateArray(String element, Set set) {
        set.add(element);
    }

}
