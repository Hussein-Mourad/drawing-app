package views;

import controllers.Controller;
import views.components.Canvas;
import views.components.MenuBar;
import views.components.SideBar;
import views.components.TopBar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    Controller controller;
    Canvas canvas;
    TopBar topBar;
    SideBar sideBar;
    MenuBar menuBar;

    public MainFrame() {
        controller = Controller.getInstance();
        initComponents();
        controller.setFrame(this);
    }

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        try {
//            UIManager.put("control", new Color(128, 128, 128));
//            UIManager.put("control", new Color(18, 18, 18));
////            UIManager.put("info", new Color(128, 128, 128));
//            UIManager.put("info", new Color(18, 18, 18));
////            UIManager.put("nimbusBase", new Color(18, 30, 49));
//            UIManager.put("nimbusBase", new Color(0, 0, 0));
//            UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
////            UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
//            UIManager.put("nimbusDisabledText", new Color(213, 33, 33));
//            UIManager.put("nimbusFocus", new Color(115, 164, 209));
//            UIManager.put("nimbusGreen", new Color(176, 179, 50));
//            UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
//            UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
//            UIManager.put("nimbusOrange", new Color(191, 98, 4));
//            UIManager.put("nimbusRed", new Color(169, 46, 34));
//            UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
//            UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
//            UIManager.put("text", new Color(230, 230, 230));
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
//            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));

    }

    private void initComponents() {
        JPanel centerPanel = new JPanel();
        canvas = new Canvas();
        topBar = new TopBar();
        sideBar = new SideBar();
        menuBar = new MenuBar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(830, 625);
        setMinimumSize(new Dimension(830, 625));
        setLocationByPlatform(true);
        setTitle("Paint app");
        setLayout(new BorderLayout());
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.setLayout(new CardLayout());
        centerPanel.add(canvas);
        setJMenuBar(menuBar);
        add(topBar, BorderLayout.NORTH);
        add(sideBar, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public MenuBar getJMenuBar() {
        return menuBar;
    }
}
