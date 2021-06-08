/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.SharedData.shapes;
import Models.Shapes.Shape;
import java.awt.event.MouseEvent;

/**
 *
 * @author hussein
 */
public class DeleteController {

    void deleteShape(MouseEvent evt) {
        for (Shape shape : shapes) {
            if (shape.isMouseInside(evt.getPoint())) {
                shapes.remove(shape);
            }
        }
    }
}
