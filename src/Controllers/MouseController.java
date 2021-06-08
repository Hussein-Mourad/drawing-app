/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.SharedData.*;
import Models.Shapes.*;
import java.awt.Cursor;
import java.awt.event.MouseEvent;

/**
 *
 * @author hussein
 */
public class MouseController {

    public void mousePressed(MouseEvent evt, ShapesEnum shape) {
        if (dragMode) {
            currentMovingShapePrevPt = evt.getPoint();
        }
        if (shape != null) {
            drawShape(evt, shape);
        }
    }

    public void mouseReleased(MouseEvent evt) {
        panel.getRectangleButton().setSelected(false);
        panel.getSquareButton().setSelected(false);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        tmpLine = null;
    }

    public void mouseDragged(MouseEvent evt, ShapesEnum shape) {
        if (dragMode) {
            currentMovingShape.move(evt.getPoint(), currentMovingShapePrevPt);
            currentMovingShapePrevPt = evt.getPoint();
        }
        if (shape != null) {
            shapes.get(shapes.size() - 1).setBottomCornerPosition(evt.getPoint());
        }

        if (tmpLine != null) {
            tmpLine.addPoint(evt.getPoint());
        }
        panel.repaint();

    }

    public void mouseMoved(MouseEvent evt) {
        for (Shape shape : shapes) {
            if (shape.isMouseInside(evt.getPoint())) {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                currentMovingShape = shape;
            } else {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                currentMovingShape = null;
            }
        }
    }

    void drawShape(MouseEvent evt, ShapesEnum shape) {
        switch (shape) {
            case RECTANGLE:
                Rectangle rectangle = new Rectangle(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                shapes.add(rectangle);
                break;
            case SQUARE:
                Square square = new Square(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                shapes.add(square);
                break;
            case STRAIGHTLINE:
                StraightLine straightLine = new StraightLine(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(straightLine);
                break;
            case FREELINE:
                tmpLine = new FreeLine(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(tmpLine);
                tmpLine.addPoint(evt.getPoint());
                break;
            case ELLIPSE:
                Ellipse ellipse = new Ellipse(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                shapes.add(ellipse);
                break;
            case CIRCLE:
                Circle circle = new Circle(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                shapes.add(circle);
                break;
            case TRIANGLE:
                Triangle triangle = new Triangle(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                shapes.add(triangle);
                break;
            default:
                break;
        }
    }
}
