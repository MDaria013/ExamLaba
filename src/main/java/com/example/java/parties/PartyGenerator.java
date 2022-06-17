package com.example.java.parties;

import com.example.java.Reader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class PartyGenerator {

    private Reader reader;

    private ThreadLocalRandom random;

    private String[] name;

    private String[] focus;

    public String[] getName() {
        return name;
    }

    public String[] getFocus(){return  focus;}

    public PartyGenerator(File file) throws IOException, InvalidFormatException {
        this.random = ThreadLocalRandom.current();
        reader = new Reader(file);
        setUp();
    }

    public void setUp() throws IOException, InvalidFormatException {
        name = reader.readData(7);
        focus = reader.readData(8);
        reader.close();
    }

}
