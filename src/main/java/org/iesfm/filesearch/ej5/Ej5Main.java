package org.iesfm.filesearch.ej5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Ej5Main {

    private static Logger log =LoggerFactory.getLogger(Ej5Main.class);

    private static Ej5 ej5 = new Ej5();

    public static void main(String[] args) throws IOException {
        log.info("de que archivo se leera?");
        File toReadFile = new File(ej5.askPath());

        String text = ej5.askText();

        int count = ej5.countOcurrences(toReadFile, text);

        log.info("En que archivo escribire el resultado?");

        File toWriteFile = new File(ej5.askPath());
        ej5.write(toWriteFile, count);
    }
}
