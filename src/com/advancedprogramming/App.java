/*
 * Author: Yuri Borges yuriborges@me.com
 * Author: Jens van Groeningen jensvangroeningen@live.nl
 * Date October 19, 2018
 * Purpose: Calculator of Sets for the Advanced Programming course
 * part of the CS bachelor of the university VU Amsterdam.
 * */

package com.advancedprogramming;

import java.util.Scanner;
import java.io.PrintStream;

public class App {
    
    //Requirement of the assignment: max. 10 identifiers as input
    public static final int MAX_NUM_INDENTIFIERS_INPUT = 10;
    
    PrintStream out = System.out;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.start();
   }

   /*
   * Code execution uses the same approach as the template code.
   * Start() uses a while loop to keep calling ask_both_sets(), ask_set() and input_contains_correct_set()
   * */
   void start() {

       Set set1 = new Set(), set2 = new Set();

       while (ask_both_sets( set1, set2)) {
           //Calculates and prints the difference
           out.print("difference = ");
           Set differenceSet = set1.difference(set2);
           differenceSet.print();

           //Calculates and prints the intersection
           out.print("intersection = ");
           Set intersectionSet = set1.intersection(set2);
           intersectionSet.print();

           //Calculates and prints the difference
           out.print("union = ");
           Set unionSet = differenceSet.union(set2);
           unionSet.print();

           //Calculates and prints the symmetric difference and and an empty line
           out.print("sym. diff. = ");
           Set symdifSet = set1.symmetric_difference(set2, intersectionSet);
           symdifSet.print();
           out.println();

           //assigns new empty Set objects for the next iteration
           set1 = new Set();
           set2 = new Set();
       }
   }

    boolean ask_both_sets (Set set1, Set set2) {
        return ask_set("Give first set : ", set1) && ask_set("Give second set : ", set2);
    }
        /* Function should parse the input into the Set object as long as the conditions for the input are met.
   * The conditions are:
   * 1 =< number of elements in the set <= 10
   * first char of each element need to be a letter (checked during Idenfifier object instantiation)
   * all elements should contain only alphanumeric characters (checked during Idenfifier object instantiation)
   * each set should have brackets around its elements */
    boolean ask_set (String question, Set set) {
        do {
            out.printf("%s", question);

        } while (! input_contains_correct_set(set));
        return true;
    }

    boolean input_contains_correct_set(Set set) {
        /*
         * Unnecessary condition checking. hasNextLine() seems to never return false for this code. But the
         * IF statement will be kept here so that we can show that we know how to use a Scanner the right way:
         * checking for the existence of input first, then consuming it afterwards.
         */
        if (in.hasNextLine()) {

            //bufferLine will hold the text of each line
            String bufferLine = in.nextLine();

            //bufferLine will be split into tokens using the space as delimiter. The sanity of each token will be checked
            String bufferToken;

            /* This condition makes sure that if new line character is the only input character,
             * the user will be asked for the set again.
             */
             if ( bufferLine.length() < 1 ) return false;

            /* Calculates the amount of tokens in the stream. If the stream has more than 10 elements or less than
            0 elements then we need to ask for an element again. Comparison comes in the IF statement bellow  */
            int numTokens = bufferLine.split(in.delimiter().pattern()).length;

            /* Checks for some conditions that the string has to meet even before we apply a Scanner on the
            string to extract the values of each element of the given Set */
            if (bufferLine.charAt(0) == '{' && bufferLine.charAt(bufferLine.length() - 1) == '}'
                    && numTokens <= MAX_NUM_INDENTIFIERS_INPUT && numTokens >= 1) {

                /* At this point the conditions above have been met and so we remove the first and last character
                of the string and feed it to the scanner */
                bufferLine = bufferLine.substring(1, bufferLine.length() - 1);

                /* instantiates a new Scanner and assigns this new instance to the variable sc */
                Scanner scString = new Scanner(bufferLine);

                /* This while loop iterates through every token in the Scanner */
                while (scString.hasNext()) {

                    //the value of the token in each iteration will be assigned to the String buffer
                    bufferToken = scString.next();

                    /* Uses an Identifier class for educational purposes. The code could have checked the conditions
                     * on the Identifiers without creating a class and an implementation.
                     */
                    Identifier identifier = new Identifier();
                    if (!identifier.set_name(bufferToken)) return false;
                    populate_array(identifier.get_name(), set);
                }
                return true;
            } else if ( bufferLine.charAt(0) != '{' ) {
                if ( bufferLine.contains("{") ) { //check whether user put the '{' somewhere else than at the beginning
                    out.println("No input allowed before '{'");
                    return false;
                } else {    //if '{' is not at the beginning and not somewhere else, than there is no '{'
                    out.println("Missing '{'");
                    return false;
                }
            } else if ( bufferLine.charAt(bufferLine.length() - 1) != '}') {
                if ( bufferLine.contains("}") ) { //check whether user put the '}' somewhere else than at the end
                    out.println("No input allowed after '}'");
                } else {    //if '}' is not at the end and not somewhere else, than there is no '}'
                    out.println("Missing '}'");
                    return false;
                }
                return false;
            } else if ( numTokens > MAX_NUM_INDENTIFIERS_INPUT || numTokens < 0 ) {
                //number of elements, 'numTokens' should be less than or
                // equal to 10 and greater than or equal to 0
                out.println("Invalid number of elements");
                return false;
            }
        }
        return false;
    }

    void populate_array(String element, Set set) {
        set.add(element);
    }

}
