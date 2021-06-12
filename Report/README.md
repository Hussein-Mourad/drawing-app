# Paint Program

A paint program is a software graphics program that allows the user to draw, color, or paint bitmapped images on a computer.

- [Paint Program](#paint-program)
  - [Authors](#authors)
  - [Badges](#badges)
  - [Demo](#demo)
  - [Screenshots](#screenshots)
  - [Features](#features)
  - [Documentation](#documentation)
    - [Folder Structure Outline](#folder-structure-outline)
    - [Packages](#packages)
    - [Models](#models)
      - [Shape.java](#shapejava)
      - [Rectangle.java](#rectanglejava)
      - [Square.java](#squarejava)
      - [Ellispe.java](#ellispejava)
      - [Circle.java](#circlejava)
      - [Line.java](#linejava)
      - [Triangle.java](#trianglejava)
      - [ShapeFactory.java](#shapefactoryjava)
    - [Controllers](#controllers)
      - [Controller](#controller)
      - [State](#state)
      - [Helper](#helper)
  - [Run Locally](#run-locally)

## Authors

- Amr Abdelsamee Yousef (7126)
- Mohammed Saeed Abdelhafz (7034)
- Hussein Mourad Kassem (6729)
- Ahmed Saeed Nouh (7086)

## Badges

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)

## Demo

Insert gif or link to demo

## Screenshots

![App Screenshot](./screenshot1.png)

## Features

- Draw Shapes: Line, Rectangle, Square, Ellipse, Circle, and Triangle
- Change stroke size
- Change fill Color
- Move different Shapes
- Delete different Shapes
- Clear all Shapes
- Undo / Redo
- Copy / Paste

## Documentation

### Folder Structure Outline

```
src
├── Assets
│   └── Images
├── Controllers
│   ├── Controller.java
│   ├── Helper.java
│   └── State.java
├── Models
│   ├── Circle.java
│   ├── Line.java
│   ├── Oval.java
│   ├── Rectangle.java
│   ├── ShapeFactory.java
│   ├── Shape.java
│   ├── Square.java
│   └── Triangle.java
└── Views
    ├── About.java
    ├── DrawingPanel.java
    └── MainFrame.java
```

### Packages

There a three main packages: Models, Views, and Controllers

### Models

Models package contain all the logic required for drawing different shapes.

#### Shape.java

Each Shape inherit from their an abstact parent class called shape which contain common needed data and logic between classes. The most important ones are draw, move, resize, and delete

```java
package Models;
public abstract class Shape {
    // constructor
    public Shape(int x1, int y1, Color color, float stroke) { }

    public Shape(int x1, int y1, Color color, float stroke, boolean drawFilled) {}

    public abstract void draw(Graphics g);

    public abstract void edit(Graphics g, String a);

    public abstract void move(Point current, Point prev);

    public abstract boolean contains(float x, float y);

    // Getters and Setters
    // Other logic
}
```

#### Rectangle.java

It has all the logic required to handle operations on rectangle it is a child to shape abstract class

```java
package Models;
public class Rectangle extends Shape {
    // constructors
    public Rectangle(int x1, int y1, Color color, float storke) {}
    public Rectangle(int x1, int y1, Color color, float storke, boolean drawFilled) {}
    // draws the shape on the screen using graphics object
    @Override
    public void draw(Graphics g){
      // sets the width and the height
      // draws the shape according to it is filled or not
    }
    // Edits the shape
    public void edit(Graphics g, String s) {
      // refills the shape
    }

    // Moves the shape to the required place
    @Override
    public void move(Point current, Point prev) {
      //changes the corners of the shape
    }


    // Checks if the mouse is inside the shape
    public boolean contains(float x, float y) {
      // if the shape is inside the coordinates of the shape then it is inside
    }
}
```

#### Square.java
The square class is a rectangle with width and height are equal so square class is the same a rectangle class but with little differences

#### Ellispe.java
It handles the drawing of the ellipse. The class follows the same structures as any other class in the package

#### Circle.java
A circle is a special case of ellipse so the two classes are very similar. but width and height of circle is the same

#### Line.java
It draws a line by joining two points together.

#### Triangle.java
It stores the three edges of the triangle so it can draw it.


#### ShapeFactory.java
It is the factory for the shapes it constructs different shapes, makes a copy of the shape, and copies the current state of shapes.

### Controllers
This package takes care of all different controllers and helper function that is used alongside the views
#### Controller
This is the main controller of the program it handles:
- Current state of the program
- The different mouse events
- Changing of the cursor
- Undo and Redo
- Copy
- Inserting Shapes
- Moving Shapes
- Filling Shapes
- Removing Shapes
- Clearing all Shapes

#### State 
This class models the current state of the program it is used alongside controller to handle different states.

#### Helper 
This class carries different helper function:
- Copy current state: copies current state of the program
- isBtnEnabled: checks if a undo can be enabled
- findTheIndex: finds the index from an ArrayList of Shapes 

## Run Locally
Navigate the project folder
```bash
   java build/classes/Views/MainFrame.class
```