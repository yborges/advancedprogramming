package com.nasajens;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.Set;

public class App {

    static final int MAX_NUMBER_OF_ELEMENTS = 10;
    PrintStream out;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Set set1 = new Set(), set2 = new Set();

        while (askBothSets(in, set1, set2)) {
            calculateAndGiveOutput(set1, set2);
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


//TODO make inputContainsCorrectSet
//Alphanumeric, max amount of elements, we still have to read the input into set.
//TODO make calculateAndGiveOutput
//make the four functions
//TODO Yuri organize code

}
