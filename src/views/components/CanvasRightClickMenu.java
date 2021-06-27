package views.components;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CanvasRightClickMenu extends JPopupMenu {
    Controller controller = Controller.getInstance();

    public CanvasRightClickMenu() {
        JMenuItem cutButton = new JMenuItem("Cut");
        JMenuItem copyButton = new JMenuItem("Copy");
        JMenuItem pasteButton = new JMenuItem("Paste");

        cutButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        cutButton.addActionListener(actionEvent -> controller.cut(new Point(1, 3)));
        cutButton.setIcon(new ImageIcon(controller.imgFolder + "cut-icon-small.png"));

        copyButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        copyButton.addActionListener(actionEvent -> controller.cut(new Point(1, 3)));
        copyButton.setIcon(new ImageIcon(controller.imgFolder + "copy-icon-small.png"));

        pasteButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        pasteButton.addActionListener(actionEvent -> controller.cut(new Point(1, 3)));
        pasteButton.setIcon(new ImageIcon(controller.imgFolder + "paste-icon-small.png"));

        add(cutButton);
        add(copyButton);
        add(pasteButton);
    }
}
