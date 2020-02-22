package com.example.miryo_vision_backend.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;


public class FileHandler {
    public static String findFilePath(String fileName, String[] extensions) throws Exception {
        File root = new File("./src/main/resources");
        // String[] extensions = {"txt"};
        boolean recursive = true;

        Collection<File> files = FileUtils.listFiles(root, extensions, recursive);

        String filePath = null;
        for (File file : files) {
            for (String extension : extensions) {
                if (file.getName().equals(fileName + "." + extension)) {
                    filePath = file.getPath();
                }
            }
        }
        if (filePath != null) {
            return filePath;
        } else {
            throw new FileNotFoundException(
                    "(" + fileName + "." + String.join("|", extensions) +
                            ") 파일을 못 찾았습니다.");
        }
    }
}
