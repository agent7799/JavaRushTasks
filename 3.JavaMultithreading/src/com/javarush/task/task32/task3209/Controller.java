package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }


    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser saveFileChooser = new JFileChooser();
        saveFileChooser.setFileFilter(new HTMLFileFilter());
        saveFileChooser.setDialogTitle("Save File As");
        int returnVal = saveFileChooser.showSaveDialog(view);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = saveFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer, document, 0, document.getLength());
                writer.flush();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile == null) {
            saveDocumentAs();
        }else {
            try (FileWriter writer = new FileWriter(currentFile)) {
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer, document, 0, document.getLength());
                writer.flush();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setFileFilter(new HTMLFileFilter());
        openFileChooser.setDialogTitle("Save File As");
        int returnVal = openFileChooser.showOpenDialog(view);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = openFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try (FileReader reader = new FileReader(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.read(reader, document, 0);
                view.resetUndo();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        currentFile = null;
    }

    public void resetDocument() {
        UndoListener listener = view.getUndoListener();
        if (document != null) {
            document.removeUndoableEditListener(listener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(listener);
        view.update();
    }

    public void  setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.read(reader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try{
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.write(writer,document, 0, document.getLength());
            writer.flush();
            writer.close();
        }catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

}
