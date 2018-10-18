package com.advancedprogramming;

import java.io.PrintStream;

public class Identifier implements IdentifierInterface {

    private String text;
    private PrintStream out = System.out;

    public Identifier(String newText) {
        if(check_new_text_sanity(newText)) {
            this.text = newText;
        }
    }

    @Override
    public String get_name() {
        return text;
    }

    @Override
    public boolean set_name(String newText) {
        if (check_new_text_sanity(newText)) {

        }
        text = newText;
        return true;
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
