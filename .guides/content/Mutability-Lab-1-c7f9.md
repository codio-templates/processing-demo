----------

## Lab 1 - Drawing Shapes with Java Swing

We previously saw how Java Swing can be used to create a graphical user interface with the `Photogram` program. Swing can also be used to draw shapes and lines. Just as before, create a `JFrame` object that contains our drawing. Give the frame a title to appear in the window. Set the frame's size to 400 pixels by 400 pixels, and make sure that the frame is visible. Finally, tell Java to end the program when the window is closed. You should see a blank window appear when you run the code.

```java
import javax.swing.*;
import java.awt.*;

//add class definitions below this line



//add class definitions above this line

public class Drawing {  
  public static void main(String[] args) {
    
    //add code below this line
    
    JFrame frame = new JFrame("Drawing");
    frame.setSize(400, 400);
    
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //add code above this line
  }
}
```

{Try it}(bash .guides/swing.sh javac code/mutability/Drawing.java java -cp code/mutability/ Drawing 1)

### The Window

Before drawing anything in the window, it is important to understand how the window works. It is a Cartesian plane with an x-axis and a y-axis. However, the origin point (0, 0) is not in the center of the plane. Instead, the origin point is in the top-left corner. That means the x-values increase as you move to the right. Y-values increase as you move down the window. Keep this in mind as you draw and animate shapes on the window.

![The Window](.guides/img/mutability/Canvas.png)

### Extending the JPanel Class

The easiest way to start drawing on a `JFrame` object is to **extend** the `JPanel` class and to **override** the `paintComponent` method. Extending and overriding are a part of inheritance. There will be a future lesson on this topic that goes into more detail. For now, think of inheritance as "borrowing" some Java code and then customizing it for our needs. Create the `Shapes` class that `extends` the `JPanel` class. Next, override the `paintComponent` method. Invoke the `paintComponent` from the parent class and convert the `Graphics` object `g` into a 2D object `g2`.

```java
//add class definitions below this line

class Shapes extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    

  }
}

//add class definitions above this line
```

### Shapes and Lines

Drawing shapes and lines requires you to call specific methods on a `Graphics` object. The parameters to these methods tell Java where and how big to make the shapes and lines. The `x` and `y` parameters represent the top-left corner for each shape.

|Shape|Method|Parameters|
|-----|-------|----------|
|Rectangle (outline)|drawRect|(x, y, width, height)|
|Rectangle (fill)|fillRect|(x, y, width, height)|
|Oval (outline)|drawOval|(x, y, width, height)|
|Oval (fill)|fillOval|(x, y, width, height)|
|Line|drawLine|(startX, startY, endX, endY)|

Add the shapes and lines to the `paintComponent` method.

```java
//add class definitions below this line

class Shapes extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    // draw diagonal lines
    g2.drawLine(0, 0, 400, 400);
    g2.drawLine(400, 0, 0, 400);
    
    // draw a rectangle outline
    g2.drawRect(50, 175, 100, 50);
    
    // draw a rectangle fill
    g2.fillRect(250, 175, 100, 50);
    
    // draw an oval outline
    g2.drawOval(150, 50, 100, 100);
    
    // draw an oval fill
    g2.fillOval(150, 250, 100, 100);
  }
}

//add class definitions above this line
```

When you instantiate a `Shapes` object and add it to `frame`, these shapes and lines will automatically be drawn to the Java Swing window.

```java
    //add code below this line
    
    JFrame frame = new JFrame("Drawing");
    frame.setSize(400, 400);
    
    Shapes shapes = new Shapes();
    frame.add(shapes);
    
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //add code above this line
```

{Try it}(bash .guides/swing.sh javac code/mutability/Drawing.java java -cp code/mutability/ Drawing 2)

See the Graphics class [documentation](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html) for more information about other shapes and lines you can draw. Look at the methods that start with `draw` and `fill`.

### Color

Colors in Swing are created using the `Color` class. You can choose between already [existing colors](https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html), or you can also create a custom color using the **RGB** system. That means various amounts or **R**ed, **G**reen, and **B**lue are mixed together to form a color. The amount of red, green, and blue are represented by a number from 0 to 255. There are many [websites](https://htmlcolorcodes.com/color-picker/) that can help you find the RGB values for any color.

Use the `setColor` method to change the color of a shape or line. **Important**, the `setColor` method should be used before the shape or line is drawn.

```java
    // draw diagonal lines
    g2.setColor(Color.RED);
    g2.drawLine(0, 0, 400, 400);
    g2.setColor(Color.BLUE);
    g2.drawLine(400, 0, 0, 400);
    
    // draw a rectangle outline
    g2.setColor(new Color(150, 50, 200));
    g2.drawRect(50, 175, 100, 50);
    
    // draw a rectangle fill
    g2.setColor(new Color(250, 150, 20));
    g2.fillRect(250, 175, 100, 50);
    
    // draw an oval outline
    g2.setColor(new Color(50, 250, 50));
    g2.drawOval(150, 50, 100, 100);
    
    // draw an oval fill
    g2.setColor(new Color(50, 0, 250));
    g2.fillOval(150, 250, 100, 100);
```

{Try it}(bash .guides/swing.sh javac code/mutability/Drawing.java java -cp code/mutability/ Drawing 3)


|||challenge
## Try these variations:
* Draw a rectangle at position 100, 100 with a width of 50 and a heght of 75. Choose any color you want.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  g2.fillRect(100, 100, 50, 75);
  ```
  
</details><br>

* Draw a circle at position 100, 100 with a diameter of 40. Choose a different color from the rectangle.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  g2.fillOval(100, 100, 40, 40);
  ```
  
</details><br>

* Draw an oval at position 200, 350 with a width of 200 and a heght of 50. Choose any color you want.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  g2.fillOval(200, 350, 200, 50);
  ```
  
</details><br>

* Draw a square at position 300, 200 with a side of 75.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  g2.fillRect(300, 200, 75, 75);
  ```
  
</details>

|||

{Try it}(bash .guides/swing.sh javac code/mutability/Drawing.java java -cp code/mutability/ Drawing 4)

<details>
  <summary><strong>The Position of the Code for Shapes and Lines is Important</strong></summary>
  If shapes or lines are overlapping with other shapes or lines, the ones drawn last are "on top". Similarly, the <code>setColor</code> method only applies to the shape or line that comes after it. The code samples below are "incorrect" because you cannot see the smaller rectangle because it come before the larger rectangle. In addition, only one of the circles is pink because the <code>setColor</code> methods come after the shape.
  
  ```java
      // hidden rectangle
      g2.setColor(new Color(245, 145, 45));
      g2.fillRect(125, 125, 150, 150);
      g2.setColor(new Color(45, 145, 245));
      g2.fillRect(50, 50, 300, 300);

      // incorrect color placement
      g2.fillOval(5, 180, 40, 40);
      g2.setColor(Color.PINK);
      g2.fillOval(355, 180, 40, 40);
      g2.setColor(Color.PINK);
  ```
  
</details>

{Check It!|assessment}(fill-in-the-blanks-2028536607)
