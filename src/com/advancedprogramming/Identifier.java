/*
 * Author: Yuri Borges yuriborges@me.com
 * Author: Jens van Groeningen jensvangroeningen@live.nl
 * Date October 19, 2018
 * Purpose: Calculator of Sets for the Advanced Programming course
 * part of the CS bachelor of the university VU Amsterdam.
 * */

package com.advancedprogramming;

import java.io.PrintStream;

public class Identifier implements IdentifierInterface {

    private String text;
    private PrintStream out = System.out;

    @Override
    public String get_name() {
        return text;
    }

    @Override
    public boolean set_name(String newText) {
        if (check_new_text_sanity(newText)) {
            text = newText;
            return true;
        }
        return false;
    }

    private boolean check_new_text_sanity(String newText) {
        //Check if element is alphanumeric
        if (!newText.matches("[A-Za-z0-9]+")) {
            out.println("input is not alphanumeric");
            return false;
        }
        //Check if the first character of element is a letter
        if( !newText.substring(0, 1).matches("[a-zA-Z]")) {
            out.println("the first character of one or more elements is not a letter");
            return false;
        }
        return true;
    }
}
