package com.mateo.semillero.operations;

import java.util.Arrays;

public class Operator {
    public static long sumar(int... numbers){
        return Arrays.stream(numbers).sum();
    }
}
