package com.mateo.semillero.model;

public class Summary {
    private final long numberOfLines;
    private final long numberOfWords;

    public Summary(long numberOfLines, long numberOfWords) {
        this.numberOfLines = numberOfLines;
        this.numberOfWords = numberOfWords;
    }

    public long getNumberOfLines() {
        return numberOfLines;
    }

    public long getNumberOfWords() {
        return numberOfWords;
    }
}
