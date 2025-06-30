package com.ilyaproject.ai_assistant_plugin.backend.assistant;

import com.ilyaproject.ai_assistant_plugin.backend.gpt.ApiCall;
import com.ilyaproject.ai_assistant_plugin.backend.gpt.nano.ApiCallGptNano;
import com.ilyaproject.ai_assistant_plugin.backend.parser.JavaFileParser;
import com.ilyaproject.ai_assistant_plugin.backend.writer.JavaFileWriter;

import java.util.Scanner;

public class AIHandler {
    private final ApiCall call;
    private final JavaFileParser parser;
    private final JavaFileWriter writer;
    private final Scanner scanner = new Scanner(System.in);

    public AIHandler(ApiCall call, JavaFileParser parser, JavaFileWriter writer) {
        this.call = call;
        this.parser = parser;
        this.writer = writer;
    }
    public AIHandler(){
        call = new ApiCallGptNano();
        parser = new JavaFileParser();
        writer = new JavaFileWriter();
    }
    public void run(String prompt, String path){
        String file = parser.javaFileToString(path);
        String code = call.callGPT(prompt + file);
        writer.writeResponseToFIle(path, code);
    }
}
