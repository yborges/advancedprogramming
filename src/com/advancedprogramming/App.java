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
           //calculateAndGiveOutput(set1, set2);
           out.print("inside while loop");//DEBUG
       }
   }

    boolean askSet ( String question, Set set) {
        do {
            out.printf("%s", question);
            if (in.hasNextLine()) {
                out.println(in.nextLine());
                out.printf("\n"); // otherwise line with ^D will be overwritten
                return true;
            }
        } while (! inputContainsCorrectSet(set));
        return true;
    }


    boolean askBothSets (Set set1, Set set2) {
        return askSet( "Give first set : ", set1) && askSet( "Give second set : ", set2);
    }

    boolean inputContainsCorrectSet(Set set) {
        return true;
    }

}
