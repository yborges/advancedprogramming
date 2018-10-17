package com.advancedprogramming;

public interface SetInterface {
    void add(String element);

    int get_size();

    //difference: all elements contained in the 1st but not the 2nd set.
    Set difference(Set otherSet);

    //intersection: all elements contained in both sets.
    Set intersection(Set otherSet);

    //union: all elements of both sets. (N.B. sets do not contain duplicate elements per definition.)
    Set union(Set secondSet);

    //symmetric difference: all elements of both sets that are not contained in he intersection.
    Set symmetric_difference(Set set2, Set intersection);

    void print(String function);
}
