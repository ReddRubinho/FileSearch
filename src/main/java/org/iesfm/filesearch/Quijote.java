package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Quijote {
    final File file = new File(this.getClass().getResource("/el_quijote.txt").toURI());

    private static Logger log = LoggerFactory.getLogger(Quijote.class);

    private static Scanner scan = new Scanner(System.in);

    private static FileUtils fileUtils = new FileUtils();

    public Quijote() throws URISyntaxException {
    }

    public File getFile() {
        return file;
    }

    public void searchInElQuijote(String text) throws URISyntaxException {
        CountWordTask countWordTask = new CountWordTask(new File(this.getClass().getResource("/el_quijote.txt").toURI()), text);
        Thread countThread = new Thread(countWordTask);
        countThread.start();

    }

}
