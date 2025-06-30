package com.ilyaproject.ai_assistant_plugin.backend.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaFileWriter {
    public void writeResponseToFIle(String filePath, String response){
        Path path = Path.of(filePath);
        writeToFile(path, response);
    }

    private void writeToFile(Path path, String response){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            Pattern pattern = Pattern.compile("(?s)(?<=```java\\n).*?(?=\\n```)");
            Matcher matcher = pattern.matcher(response);
            if (matcher.find()){
                writer.write(matcher.group(0));
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Failed to write code to file " + e);
        }
    }
}
