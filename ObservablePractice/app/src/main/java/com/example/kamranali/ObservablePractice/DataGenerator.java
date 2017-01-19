package com.example.kamranali.ObservablePractice;

import java.util.ArrayList;

/**
 * Created by Kamran ALi on 1/18/2017.
 */

public class DataGenerator {
    public static ArrayList<Integer> IterableList(int length){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0 ; i<length; i++){
            list.add(i);
        }
        return list;

    }
    public static Integer[] array(){
        return new Integer[]{1,2,3,4,5};

    }
}
