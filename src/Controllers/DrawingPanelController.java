/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Shapes.*;
import Views.ColorBox;
import Views.ColorPicker;
import Views.DrawingPanel;
import Views.Mode;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JPanel;

/**
 *
 * @author hussein
 */
public class DrawingPanelController {

    private Mode mode;
    private static DrawingPanelController instance = null;
    private ColorBox colorBox = new ColorBox();
    private Point mousePosition;
    private State currentState;
    private Shape copiedShape;
    private float lineStroke = 1;
    private float brushStroke = 10;
    private float eraserStroke = 10;
    private Color color = Color.BLACK;
    private boolean fill = false;
    private FreeLine currentDrawnLine;
    private Shape tmpShape;
    private Shape currentMovingShape;
    private Point currentMovingShapePrevPt;
    private boolean cleared = false;
    private boolean deleted = false;
    private String imgFolder = "src" + File.separator + "Assets" + File.separator + "Images" + File.separator;

    // private constructor restricted to this class itself
    private DrawingPanelController(DrawingPanel panel) {
        SharedData.panel = panel;
    }

    // static method to create instance of Singleton class
    public static DrawingPanelController getInstance(DrawingPanel panel) {
        if (instance == null) {
            instance = new DrawingPanelController(panel);
        }
        return instance;
    }

    public void mousePressed(MouseEvent evt) {

        if (evt.isPopupTrigger()) {
            SharedData.panel.getRightClickMenu().show(evt.getComponent(), evt.getX(), evt.getY());
        }
        switch (this.mode) {
            case INSERT_RECTANLE:
                Rectangle rectangle = new Rectangle(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                SharedData.shapes.add(rectangle);
                break;
            case INSERT_SQUARE:
                Square square = new Square(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                SharedData.shapes.add(square);
                break;
            case INSERT_CIRCLE:
                Circle circle = new Circle(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                SharedData.shapes.add(circle);
                break;
            case INSERT_ELLIPSE:
                Ellipse ellipse = new Ellipse(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                SharedData.shapes.add(ellipse);
                break;
            case INSERT_PENCIL:
                currentDrawnLine = new FreeLine(evt.getPoint(), evt.getPoint(), lineStroke, color);
                SharedData.shapes.add(currentDrawnLine);
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case INSERT_TRIANGLE:
                Triangle triangle = new Triangle(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                SharedData.shapes.add(triangle);
                break;
            case INSERT_LINE:
                StraightLine straightLine = new StraightLine(evt.getPoint(), evt.getPoint(), lineStroke, color);
                SharedData.shapes.add(straightLine);
                break;
            case INSERT_BRUSH:
                currentDrawnLine = new FreeLine(evt.getPoint(), evt.getPoint(), brushStroke, color);
                SharedData.shapes.add(currentDrawnLine);
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case ERASER:
                currentDrawnLine = new FreeLine(evt.getPoint(), evt.getPoint(), eraserStroke, Color.WHITE);
                SharedData.shapes.add(currentDrawnLine);
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case FILL:
                fillShape();
                break;
            case MOVE:
                currentMovingShapePrevPt = evt.getPoint();
                break;
            case DELETE:
                deleteShape();
                break;
        }
        if (this.mode != Mode.DEFAULT) {
            this.currentState = new State(SharedData.shapes);
        }
    }

    public void mouseReleased(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            SharedData.panel.getRightClickMenu().show(evt.getComponent(), evt.getX(), evt.getY());
        }
        resetCursor();
        currentDrawnLine = null;
    }

    public void mouseDragged(MouseEvent evt) {
        switch (this.mode) {
            case INSERT_RECTANLE:
            case INSERT_SQUARE:
            case INSERT_CIRCLE:
            case INSERT_ELLIPSE:
            case INSERT_LINE:
            case INSERT_TRIANGLE:
                SharedData.shapes.get(SharedData.shapes.size() - 1).setBottomCornerPosition(evt.getPoint());
                break;
            case INSERT_PENCIL:
            case INSERT_BRUSH:
            case ERASER:
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case MOVE:
                currentMovingShape.move(evt.getPoint(), currentMovingShapePrevPt);
                currentMovingShapePrevPt = evt.getPoint();
                break;
            case DELETE:
                setCustomCursor("outline_clear_black_24dp.png");
                break;
        }
        SharedData.panel.repaint();

    }

    public void mouseMoved(MouseEvent evt) {
        mousePosition = evt.getPoint();
        if (this.mode == Mode.MOVE) {
            for (Shape shape : SharedData.shapes) {
                if (shape.isMouseInside(evt.getPoint())) {
                    setCustomCursor("outline_open_with_black_24dp.png");
                    currentMovingShape = shape;
                } else {
                    resetCursor();
                    currentMovingShape = null;
                }
            }
        }
    }

    public void colorPicker() {
        ColorPicker colorPicker = new ColorPicker(this, SharedData.panel);
        colorPicker.setVisible(true);
    }

    void cut() {
        deleteShape();
        copy();
        this.currentState = new State(SharedData.shapes);

    }

    public void copy() {
        for (Shape shape : SharedData.shapes) {
            if (shape.isMouseInside(mousePosition)) {
                copiedShape = shape;
                break;
            }
        }
    }

    public void paste() {
        Shape pasteShape;
        if (copiedShape instanceof Rectangle) {
            pasteShape = new Rectangle((Rectangle) copiedShape);
        } else if (copiedShape instanceof Square) {
            pasteShape = new Square((Square) copiedShape);
        } else if (copiedShape instanceof Ellipse) {
            pasteShape = new Ellipse((Ellipse) copiedShape);
        } else if (copiedShape instanceof Circle) {
            pasteShape = new Circle((Circle) copiedShape);
        } else if (copiedShape instanceof Triangle) {
            pasteShape = new Triangle((Triangle) copiedShape);
        } else if (copiedShape instanceof StraightLine) {
            pasteShape = new StraightLine((StraightLine) copiedShape);
        } else {
            return;
        }
        pasteShape.setTopCornerPosition(mousePosition);
        pasteShape.setBottomCornerPosition(new Point(mousePosition.x + pasteShape.width, mousePosition.y + pasteShape.height));
        SharedData.shapes.add(pasteShape);
        this.currentState = new State(SharedData.shapes);
        SharedData.panel.repaint();
    }

    public void moveShapetoPos(Shape shape) {
        shape.setTopCornerPosition(mousePosition);
    }

    public void deleteShape() {
        for (Shape shape : SharedData.shapes) {
            if (shape.isMouseInside(mousePosition)) {
                SharedData.shapes.remove(shape);
                deleted = true;
                break;
            }
        }
        SharedData.panel.repaint();
    }

    public void fillShape() {
        Integer index = null;
        Shape newShape = null;
        for (Shape shape : SharedData.shapes) {
            if (shape.isMouseInside(mousePosition)) {
                index = SharedData.shapes.indexOf(shape);
                if (shape instanceof Rectangle) {
                    newShape = new Rectangle(shape.getTopCornerPosition(), shape.getBottomCornerPosition(), shape.getStroke(), color, true);
                } else if (shape instanceof Square) {
                    newShape = new Square(shape.getTopCornerPosition(), shape.getBottomCornerPosition(), shape.getStroke(), color, true);
                } else if (shape instanceof Ellipse) {
                    newShape = new Ellipse(shape.getTopCornerPosition(), shape.getBottomCornerPosition(), shape.getStroke(), color, true);
                } else if (shape instanceof Circle) {
                    newShape = new Circle(shape.getTopCornerPosition(), shape.getBottomCornerPosition(), shape.getStroke(), color, true);
                } else if (shape instanceof Triangle) {
                    newShape = new Triangle(shape.getTopCornerPosition(), shape.getBottomCornerPosition(), shape.getStroke(), color, true);
                }
            }
        }
        if (index != null) {
            SharedData.shapes.set(index, newShape);
        }

        SharedData.panel.repaint();
    }

    public void clearShapes() {
        SharedData.shapes.clear();
        currentState = new State(SharedData.shapes);
        SharedData.panel.repaint();
    }

    public void cursorInsert() {
        SharedData.panel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    public void cursorInsert(JPanel panel) {
        SharedData.panel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    public void resetCursor() {
        SharedData.panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public void resetCursor(JPanel panel) {
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public void setCustomCursor(String filename) {
        String currentDirectory = System.getProperty("user.dir");
        Image image = Toolkit.getDefaultToolkit().createImage(currentDirectory + File.separator + imgFolder + filename);
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), filename);
        SharedData.panel.setCursor(customCursor);
    }

    // Getters and Setters
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Mode getMode() {
        return mode;
    }

    public void resetMode() {
        mode = Mode.DEFAULT;
    }

    public void setMode(Mode mode) {
        switch (mode) {
            case INSERT_RECTANLE:
            case INSERT_SQUARE:
            case INSERT_CIRCLE:
            case INSERT_ELLIPSE:
            case INSERT_LINE:
            case INSERT_TRIANGLE:
                cursorInsert();
                break;
            case INSERT_PENCIL:
                setCustomCursor("outline_create_black_24dp.png");
                break;
            case INSERT_BRUSH:
                setCustomCursor("outline_brush_black_24dp.png");
                break;
            case ERASER:
                setCustomCursor("outline_eraser_black_24dp.png");
                break;
            case FILL:
                setCustomCursor("outline_format_color_fill_black_24dp.png");
                break;
            case MOVE:
                setCustomCursor("outline_open_with_black_24dp.png");
                break;
            case DELETE:
                setCustomCursor("outline_clear_black_24dp.png");
                break;
            case DEFAULT:
                resetCursor();
                break;
        }
        this.mode = mode;
    }

    public float getLineStroke() {
        return lineStroke;
    }

    public void setLineStroke(float lineStroke) {
        this.lineStroke = lineStroke;
    }

    public float getBrushStroke() {
        return brushStroke;
    }

    public void setBrushStroke(float brushStroke) {
        this.brushStroke = brushStroke;
    }

    public float getEraserStroke() {
        return eraserStroke;
    }

    public void setEraserStroke(float eraserStroke) {
        this.eraserStroke = eraserStroke;
    }

    public ColorBox getColorBox() {
        return colorBox;
    }

    public void setColorBox(ColorBox colorBox) {
        this.colorBox = colorBox;
    }
}
