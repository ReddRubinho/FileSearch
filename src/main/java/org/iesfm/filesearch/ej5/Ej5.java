package org.iesfm.filesearch.ej5;

import org.iesfm.filesearch.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class Ej5 {

    private static Scanner scan = new Scanner(System.in);

    private static Logger log = LoggerFactory.getLogger(Ej5.class);

    private static FileUtils fileUtils = new FileUtils();

    public String askPath() {
        log.info("Escribe una ruta");

        return scan.nextLine();
    }

    public String askText() {
        log.info("Que texto quieres buscar?");
        return scan.nextLine();
    }

    public int countOcurrences(File file, String text) throws FileNotFoundException {
        int count = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(text)) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void write(File file, int count) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file);){
            fileWriter.write(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
