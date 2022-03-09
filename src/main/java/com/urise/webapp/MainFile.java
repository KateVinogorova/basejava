package com.urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File(".");
        recursiveCallOfDirs(dir, "");
    }

    public static void recursiveCallOfDirs(File dir, String offset) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(offset + "File: " + file);
                } else if (file.isDirectory()) {
                    System.out.println(offset + "Directory: " + file);
                    recursiveCallOfDirs(file, offset + "    ");
                }
            }
        }
    }
}

