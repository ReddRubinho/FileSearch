package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class CountWordMain {

    private static Logger log = LoggerFactory.getLogger(CountWordMain.class);

    private static Scanner scan = new Scanner(System.in);

    private static FileUtils fileUtils = new FileUtils();

    public static File askPath() {
        log.info("Enter a directory: ");
        return new File(scan.nextLine());
    }

    public static String askText() {
        log.info("Now, type some text to search it: ");
        return scan.nextLine();
    }

    public static int countOcurrences(File file, String text) throws InterruptedException {
        CountWordTask countWordTask = new CountWordTask(file, text);
        Thread countWordThread = new Thread(countWordTask);
        countWordThread.start();
        try {
            countWordThread.join();
        } catch (InterruptedException e) {

        }

        while (countWordThread.isAlive()) {

        }


        log.info("In file " + file.getName() + "the text appears " + countWordTask.getOcurrences() + "times.");
        return countWordTask.getOcurrences();
    }

    public static void main(String[] args) throws InterruptedException {

        File folder = askPath();

        String text = askText();

        File[] files = fileUtils.listFiles(folder);

        int totalOcurrences = 0;


        for (File file : files) {
            totalOcurrences += countOcurrences(file, text);
        }

        log.info("The total amount of iterations of the text is " + totalOcurrences + "times.");
    }
}
