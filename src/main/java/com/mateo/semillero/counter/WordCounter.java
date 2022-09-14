package com.mateo.semillero.counter;

import com.mateo.semillero.model.Summary;

import java.io.IOException;

public interface WordCounter {
    Summary process(String path) throws IOException;
}
