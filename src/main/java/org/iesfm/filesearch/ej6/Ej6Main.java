package org.iesfm.filesearch.ej6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej6Main {

    private static Scanner scan = new Scanner(System.in);

    private static Logger log = LoggerFactory.getLogger(Ej6Main.class);

    private static Ej6 ej6 = new Ej6();

    public static void main(String[] args) throws IOException {
        log.info("Introduce un numero entero");
        int num = ej6.askNumber();

        log.info("Se creara un archivo en la ruta que escriba");
        ej6.printOnFile(ej6.createFile(
                                        new File(
                                                1scan.nextLine())), num);

        log.info("Se creo un archivo OutLog.txt en la ruta seleccionada con el output determinado");

    }
}
