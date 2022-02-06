package com.urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "/Users/user/basejava/";
        recursiveCallOfDirs(filePath);
    }

    public static void recursiveCallOfDirs(String s) {
        File dir = new File(s);
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] files = dir.list();
            for (String file : files) {
                recursiveCallOfDirs(s + "/" + file);
            }
        }
    }
}
