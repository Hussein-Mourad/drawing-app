package views.components;

import controllers.Controller;
import models.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static controllers.Mode.DEFAULT;

public class TopBar extends JToolBar {
    Controller controller = Controller.getInstance();

    public TopBar() {
//        setFloatable(false);
//        setMargin(new Insets(5, 5, 5, 5));
        JButton undoBtn = new JButton();
        JButton redoBtn = new JButton();
        JToggleButton fillShapeButton = new JToggleButton();

        JLabel strokeSizeLabel = new JLabel("Stroke Size: ");
        JLabel strokeColorLabel = new JLabel("Stroke Color: ");
        JLabel fillColorLabel = new JLabel("Fill Color: ");

        JComboBox<Integer> strokeSizeSelector = new JComboBox<>();

        ColorChooserButton strokeColorChooser = new ColorChooserButton(Color.BLACK);
        ColorChooserButton fillColorChooser = new ColorChooserButton(Color.BLACK);


        strokeSizeSelector.setModel(new DefaultComboBoxModel<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        strokeSizeSelector.setToolTipText("Line Stroke");
        strokeSizeSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        strokeSizeSelector.setMaximumSize(new java.awt.Dimension(100, 25));
        strokeSizeSelector.setMinimumSize(new java.awt.Dimension(100, 25));
        strokeSizeSelector.setPreferredSize(new java.awt.Dimension(100, 25));
        strokeSizeSelector.setEditable(false);
        strokeSizeSelector.addActionListener(actionEvent -> ShapeFactory.setStrokeSize(strokeSizeSelector.getSelectedIndex() + 1));

        undoBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "undo-icon-medium.png")));
        undoBtn.setToolTipText("Undo");
        undoBtn.addActionListener(actionEvent -> controller.setMode(DEFAULT));

        redoBtn.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "redo-icon-medium.png")));
        redoBtn.setToolTipText("Redo");
        redoBtn.addActionListener(actionEvent -> System.out.println("redo button clicked"));

        fillShapeButton.setIcon(new ImageIcon(getClass().getResource(controller.imgFolder + "paint-icon.png")));
        fillShapeButton.setToolTipText("Draw shapes filled");
        fillShapeButton.addActionListener(actionEvent -> {
            ShapeFactory.setFilled(fillShapeButton.isSelected());
            fillShapeButton.updateUI();
        });


        strokeSizeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                strokeSizeSelector.showPopup();
            }
        });
        strokeColorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                strokeColorChooser.doClick();
            }
        });

        fillColorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                fillColorChooser.doClick();
            }
        });
        strokeColorChooser.setMargin(new Insets(5, 5, 5, 5));
        strokeColorChooser.setOpenRelativeTo(this.getParent());
        strokeColorChooser.addColorChangedListener(newColor -> ShapeFactory.setStrokeColor(newColor));

        fillColorChooser.setMargin(new Insets(5, 5, 5, 5));
        fillColorChooser.setOpenRelativeTo(this.getParent());
        fillColorChooser.addColorChangedListener(newColor -> ShapeFactory.setFillColor(newColor));

        add(undoBtn);
        add(redoBtn);
        addSeparator();
        addSpacing();
        add(strokeSizeLabel);
        addSpacing();
        add(strokeSizeSelector);
        addSpacing();
        addSeparator();
        addSpacing();
        add(strokeColorLabel);
        add(strokeColorChooser);
        addSeparator();
        addSpacing();
        add(fillColorLabel);
        add(fillColorChooser);
        addSeparator();
        add(fillShapeButton);
    }


    private void addSpacing() {
        Dimension spacingDimension = new Dimension(5, getHeight());
        add(new Box.Filler(spacingDimension, spacingDimension, spacingDimension));
    }

    private void addSpacing(Dimension d) {
        add(new Box.Filler(d, d, d));
    }
}
