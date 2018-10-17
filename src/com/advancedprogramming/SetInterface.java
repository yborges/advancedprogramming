package com.advancedprogramming;

public interface SetInterface {
    void add(String element);

    int get_size();

    Set difference(Set otherSet);

    //intersection is everything that is in set1 and also in set2
    Set intersection(Set otherSet);

    //union = differenceSet + second set, It is this easy because the manual says 'Sets do not contain duplicate elements
    // per definition)
    Set union(Set secondSet);

    //symmetric difference = ( set1 + set2 ) - intersection.
    Set symmetric_difference(Set set2, Set intersection);

    void print(String function);
}
