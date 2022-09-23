package com.mateo.semillero.counter;

import com.mateo.semillero.model.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class WordCounterDefaultTest {

    @Test
    void mustReturnCorrectSummary() throws IOException {
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        WordCounter wordCounter = new WordCounterDefault();

        Summary summary = wordCounter.process(absolutePath + File.separator+"test.txt");
        Assertions.assertEquals(2, summary.getNumberOfLines());
        Assertions.assertEquals(5, summary.getNumberOfWords());
    }

    @Test
    void mustReturnIncorrectSummary() throws IOException {
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        WordCounter wordCounter = new WordCounterDefault();

        Summary summary = wordCounter.process(absolutePath + File.separator+"test.txt");
        Assertions.assertNotEquals(5, summary.getNumberOfLines());
        Assertions.assertNotEquals(2, summary.getNumberOfWords());
    }
}
