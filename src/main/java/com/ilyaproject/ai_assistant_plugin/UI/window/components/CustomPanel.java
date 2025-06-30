package com.ilyaproject.ai_assistant_plugin.UI.window.components;

import com.ilyaproject.ai_assistant_plugin.UI.window.utils.FileHelper;
import com.ilyaproject.ai_assistant_plugin.backend.assistant.AIHandler;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import javax.swing.*;

public class CustomPanel {
    private Project project;
    private JPanel content;
    private JButton button;
    private JTextField text;
    private final AIHandler handler = new AIHandler();
    private final FileHelper helper = new FileHelper();
    public CustomPanel(Project project){
        this.project = project;
        button.addActionListener(e ->{
            String prompt = text.getText();
            String filePath = null;
            try {
                filePath = helper.getCurrentJavaFile(project);
            }catch (Exception exception){
                System.out.println(exception);
            }
            if (filePath != null){
                handler.run(prompt, filePath);
                System.out.println("Assistant was activated");
            }else {
                System.out.println("File Path is null");
            }
        });
    }
    public JPanel getContent() {
        return content;
    }

}