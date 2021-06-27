package views.components;


import controllers.Controller;

import javax.swing.*;
import java.awt.*;

import static controllers.Mode.*;
import static models.Shapes.*;

public class SideBar extends JToolBar {
    Controller controller = Controller.getInstance();

    public SideBar() {
//        setFloatable(false);
        setOrientation(JToolBar.VERTICAL);
        setMargin(new Insets(5, 5, 5, 5));
        ButtonGroup tools = new ButtonGroup();
        JToggleButton mouseBtn = new JToggleButton();
        JToggleButton pencilTool = new JToggleButton();
        JToggleButton brushTool = new JToggleButton();
        JToggleButton eraserTool = new JToggleButton();
        JToggleButton straightLineBtn = new JToggleButton();
        JToggleButton rectangleBtn = new JToggleButton();
        JToggleButton squareBtn = new JToggleButton();
        JToggleButton ellipseBtn = new JToggleButton();
        JToggleButton circleBtn = new JToggleButton();
        JToggleButton triangleBtn = new JToggleButton();
        JToggleButton moveBtn = new JToggleButton();
        JToggleButton deleteBtn = new JToggleButton();
        JToggleButton fillBtn = new JToggleButton();
        JToggleButton resizeBtn = new JToggleButton();

        JButton clearBtn = new JButton();

        mouseBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "mouse-pointer.png")));
        mouseBtn.setToolTipText("Normal mode");
        mouseBtn.setSize(10, 10);
        mouseBtn.addActionListener(actionEvent -> controller.setMode(DEFAULT));

        rectangleBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "rectangle-icon.png")));
        rectangleBtn.setToolTipText("Draw a rectangle");
        rectangleBtn.addActionListener(actionEvent -> controller.setMode(INSERT, RECTANGLE));

        squareBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "square-icon.png")));
        squareBtn.setToolTipText("Draw a square");
        squareBtn.addActionListener(actionEvent -> controller.setMode(INSERT, SQUARE));

        pencilTool.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "pencil-icon.png")));
        pencilTool.setToolTipText("Pencil tool");
        pencilTool.addActionListener(actionEvent -> controller.setMode(INSERT, FREELINE));

        brushTool.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "brush-icon.png")));
        brushTool.setToolTipText("Brush tool");
        brushTool.addActionListener(actionEvent -> controller.setMode(INSERT, BRUSH));

        eraserTool.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "eraser-icon.png")));
        eraserTool.setToolTipText("Eraser tool");
        eraserTool.addActionListener(actionEvent -> controller.setMode(INSERT, ERASER));

        straightLineBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "straight-line-icon.png")));
        straightLineBtn.setToolTipText("Draw a straight line");
        straightLineBtn.addActionListener(actionEvent -> controller.setMode(INSERT, STRAIGHTLINE));

        circleBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "circle-icon.png")));
        circleBtn.setToolTipText("Draw a circle");
        circleBtn.addActionListener(actionEvent -> controller.setMode(INSERT, CIRLCE));

        ellipseBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "oval-icon.png")));
        ellipseBtn.setToolTipText("Draw an ellipse");
        ellipseBtn.addActionListener(actionEvent -> controller.setMode(INSERT, ELLIPSE));

        triangleBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "triangle-icon.png")));
        triangleBtn.setToolTipText("Draw a triangle");
        triangleBtn.addActionListener(actionEvent -> controller.setMode(INSERT, TRIANGLE));

        moveBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "move-icon-small.png")));
        moveBtn.setToolTipText("Move Tool");
        moveBtn.addActionListener(actionEvent -> controller.setMode(MOVE));

        deleteBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "delete-icon.png")));
        deleteBtn.setToolTipText("Delete Tool");
        deleteBtn.addActionListener(actionEvent -> controller.setMode(DELETE));

        resizeBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "resize-icon.png")));
        resizeBtn.setToolTipText("Resize Tool");
        resizeBtn.addActionListener(actionEvent -> controller.setMode(RESIZE));

        fillBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "bucket-fill-icon.png")));
        fillBtn.setToolTipText("Fill Tool");
        fillBtn.addActionListener(actionEvent -> controller.setMode(FILL));

        clearBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "clear-all-icon.png")));
        clearBtn.setToolTipText("Clear all shapes");
        clearBtn.addActionListener(actionEvent -> controller.clearAllShapes());

        tools.add(mouseBtn);
        tools.add(rectangleBtn);
        tools.add(squareBtn);
        tools.add(pencilTool);
        tools.add(brushTool);
        tools.add(straightLineBtn);
        tools.add(circleBtn);
        tools.add(ellipseBtn);
        tools.add(triangleBtn);
        tools.add(moveBtn);
        tools.add(brushTool);
        tools.add(deleteBtn);
        tools.add(fillBtn);
        tools.add(resizeBtn);

        add(mouseBtn);
        addSeparator();
        addSpacing();
        add(pencilTool);
        addSpacing();
        add(brushTool);
        addSpacing();
        add(eraserTool);
        addSpacing();
        addSeparator();
        addSpacing();
        add(straightLineBtn);
        addSpacing();
        add(rectangleBtn);
        addSpacing();
        add(squareBtn);
        addSpacing();
        add(ellipseBtn);
        addSpacing();
        add(circleBtn);
        addSpacing();
        add(triangleBtn);
        addSeparator();
        add(moveBtn);
        add(deleteBtn);
        add(resizeBtn);
        add(fillBtn);
        addSeparator();
        add(clearBtn);
    }

    private void addSpacing() {
        Dimension spacingDimension = new Dimension(5, getHeight());
        add(new Box.Filler(spacingDimension, spacingDimension, spacingDimension));
    }

    private void addSpacing(Dimension d) {
        add(new Box.Filler(d, d, d));
    }
}
