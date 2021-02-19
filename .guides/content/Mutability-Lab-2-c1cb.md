----------

## Lab 2 - Ball Class

|||info
## Animation File
For the next three pages, you are going to use the `animation.pde` file. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `mutability`, and double click on `animation`. Finally, open the `animation.pde` file.

|||

{Launch Processing}(bash .guides/processing.sh)

The purpose of this lab is to build a bouncing ball animation with objects and Processing. Before the animation can take place, the `Ball` class and its constructor need to be defined. We'll also set up the window in the `setup` method.

```java
//add class definitions below this line

class Ball {
  float xPosition;
  float yPosition;
  color ballColor;
  int radius;

  Ball(float x, float y) {
    xPosition = x;
    yPosition = y;
    ballColor = color(255, 255, 255);
    radius = 20;
  }
}

//add class definitions above this line

void setup() {
  size(400, 400);
}
```

The next step is to create the method `drawBall` which will draw the `Ball` object to the screen. This method does not have any parameters. Use the `ballColor` attribute with the `fill` command to color the ball. Then use the `circle` command to draw a circle. **Note** the `circle` method takes the x-position, y-position, and the diameter as arguments. Since the `Ball` class has the attribute `radius`, this attribute needs to be multiplied by 2.

```java
  Ball(float x, float y) {
    xPosition = x;
    yPosition = y;
    ballColor = color(255, 255, 255);
    radius = 20;
  }
  
  void drawBall() {
    fill(ballColor);
    circle(xPosition, yPosition, radius * 2);
  }
```

Now that the `Ball` class has a method to draw a shape to the window, we are going to instantiate a `Ball` object. In Processing, global variables are declared before the `setup` method. Values are then given to these variables inside the `setup` method. Finally, call the `drawBall` method in `draw`. You should see a white circle appear in the window.

```java
Ball ball;

void setup() {
  ball = new Ball(50, 50);
}

void draw() {
  ball.drawBall();
}
```

Processing is drawing a black stroke around the circle. To remove this, use the command `noStroke();` in the `drawBall` method. Now you have a solid white circle (and the diameter is still 40 pixels); The `noStroke` command must come before `circle`. It does not matter if `noStroke` comes before or after `fill`.

```java
  void drawBall() {
    noStroke();
    fill(ballColor);
    circle(xPosition, yPosition, radius * 2);
  }
```

{Check It!|assessment}(parsons-puzzle-425645972)
