----------

## Lab 1 - Setting Up Processing

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `mutability`, and double click on `InheritanceLab`. Finally, open the `InheritanceLab.pde` file. This file will be used for the animation.

|||

This lab is going to use Processing to create some animations using inheritance. We are going to have a window that is 400 pixels by 400 pixels with a black background.

```java
void setup() {
  size(400, 400);
}

void draw() {
  background(0);
}
```

|||info
## Try It
Click the triangle button to run you program. You should see a 400 x 400 window appear. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

### Processing Refresher

* The Window - Pygame programs are run in a window, which is a grid of x- and y-coordinates. The origin point (0, 0) is located in the top-left corner. Use window coordinates to position objects in the window.
![The Window](.guides/img/mutability/Canvas.png)
* Colors - Processing uses the RGB (red, green, blue) system of defining colors. Color values range between 0 and 255, and these values are mixed together. Use this [website](https://htmlcolorcodes.com/color-picker/) to help you find the RGB value you want. The `stroke` command colors the line for shapes and `fill` fills the shape with a color.
* This lab will use the `beginShape()` and `endShape(CLOSE)` commands. These commands tell Processing that you are going to draw a series of vertices and Processing will connect them (in order) with lines. The `CLOSE` command tells Processing to draw a line between the last vertex and the first vertex.

```java
void draw() {
  noStroke();
  fill(255, 0, 0);
  background(0);
  beginShape();
  vertex(200, 100);
  vertex(300, 200);
  vertex(200, 300);
  vertex(100, 200);
  endShape(CLOSE);
}
```

|||challenge
## Try these variations:
* Change the order of vertices to be:

```java
  vertex(200, 100);
  vertex(100, 200);
  vertex(300, 200);
  vertex(200, 300);
```

<details>
  <summary><strong>What happened?</strong></summary>
  Processing draws a polygon in the order of the vertices. If you want a regular polygon, the vertices need to go in either clockwise or counterclockwise order. The first polygon used a clockwise pattern, while the second one used a zigzag pattern.<img src=".guides/img/inheritance/lab1.png" />
</details>

|||

{Check It!|assessment}(multiple-choice-2287591926)
