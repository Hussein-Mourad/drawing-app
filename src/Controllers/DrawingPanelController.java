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
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author hussein
 */
public class DrawingPanelController {

    private Mode mode;
    private static DrawingPanelController instance = null;
    private ColorBox colorBox = new ColorBox();
    private State currentState;
    private ArrayList<Shape> shapes = new ArrayList<>(); // TODO convert to stack
    private ArrayList<Shape> clearedShapes = new ArrayList<>(); // TODO convert to stack
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
                shapes.add(rectangle);
                break;
            case INSERT_SQUARE:
                Square square = new Square(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                shapes.add(square);
                break;
            case INSERT_CIRCLE:
                Circle circle = new Circle(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                shapes.add(circle);
                break;
            case INSERT_ELLIPSE:
                Ellipse ellipse = new Ellipse(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                shapes.add(ellipse);
                break;
            case INSERT_PENCIL:
                currentDrawnLine = new FreeLine(evt.getPoint(), evt.getPoint(), lineStroke, color);
                shapes.add(currentDrawnLine);
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case INSERT_TRIANGLE:
                Triangle triangle = new Triangle(evt.getPoint(), evt.getPoint(), lineStroke, color, fill);
                shapes.add(triangle);
                break;
            case INSERT_LINE:
                StraightLine straightLine = new StraightLine(evt.getPoint(), evt.getPoint(), lineStroke, color);
                shapes.add(straightLine);
                break;
            case INSERT_BRUSH:
                currentDrawnLine = new FreeLine(evt.getPoint(), evt.getPoint(), brushStroke, color);
                shapes.add(currentDrawnLine);
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case ERASER:
                currentDrawnLine = new FreeLine(evt.getPoint(), evt.getPoint(), eraserStroke, Color.WHITE);
                shapes.add(currentDrawnLine);
                currentDrawnLine.addPoint(evt.getPoint());
                break;
            case FILL:
                fillShape(evt.getPoint());
                break;
            case MOVE:
                currentMovingShapePrevPt = evt.getPoint();
                break;
            case DELETE:
                deleteShape(evt.getPoint());
                break;
        }
        if (this.mode != Mode.DEFAULT) {
            StateManager.updateState(new State(shapes));
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
                shapes.get(shapes.size() - 1).setBottomCornerPosition(evt.getPoint());
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
        if (this.mode == Mode.MOVE) {
            for (Shape shape : shapes) {
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

    void undo() {
        if (deleted) {
            redo();
            deleted = false;
        } else {
            clearedShapes.add(shapes.get(shapes.size() - 1));
            shapes.remove(shapes.size() - 1);
            SharedData.panel.repaint();
        }
    }

    void redo() {
        if (cleared) {
            shapes.addAll(clearedShapes);
            clearedShapes.clear();
            cleared = false;
        } else {
            shapes.add(clearedShapes.get(clearedShapes.size() - 1));
            clearedShapes.remove(clearedShapes.size() - 1);
        }
        SharedData.panel.repaint();
    }

    void cut(Point mousePosition) {
        ArrayList<Shape> toRemove = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isMouseInside(mousePosition)) {
                toRemove.add(shape);
                copiedShape = shape;
            }
        }
        clearedShapes.addAll(toRemove);

    }

    void copy(Point mousePosition) {
        for (Shape shape : shapes) {
            if (shape.isMouseInside(mousePosition)) {
                if (shape instanceof Rectangle) {
                    copiedShape = new Rectangle((Rectangle) shape, mousePosition);
                } else if (shape instanceof Square) {
                    copiedShape = new Square((Square) shape, mousePosition);
                } else if (shape instanceof Ellipse) {
                    copiedShape = new Ellipse((Ellipse) shape, mousePosition);
                } else if (shape instanceof Circle) {
                    copiedShape = new Circle((Circle) shape, mousePosition);
                } else if (shape instanceof Triangle) {
                    copiedShape = new Triangle((Triangle) shape, mousePosition);
                } else if (shape instanceof StraightLine) {
                    copiedShape = new StraightLine((StraightLine) shape, mousePosition);
                } else if (shape instanceof FreeLine) {
                    copiedShape = new FreeLine((FreeLine) shape, mousePosition);
                }
            }
        }
    }

    void paste(Point mousePosition) {
        copiedShape.setTopCornerPosition(mousePosition);
        shapes.add(copiedShape);
    }

    void deleteShape(Point mousePosition) {
//        shapes.removeIf(shape -> shape.isMouseInside(evt.getPoint()));
        ArrayList<Shape> toRemove = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isMouseInside(mousePosition)) {
                toRemove.add(shape);
            }
        }
        deleted = toRemove.size() != 0;
        clearedShapes.addAll(toRemove);
        shapes.removeAll(toRemove);
        SharedData.panel.repaint();
    }

    void fillShape(Point mousePosition) {
        Integer index = null;
        Shape newShape = null;
        for (Shape shape : shapes) {
            if (shape.isMouseInside(mousePosition)) {
                index = shapes.indexOf(shape);
                if (shape instanceof Rectangle) {
                    newShape = new Rectangle((Rectangle) shape, mousePosition);
                } else if (shape instanceof Square) {
                    newShape = new Square((Square) shape, mousePosition);
                } else if (shape instanceof Ellipse) {
                    newShape = new Ellipse((Ellipse) shape, mousePosition);
                } else if (shape instanceof Circle) {
                    newShape = new Circle((Circle) shape, mousePosition);
                } else if (shape instanceof Triangle) {
                    newShape = new Triangle((Triangle) shape, mousePosition);
                } else if (shape instanceof StraightLine) {
                    newShape = new StraightLine((StraightLine) shape, mousePosition);
                } else if (shape instanceof FreeLine) {
                    newShape = new FreeLine((FreeLine) shape, mousePosition);
                }

//                shape.setFill(true);
//                shape.setColor(color);
            }
        }
        if (index != null) {
            newShape.setFill(true);
            newShape.setColor(color);
            shapes.set(index, newShape);
        }

        SharedData.panel.repaint();
    }

    public void clearShapes() {
        cleared = true;
        clearedShapes.addAll(shapes);
        shapes.clear();
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
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

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
