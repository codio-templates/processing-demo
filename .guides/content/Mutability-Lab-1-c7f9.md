----------

## Lab 1 - Drawing with Processing

The [Processing](https://processing.org/) language provides a low barrier to writing code with visual output. Processing is Java under the hood, so you will see the same syntax as the previous lessons. However, the structure of the code is slightly different. We are going to use Processing to make a bouncing ball animation. Click the button below to launch Processing.

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `mutability`, and double click on `drawing`. Finally, open the `drawing.pde` file. This file will be used for the animation.

|||

A Processing program is built around two methods: `setup` and `draw`. The `setup` method runs one time, and is used to set the size of the window or give global variables their value. The `draw` method is an infinite loop, which makes animations easier to create. Start by setting the size of the window to 400 pixels by 400 pixels. Unfortunately, you cannot copy/paste code into Processing.

```java
void setup() {
  size(400, 400);
}

void draw() {
  
}
```

|||info
## Try It
Click the triangle button to run you program. You should see a 400 x 400 window appear. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

### The Window

Before drawing anything in the window, it is important to understand how the window works. It is a Cartesian plane with an x-axis and a y-axis. However, the origin point (0, 0) is not in the center of the plane. Instead, the origin point is in the top-left corner. That means the x-values increase as you move to the right. Y-values increase as you move down the window. Keep this in mind as you draw and animate shapes on the window.

![The Window](.guides/img/mutability/Canvas.png)

### Shapes and Lines

Instead of printing text like in Java, we are going to draw shapes and lines to the window. Here are how create some basic shapes and a line.

|Shape|Method|Parameters|
|-----|-------|----------|
|Rectangle|rect|(x, y, width, height)|
|Square|square|(x, y, length)|
|Ellipse|ellipse|(x, y, width, height)|
|Circle|circle|(x, y, diameter)|
|Line|line|(startX, startY, endX, endY)|

Anything drawn to the window should be done inside the `draw` method.

```java
void draw() {
  line(200, 0, 200, 400);
  line(0, 200, 400, 200);
  ellipse(100, 100, 50, 80);
  circle(300, 100, 80);
  rect(75, 260, 50, 80);
  square(260, 260, 80); 
}
```

In Processing, the way circles and ellipses are drawn is different from rectangles and squares. Change the `draw` method to the code below. Both the circle and the square are drawn to the same location with the same size. However, circles and ellipse are drawn from the center of the shape, while square and rectangles are drawn from the top-left corner.

```java
void draw() {
  circle(200, 200, 100);
  square(200, 200, 100);
}
```

You can find more shapes (listed under 2D Primitives) in the Processing [documentation](https://processing.org/reference/).

### Color

By default, Processing gives each shape an exterior color (called the stroke) of black and an interior color (called fill) of white. You can change both of these colors, but first you need to understand that Processing used the **RGB** color scheme. Amounts of **R**ed, **G**reen, and **B**lue are mixed together to form a color. The amount is a number from 0 to 255. You can use [websites](https://htmlcolorcodes.com/color-picker/) to help you determine the RGB value for any color.

Use the `fill` command with an RGB value to color the interior of a shape. The `stroke` command is used to color the outline of a shape and to color lines.

```java
void draw() {
  stroke(255, 195, 0 );
  line(200, 0, 200, 400);
  line(0, 200, 400, 200);
  
  stroke(199, 0, 57);
  fill(255, 87, 51);
  ellipse(100, 100, 50, 80);
  
  stroke(255, 87, 51);
  fill(199, 0, 57);
  circle(300, 100, 80);
  
  stroke(144, 12, 63);
  fill(88, 24, 69);
  rect(75, 260, 50, 80);
  
  stroke(88, 24, 69);
  fill(144, 12, 63);
  square(260, 260, 80); 
}
```

|||challenge
## Try these variations:
* Change the `strokeWeight` in the `setup` method.
```java
void setup() {
  size(400, 400);
  strokeWeight(5);
}
```
<details>
  <summary><strong>What happened?</strong></summary>
  It was hard to see the lines and stroke of each shape. <code>strokeWeight</code> determines how thick lines are drawn. Since we want all shapes and lines to have the same stroke weight, we only need to call this line of code one time, which is why it is in the <code>setup</code> method.
</details><br>

* Draw a rectangle at position 100, 100 with a width of 50 and a heght of 75. Choose any color you want.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  rect(100, 100, 50, 75);
  ```
  
</details><br>

* Draw a circle at position 100, 100 with a diameter of 40. Choose a different color from the rectangle.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  circle(100, 100, 40);
  ```
  
</details><br>

* Draw an ellipse at position 200, 350 with a width of 200 and a height of 50. Choose any color you want.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  ellipse(200, 350, 200, 50);
  ```
  
</details><br>

* Draw a diagonal line from the top-left to the bottom-right.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  line(0, 0, 400, 400);
  ```
  
</details>

|||

<details>
  <summary><strong>The Position of the Code for Shapes and Lines is Important</strong></summary>
  If shapes or lines are overlapping with other shapes or lines, the ones drawn last are "on top". Similarly, the <code>fill</code> method only applies to the shape or line that comes after it. The code samples below are "incorrect" because you cannot see the smaller square because it comes before the larger square. In addition, only one of the circles is pink because the <code>fill</code> methods come after the shape. Switch places for the squares and make sure all of the <code>fill</code> commands come before a shape.
  
  ```java
  void draw() {
    // hidden square
    fill(245, 145, 45);
    square(125, 125, 150);
    fill(45, 145, 245);
    square(50, 50, 300);

    // incorrect color placement
    circle(25, 200, 40);
    fill(244, 88, 178);
    circle(375, 200, 40);
    fill(244, 88, 97);
  }
  ```
  
</details>

{Check It!|assessment}(fill-in-the-blanks-2028536607)
