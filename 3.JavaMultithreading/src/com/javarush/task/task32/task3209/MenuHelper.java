package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.actions.*;
import com.javarush.task.task32.task3209.listeners.TextEditMenuListener;
import com.javarush.task.task32.task3209.listeners.UndoMenuListener;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem menuItem = addMenuItem(parent, action);
        menuItem.setText(text);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem menuItem = new JMenuItem(action);
        parent.add(menuItem);
        return menuItem;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {
        JMenu helpMenu = new JMenu("������");
        menuBar.add(helpMenu);

        addMenuItem(helpMenu, "� ���������", view);
    }

    public static void initFontMenu(View view, JMenuBar menuBar) {
        JMenu fontMenu = new JMenu("�����");
        menuBar.add(fontMenu);

        JMenu fontTypeMenu = new JMenu("�����");
        fontMenu.add(fontTypeMenu);

        String[] fontTypes = {Font.SANS_SERIF, Font.SERIF, Font.MONOSPACED, Font.DIALOG, Font.DIALOG_INPUT};
        for (String fontType : fontTypes) {
            addMenuItem(fontTypeMenu, fontType, new StyledEditorKit.FontFamilyAction(fontType, fontType));
        }

        JMenu fontSizeMenu = new JMenu("������ ������");
        fontMenu.add(fontSizeMenu);

        String[] fontSizes = {"6", "8", "10", "12", "14", "16", "20", "24", "32", "36", "48", "72"};
        for (String fontSize : fontSizes) {
            addMenuItem(fontSizeMenu, fontSize, new StyledEditorKit.FontSizeAction(fontSize, Integer.parseInt(fontSize)));
        }

        fontMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initColorMenu(View view, JMenuBar menuBar) {
        JMenu colorMenu = new JMenu("����");
        menuBar.add(colorMenu);

        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("�������", Color.red));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("���������", Color.orange));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("������", Color.yellow));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("�������", Color.green));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("�����", Color.blue));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("�������", Color.cyan));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("���������", Color.magenta));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("������", Color.black));

        colorMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initAlignMenu(View view, JMenuBar menuBar) {
        JMenu alignMenu = new JMenu("������������");
        menuBar.add(alignMenu);

        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("�� ������ ����", StyleConstants.ALIGN_LEFT));
        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("�� ������", StyleConstants.ALIGN_CENTER));
        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("�� ������� ����", StyleConstants.ALIGN_RIGHT));

        alignMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initStyleMenu(View view, JMenuBar menuBar) {
        JMenu styleMenu = new JMenu("�����");
        menuBar.add(styleMenu);

        addMenuItem(styleMenu, "����������", new StyledEditorKit.BoldAction());
        addMenuItem(styleMenu, "������������", new StyledEditorKit.UnderlineAction());
        addMenuItem(styleMenu, "������", new StyledEditorKit.ItalicAction());

        styleMenu.addSeparator();

        addMenuItem(styleMenu, "����������� ����", new SubscriptAction());
        addMenuItem(styleMenu, "����������� ����", new SuperscriptAction());
        addMenuItem(styleMenu, "�����������", new StrikeThroughAction());

        styleMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initEditMenu(View view, JMenuBar menuBar) {
        JMenu editMenu = new JMenu("�������������");
        menuBar.add(editMenu);

        JMenuItem undoItem = addMenuItem(editMenu, "��������", new UndoAction(view));
        JMenuItem redoItem = addMenuItem(editMenu, "�������", new RedoAction(view));
        addMenuItem(editMenu, "��������", new DefaultEditorKit.CutAction());
        addMenuItem(editMenu, "����������", new DefaultEditorKit.CopyAction());
        addMenuItem(editMenu, "��������", new DefaultEditorKit.PasteAction());

        editMenu.addMenuListener(new UndoMenuListener(view, undoItem, redoItem));
    }

    public static void initFileMenu(View view, JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("����");
        menuBar.add(fileMenu);

        addMenuItem(fileMenu, "�����", view);
        addMenuItem(fileMenu, "�������", view);
        addMenuItem(fileMenu, "���������", view);
        addMenuItem(fileMenu, "��������� ���...", view);
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "�����", view);
    }
}
