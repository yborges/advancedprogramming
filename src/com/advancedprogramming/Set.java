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

    //intersection is everything that is in set1 and also in set2
    public Set intersection (Set otherSet) {
        Set intersectionSet = new Set();

        boolean elementSet1PresentInSet2;

        for (int i=0; i < sizeSet; i++) {
            elementSet1PresentInSet2 = false;

            for(int j=0; j < otherSet.sizeSet; j++ ){
                if( stringArray[i].equals(otherSet.stringArray[j]) ) {
                    elementSet1PresentInSet2 = true;
                }
            }

            if ( elementSet1PresentInSet2 ){
                intersectionSet.add(this.stringArray[i]);
            }
        }

        return intersectionSet;
    }

    //union = differenceSet + second set, It is this easy because the manual says 'Sets do not contain duplicate elements
    // per definition)
    public Set union (Set secondSet) {
        Set unionSet = new Set();
        //int position =0;
        for (int position =0; position<sizeSet; position++){
            unionSet.add(this.stringArray[position]);
        }
        //If for-loop from above is finished, set2 has to be added to unionSet
        for(int i =0; i <secondSet.sizeSet; i++ ){
            unionSet.add(secondSet.stringArray[i]);
        }

        return unionSet;
    }

    //symmetric difference = ( set1 + set2 ) - intersection.
    public Set symmetric_difference (Set set2, Set intersection) {
        Set symdifSet = new Set();

        boolean elementSet1PresentInIntersection;
        boolean elementSet2PresentInIntersection;

        for (int i = 0; i<sizeSet; i++) {
            elementSet1PresentInIntersection = false;

            for (int j = 0; j < intersection.sizeSet; j++) {
                if (stringArray[i].equals(intersection.stringArray[j])) {
                    elementSet1PresentInIntersection = true;
                }
            }
            if (!elementSet1PresentInIntersection) {
                symdifSet.add(this.stringArray[i]);
            }
        }

        for (int i = 0; i<set2.sizeSet; i++) {
            elementSet2PresentInIntersection = false;

            for (int j = 0; j < intersection.sizeSet; j++) {
                if (set2.stringArray[i].equals(intersection.stringArray[j])) {
                    elementSet2PresentInIntersection = true;
                }
            }
            if (!elementSet2PresentInIntersection) {
                symdifSet.add(set2.stringArray[i]);
            }
        }

        return symdifSet;
    }

    public void printSet(String function) {
        System.out.print(function);
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
