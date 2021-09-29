package org.iesfm.filesearch.ej6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej6 {

    private static Scanner scan = new Scanner(System.in);

    public int askNumber() {
        return scan.nextInt();
    }

    public File createFile(File file) throws IOException {
        File newFile = new File(file + "/OutLog.txt");
        try {
           newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    public void printOnFile(File file, int number) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i< number; i++) {
                fileWriter.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
