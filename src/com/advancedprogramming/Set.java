/*
 * Author: Yuri Borges yuriborges@me.com
 * Author: Jens van Groeningen jensvangroeningen@live.nl
 * Date October 19, 2018
 * Purpose: Calculator of Sets for the Advanced Programming course
 * part of the CS bachelor of the university VU Amsterdam.
 * */

package com.advancedprogramming;

public class Set implements SetInterface {

    String[] stringArray = new String[MAX_NUM_IDENTIFIERS];
    private int sizeSet = 0;

    @Override
    public boolean add(String element){
        if (MAX_NUM_IDENTIFIERS == sizeSet) {
            return false;
        }
        stringArray[sizeSet] = element;
        sizeSet++;
        return true;
    }

    @Override
    public int get_size(){
        return sizeSet;
    }

    //difference = all elements contained in the 1st but not the 2nd set.
    @Override
    public Set difference(Set otherSet) {
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

    //intersection: all elements contained in both sets.
    //intersection is everything that is in set1 and also in set2
    @Override
    public Set intersection(Set otherSet) {
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

    /*union = all elements of both sets. (N.B. sets do not contain duplicate elements per definition.).
    union = differenceSet + second set, It is this easy because the manual says 'Sets do not contain duplicate elements
    per definition) */
    @Override
    public Set union(Set secondSet) {
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

    //symmetric difference: all elements of both sets that are not contained in he intersection.
    //symmetric difference = ( set1 + set2 ) - intersection.
    @Override
    public Set symmetric_difference(Set set2, Set intersection) {
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

    @Override
    public void print() {
        System.out.print('{');
        if(sizeSet > 0) {
            for ( int i=0; i < sizeSet; i++ ) {
                if(i == sizeSet - 1){
                    System.out.println(stringArray[i] + "}");
                } else {
                    System.out.print(stringArray[i] + " ");
                }
            }
        } else {
            System.out.println("}");
        }
    }
}
