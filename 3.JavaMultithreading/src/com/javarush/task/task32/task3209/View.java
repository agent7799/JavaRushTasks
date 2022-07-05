package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void init(){
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){

    }

    public void initEditor(){

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }


    public void selectedTabChanged() {
    }
}