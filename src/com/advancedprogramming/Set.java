//{abc def ghi a12 b12 c12}
//{abc ghi jen yur jan}

package com.advancedprogramming;


public class Set {

    static final int MAX_NUMBER_OF_ELEMENTS = 10;

    String[] stringArray = new String[MAX_NUMBER_OF_ELEMENTS];
    int sizeSet = 0;

    void add(String element){
        stringArray[sizeSet] = element;
        sizeSet++;
//
//        System.out.print(position - 1);
//        System.out.println(stringArray[position -1]);
    }

    int get_size(){
        return stringArray.length;
    }

    public Set difference (Set otherSet) {
        Set differenceSet = new Set();

        boolean elementSet1PresentInSet2;

        for (int i=0; i < sizeSet; i++) {
            elementSet1PresentInSet2 = false;

            for(int j=0; j < otherSet.sizeSet; j++ ){
                if( stringArray[i].equals(otherSet.stringArray[j]) ) {
                    elementSet1PresentInSet2 = true;
                }
            }

            if ( !elementSet1PresentInSet2 ){
                differenceSet.add(this.stringArray[i]);
            }
        }
        return differenceSet;

    }
    public void intersection (Set otherSet) {

    }
    public void union (Set otherSet) {

    }
    public void symmetric_difference(Set otherSet) {

    }

    public void printSet() {

        System.out.print('{');
        for ( int i=0; i < sizeSet; i++ ) {
            if(i == sizeSet - 1){
                System.out.println(stringArray[i] + "}");
            } else {
                System.out.print(stringArray[i] + " ");
            }
        }
    }
}
