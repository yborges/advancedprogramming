package com.advancedprogramming;

public class Set {
    static final int MAX_NUMBER_OF_ELEMENTS = 10;

    String[] stringArray = new String[MAX_NUMBER_OF_ELEMENTS];
    int position = 0;

    void add(String element){
        stringArray[position] = element;
        position +=1;
//
//        System.out.print(position - 1);
//        System.out.println(stringArray[position -1]);
    }

    int get_size(){
        return stringArray.length;
    }

}
