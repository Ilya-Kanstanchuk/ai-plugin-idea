    package com.ilyaproject.ai_assistant_plugin.UI.window.utils;

    import com.intellij.openapi.editor.Document;
    import com.intellij.openapi.editor.Editor;
    import com.intellij.openapi.fileEditor.FileEditorManager;
    import com.intellij.openapi.project.Project;
    import com.intellij.psi.PsiDocumentManager;
    import com.intellij.psi.*;

    public class FileHelper {
        public String getCurrentJavaFile(Project project){
            Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
            if (editor == null){
                throw new RuntimeException("No editor is open");
            }
            Document document = editor.getDocument();
            PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
            if (psiFile instanceof PsiJavaFile){
                PsiJavaFile javaFile = (PsiJavaFile) psiFile;
                return javaFile.getVirtualFile().getPath();
            }else {
                throw new RuntimeException("Current open file is not a java file ");
            }
        }
    }
