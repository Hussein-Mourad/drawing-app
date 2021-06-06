/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.app;

/**
 *
 * @author hussein
 */
public interface Shape {

    void draw();

    void remove();

    float getX();

    float getY();

    String getPosition();

    void setPosition(float x, float y);
}
