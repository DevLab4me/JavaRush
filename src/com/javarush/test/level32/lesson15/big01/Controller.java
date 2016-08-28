package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Artem on 14.05.2016.
 */

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument(){
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public void setPlainText(String text){
        this.resetDocument();
        StringReader stringReader = new StringReader(text);

        try {
            new HTMLEditorKit().read(stringReader, document, 0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());

        int n = fileChooser.showOpenDialog(view);
        if(n == JFileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try (FileReader fileReader = new FileReader(currentFile))
            {
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void saveDocument(){

        if (currentFile == null){
            saveDocumentAs();
        } else {
            view.selectHtmlTab();
            try(FileWriter writer = new FileWriter(currentFile)){
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());

        int n = fileChooser.showSaveDialog(view);
        if(n == JFileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            try(FileWriter writer = new FileWriter(currentFile)){
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
