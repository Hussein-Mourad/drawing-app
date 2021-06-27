package models;

import java.awt.*;

public class ShapeFactory {
    static int strokeSize = 1;
    static Color strokeColor = Color.BLACK;
    static Color fillColor = Color.BLACK;
    static boolean filled = false;
    static Color brushColor=Color.BLACK;
    static int brushSize=2;
    static int eraserSize=5;

    public static Shape getShape(Shapes shape, Point topCorner) {
        switch (shape) {
            case RECTANGLE:
                return new Rectangle(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor).setFillColor(fillColor).setFilled(filled);
            case SQUARE:
                return new Square(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor).setFillColor(fillColor).setFilled(filled);
            case CIRLCE:
                return new Circle(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor).setFillColor(fillColor).setFilled(filled);
            case ELLIPSE:
                return new Ellipse(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor).setFillColor(fillColor).setFilled(filled);
            case TRIANGLE:
                return new Triangle(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor).setFillColor(fillColor).setFilled(filled);
            case STRAIGHTLINE:
                return new StraightLine(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor);
            case FREELINE:
                return new FreeLine(topCorner).setStrokeSize(strokeSize).setStrokeColor(strokeColor);
             case BRUSH:
                return new FreeLine(topCorner).setStrokeSize(brushSize).setStrokeColor(brushColor);
             case ERASER:
                return new FreeLine(topCorner).setStrokeSize(eraserSize).setStrokeColor(Color.WHITE);
}
        return null;
    }

    public static Shape cloneShape(Shape shape) {
        if (shape instanceof Rectangle) return (Shape) ((Rectangle) shape).clone();
        else if (shape instanceof Square) return (Shape) ((Square) shape).clone();
        else if (shape instanceof Ellipse) return (Shape) ((Ellipse) shape).clone();
        else if (shape instanceof Circle) return (Shape) ((Circle) shape).clone();
        else if (shape instanceof Triangle) return (Shape) ((Triangle) shape).clone();
        else if (shape instanceof StraightLine) return (Shape) ((StraightLine) shape).clone();
        else if (shape instanceof FreeLine) return (Shape) ((FreeLine) shape).clone();
        return null;
    }

    public static void config(int strokeSize, Color strokeColor, Color fillColor, boolean filled) {
        ShapeFactory.strokeSize = strokeSize;
        ShapeFactory.strokeColor = strokeColor;
        ShapeFactory.fillColor = fillColor;
        ShapeFactory.filled = filled;
    }

    public static int getStrokeSize() {
        return strokeSize;
    }

    public static void setStrokeSize(int strokeSize) {
        ShapeFactory.strokeSize = strokeSize;
    }

    public static Color getStrokeColor() {
        return strokeColor;
    }

    public static void setStrokeColor(Color strokeColor) {
        ShapeFactory.strokeColor = strokeColor;
    }

    public static Color getFillColor() {
        return fillColor;
    }

    public static void setFillColor(Color fillColor) {
        ShapeFactory.fillColor = fillColor;
    }

    public static boolean isFilled() {
        return filled;
    }

    public static void setFilled(boolean filled) {
        ShapeFactory.filled = filled;
    }
public static int getBrushSize(){
	return brushSize;
}
public static void setBrushSize(int brushSize){
	ShapeFactory.brushSize=brushSize;
}
public static Color getBrushColor() {
        return brushColor;
    }

    public static void setBrushColor(Color brushColor) {
        ShapeFactory.brushColor = brushColor;
    }

public static int getEraserSize() {
        return eraserSize;
    }

    public static void setEraserSize(int eraserSize) {
        ShapeFactory.eraserSize = eraserSize;
    }


}
