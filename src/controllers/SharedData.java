/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.shapes.FreeLine;
import models.shapes.Shape;
import views.DrawingPanel;
import views.Mode;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author hussein
 */
class SharedData {

    static Mode mode;
    static State currentState;
    static ArrayList<Shape> shapes = new ArrayList<>();
    static Shape copiedShape;
    static float lineStroke = 1;
    static float brushStroke = 10;
    static float eraserStroke = 10;
    static Color color = Color.BLACK;
    static boolean fill = false;
    static DrawingPanel panel;
    static FreeLine currentDrawnLine;
    static Shape tmpShape;
    static Shape currentMovingShape;
    static Point currentMovingShapePrevPt;
    static String imgFolder = "src" + File.separator + "Assets" + File.separator + "Images" + File.separator;
}
