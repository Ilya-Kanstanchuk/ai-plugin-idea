package com.ilyaproject.ai_assistant_plugin.UI.window.components;

import com.intellij.openapi.ui.Messages;

import javax.swing.*;

public class CustomPanel {
    private JPanel content;
    private JButton button;
    private JTextField text;


    public CustomPanel(){
        button.addActionListener(e ->{
            String prompt = text.getText();
            Messages.showMessageDialog("You typed: " + prompt, "Info", Messages.getInformationIcon());
        });
    }
    public JPanel getContent() {
        return content;
    }

}