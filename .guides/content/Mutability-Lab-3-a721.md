----------

## Lab 3 - Animating the Ball

|||info
## Animation File
For the next two pages, you are going to use the `animation.pde` file. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `mutability`, and double click on `animation`. Finally, open the `animation.pde` file.

|||

{Launch Processing}(bash .guides/processing.sh)

Now that the ball appears on the screen, it is time to make the ball move. The movement should be two dimensional. That means `xPosition` and `yPosition` should both change over time. If the same change is applied to `xPosition` and `yPosition` equally, the ball will only move at a 45-degree angle. A more realistic animation will allow for a greater variation in movement. So two more instance attributes need to be added to the `Ball` class. One will control the velocity in the x-direction, and the other will control the velocity in the y-direction. Both of these attributes will be of type `float`.

```java
//add class definitions below this line

class Ball {
  float xPosition;
  float yPosition;
  color ballColor;
  int radius;
  float xVelocity;
  float yVelocity;

  Ball(float x, float y) {
    xPosition = x;
    yPosition = y;
    ballColor = color(255, 255, 255);
    radius = 20;
    xVelocity = 1;
    yVelocity = 2;
  }
```

Next, there needs to be a new instance method that updates the position of the ball based on the newly created instance attributes. Create the method `updateBall`. It will add the x-velocity to the x-position, as well as add the y-velocity to the y-position.

```
  void drawBall() {
    noStroke();
    fill(ballColor);
    circle(xPosition, yPosition, radius * 2);
  }
  
  void updateBall() {
    xPosition += xVelocity;
    yPosition += yVelocity;
  }
```

Since the `draw` method is an infinite loop, `updateBall` should be called here. That way the ball's position is constantly being updated.

```java
void draw() {
  ball.drawBall();
  ball.updateBall();
}
```

The ball moves, but it leaves a "trail" of where it has been. This happens because Processing is drawing each updated ball on the same background. Instead, we want to color the background (erase the trail), draw the ball, and then update its position. These three steps should happen each time the `draw` method runs. Add the `background` method **before** you draw the ball. Pass `background` an RGB value for the color of the window.

```java
void draw() {
  background(55, 55, 55);
  ball.drawBall();
  ball.updateBall();
}
```

<details>
  <summary><strong>Why is the animation not always smooth?</strong></summary>
  This has to do with how Processing works and how Codio was built. Processing uses something called X server to display graphical output. X server runs on a machine, not in a browser. Codio was designed to have a coding environment run in your browser. To get Processing output into your browser, X server is running on a server farm somewhere far away. Your Processing code gets sent to the server farm, where Processing output is generated, and then sent back to your browser. This means your program's performance depends on network speeds. If your internet connection is not very good, or there is lots of network traffic, this will decrease the quality of your animation.
</details><br>

The animation should work, but the ball disappears off the screen. It is time to make the ball bounce. The general steps to getting ball to bounce are:

1) Use `xPosition` and `yPosition` and ask if the ball is at the edge of the window
1) If yes, then change direction of the velocity

Create the method `bounceBall` with two conditionals. The first checks if the ball is touching left or right sides of the screen, while the second conditional checks if the ball is touching the top or bottom. The edges of the screens are represented by a number between 0 and 400 (the width and height of the window). If the ball is touching the edge of the screen, its position is either less than 0 or greater than 400. When this happens, multiply the appropriate velocity attribute by -1. This will turn a positive number negative and a negative number positive.

```java
  void bounceBall() {
    if (xPosition < 0 || xPosition > 400) {
      xVelocity *= -1;
    }
    
    if (yPosition < 0 || yPosition > 400) {
      yVelocity *= -1;
    }
  }
```

Now call the `bounceBall` method in `draw`.

```java
void draw() {
  background(55, 55, 55);
  ball.drawBall();
  ball.updateBall();
  ball.bounceBall();
}
```

The ball will bounce, but the animation will not look quite right. That is because the location of the circle is its center. So asking if `xPosition` is less than 0 (the left side of the window) means that this boolean expression will be true when half the circle is off of the window. A better way to build the animation is to ask if `xPosition` is less than `radius`. The animation on the left tests if the center of the ball is at the edge of the window. The animation on the right tests if the edge of the ball (the center plus or minus the radius) is touching the edge of the window.

<iframe width="600" height="300" src=".guides/animation/index.html"></iframe>

<br>
<details>
  <summary><strong>Why is this animation much smoother than mine?</strong></summary>
  The animation above is written in JavaScript. This language runs entirely in the browser. So internet connectivity or network traffic will not affect the animation once the JavaScript code has been downloaded to your browser.
</details><br>

Update the `bounceBall` method so that it is asking if the center minus the radius is less than 0 or if the center plus the radius is greater than 400. The ball should now bounce when the edge of the ball touches the edge of the screen.

```java
  void bounceBall() {
    if (xPosition - radius < 0 || xPosition + radius > 400) {
      xVelocity *= -1;
    }
    
    if (yPosition - radius < 0 || yPosition + radius > 400) {
      yVelocity *= -1;
    }
  }
```

You now have a complete bouncing ball animation.

<details>
  <summary><strong>Code</strong></summary>
  
  ```java
  //add class definitions below this line

  class Ball {
    float xPosition;
    float yPosition;
    color ballColor;
    int radius;
    float xVelocity;
    float yVelocity;

    Ball(float x, float y) {
      xPosition = x;
      yPosition = y;
      ballColor = color(255, 255, 255);
      radius = 20;
      xVelocity = 1;
      yVelocity = 2;
    }

    void drawBall() {
      noStroke();
      fill(ballColor);
      circle(xPosition, yPosition, radius * 2);
    }

    void updateBall() {
      xPosition += xVelocity;
      yPosition += yVelocity;
    }

    void bounceBall() {
      if (xPosition - radius < 0 || xPosition + radius > 400) {
        xVelocity *= -1;
      }

      if (yPosition - radius < 0 || yPosition + radius > 400) {
        yVelocity *= -1;
      }
    }
  }

  //add class definitions above this line

  Ball ball;

  void setup() {
    size(400, 400);
    ball = new Ball(50, 50);
  }

  void draw() {
    background(55, 55, 55);
    ball.drawBall();
    ball.updateBall();
    ball.bounceBall();
  }
  ```
  
</details>

{Check It!|assessment}(multiple-choice-2980161329)

