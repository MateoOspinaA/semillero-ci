package com.mateo.semillero.operations;

import java.util.Arrays;

public class Operator {

    public static long sumar(int... numbers){
        return Arrays.stream(numbers).sum();
    }

    public static long count(int... numbers){
        return Arrays.stream(numbers).count();
    }

    public static double average(int... numbers){
        return Arrays.stream(numbers).average().orElse(0.0);
    }
}
