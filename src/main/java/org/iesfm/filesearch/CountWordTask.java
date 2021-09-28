package org.iesfm.filesearch;

import java.io.File;

public class CountWordTask implements Runnable{
    private File folder;
    private String text;

    private int ocurrences = 0;

    private static FileUtils  fileUtils= new FileUtils();

    public CountWordTask(File folder, String text) {
        this.folder = folder;
        this.text = text;
    }

    public int getOcurrences() {
        return ocurrences;
    }

    @Override
    public void run() {
        ocurrences = fileUtils.countTextOccurrences(folder, text);
    }
}
