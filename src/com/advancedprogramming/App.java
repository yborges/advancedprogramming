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

package com.advancedprogramming;
import java.util.Scanner;
import java.io.PrintStream;

public class App {

    PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) {
        App app = new App();
        app.start();;
   }

   void start() {
       Set set1 = new Set(), set2 = new Set();

       set1.add("JEns");

       System.out.println(set1.get_size());
       System.out.println(set2.get_size());
       Scanner in = new Scanner(System.in);


       while (askBothSets(in, set1, set2)) {
           //calculateAndGiveOutput(set1, set2);
           out.print("inside while loop");//DEBUG
       }
   }

    boolean askSet (Scanner input, String question, Set set) {
        do {
            out.printf("%s", question);
            if (! input.hasNextLine()) {
                out.printf("\n"); // otherwise line with ^D will be overwritten
                return false;
            }
        } while (! inputContainsCorrectSet(input, set));
        return true;
    }


    boolean askBothSets (Scanner input, Set set1, Set set2) {
        return askSet(input, "Give first set : ", set1) &&
                askSet(input, "Give second set : ", set2);
    }

    boolean inputContainsCorrectSet(Scanner input, Set set) {
        return true;
    }

}
