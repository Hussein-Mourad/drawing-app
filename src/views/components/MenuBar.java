package views.components;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem newProject = new JMenuItem("New Project");
        JMenuItem aboutSection = new JMenuItem("About");

        fileMenu.add(newProject);

        helpMenu.add(aboutSection);

        add(fileMenu);
        add(helpMenu);
    }
}
