package views.components;

import controllers.Controller;
import models.Rectangle;
import models.SelectionTool;
import models.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static controllers.Mode.MOVE;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    Controller controller = Controller.getInstance();
    SelectionTool selectionTool;
    Point startPoint, endPoint;
    Rectangle currentMovingShape;
    CanvasRightClickMenu rightClickMenu = new CanvasRightClickMenu();

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setSize(600, 400);
        setBackground(Color.WHITE);
//        rightClickMenu.add(new JMenuItem("Cut"));
//        rightClickMenu.add(new JMenuItem("Paste"));
        add(rightClickMenu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        controller.getShapes().forEach(shape -> shape.draw(g2d));
        if (selectionTool != null) selectionTool.draw(g2d);
        g2d.dispose();
    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        switch (controller.getMode()) {
            case DEFAULT:
                selectionTool.setBottomCorner(mouseEvent.getPoint());
                controller.getShapes().forEach(shape -> shape.setSelected(selectionTool != null && shape.intersects(selectionTool)));
                break;
            case INSERT:
                controller.getShapes().get(controller.getShapes().size() - 1).setBottomCorner(mouseEvent.getPoint());
                break;
            case MOVE:
                currentMovingShape.move(mouseEvent.getPoint(), startPoint);
                break;
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (controller.getMode() == MOVE) {
            for (Shape shape : controller.getShapes()) {
                if (shape.contains(mouseEvent.getPoint()) && shape instanceof Rectangle)
                    currentMovingShape = (Rectangle) shape;
                else
                    currentMovingShape = null;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        startPoint = mouseEvent.getPoint();
        switch (controller.getMode()) {
            case DEFAULT:
                selectionTool = new SelectionTool(mouseEvent.getPoint());
                break;
            case INSERT:
                controller.getShapes().add(ShapeFactory.getShape(controller.getCurrentShape(), mouseEvent.getPoint()));
                break;
            case DELETE:
                rightClickMenu.show(this, getWidth() / 2, getHeight() / 2);
                controller.deleteShapeAtPoint(mouseEvent.getPoint());
                break;
            case RESIZE:
                break;
            case FILL:
                controller.fillShapeAtPoint(mouseEvent.getPoint());
                break;
        }
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        startPoint = endPoint = mouseEvent.getPoint();
        switch (controller.getMode()) {
            case DEFAULT:
                controller.getShapes().forEach(shape -> shape.setSelected(selectionTool != null && shape.intersects(selectionTool)));
                selectionTool = null;
                break;
            case INSERT:
                controller.getShapes().get(controller.getShapes().size() - 1).setDragMode(false);
                break;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
