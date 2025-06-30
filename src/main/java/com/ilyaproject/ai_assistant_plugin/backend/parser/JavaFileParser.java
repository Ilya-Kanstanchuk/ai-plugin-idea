package com.ilyaproject.ai_assistant_plugin.backend.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;

public class JavaFileParser {
    public String javaFileToString(String filePath){
        Path path = Path.of(filePath);
        StringBuilder file = new StringBuilder();
        readFile(path, file);
        return file.toString();
    }

    private void readFile(Path path, StringBuilder file){
        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String str;
            while ((str = br.readLine()) != null){
                file.append(str)
                        .append("\n");
            }
        }catch (Exception e){
            System.out.println("Failed to read file " + e);
        }
    }
}
