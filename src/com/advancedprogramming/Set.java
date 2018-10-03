package com.advancedprogramming;

public class Set {
    static final int MAX_NUMBER_OF_ELEMENTS = 10;

    String[] stringArray = new String[MAX_NUMBER_OF_ELEMENTS];

    void add(String str){
        stringArray[0] = str;
    }

    int get_size(){
        return stringArray.length;
    }

}
