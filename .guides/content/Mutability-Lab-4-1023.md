----------

## Lab 4 - Tips and Tricks

|||info
## Animation File
Finally, you are going to use the `animation.pde` file. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `mutability`, and double click on `animation`. Finally, open the `animation.pde` file.

|||

{Launch Processing}(bash .guides/processing.sh)

### Change Colors

One way to make the animation more interesting would be to have the ball change color each time it bounces. Since color is represented by three numbers, you could add to or subtract from these numbers. Doing so would only make minor changes to the color. Colors are represented by number between 0 and 255, so you have to think about what happens when the color values are smaller than 0 or greater than 255. A better way to implement this is to choose three random numbers each time the ball bounces.

Modify the `bounceBall` method so that the method `changeColor()` is called after the ball bounces. Be sure to add the method call to both conditionals. If not, the ball will only change color when it hits two of the four walls.

```java
  void bounceBall() {
    if (xPosition - radius < 0 || xPosition + radius > 400) {
      xVelocity *= -1;
      changeColor();
    }

    if (yPosition - radius < 0 || yPosition + radius > 400) {
      yVelocity *= -1;
      changeColor();
    }
  }
```

Now, declare the `changeColor` method. To make the code easy to read, the variables `red`, `green`, and `blue` each get a random integer between 0 and 255. The `random` method returns a float between 0 and up to (but not including) the number in parentheses. `floor` is used to truncate a float into an int. These new values will be the new color. The ball should now change color every time it touches the edge of the window.

```java
  void changeColor() {
    int red = floor(random(256));
    int green = floor(random(256));
    int blue = floor(random(256));
    ballColor = color(red, green, blue);
  }
```

### Random Direction

The animation always starts in the same way. It would be more interesting if the ball moved in a randomly selected direction. Using the `random` method from above, create random values for `xVelocity` and `yVelocity` seems pretty easy; just use `random(-3, 3)`. However, there is a chance that a number close to 0 will be selected. That means the ball will move very slowly, and perhaps not move at all if both velocities are 0. What you really want to do is pick a random number between -3 and -1 or between 1 and 3. In the constructor, set the values of `xVelocity` and `yVelocity` to `randomVelocity`.

```java
  Ball(int x, int y) {
    xPosition = x;
    yPosition = y;
    radius = 20;
    ballColor = color(255, 255, 255);
    xVelocity = randomVelocity();
    yVelocity = randomVelocity();
  }
```

There are two random decisions that need to be made. One, will the ball move in a positive or negative direction. Two, define that random number. Start with by asking if `random(1) < 0.5`. This means to take a random float from 0 up to but not including 1. If it is less then `0.5` the ball will travel in one direction; if it is greater it will travel in the other. If the conditional is true, choose a random number between 1 and 3. If false, choose a random number from -3 to -1. Every time you start the program, the ball should move in a randomly selected direction.

```java
  float randomVelocity() {
    if (random(1) < 0.5) {
      return random(1, 3);
    } else {
      return random(-3, -1);
    }
  }
```

### Avoiding Hard Coding

Assume we want to start the ball in the middle of the window when the animation starts. You could instantiate the `Ball` object like this.

```java
ball = new Ball(200, 200);
```

The window is 400 by 400, so the middle would be position (200, 200). Change the window dimensions to 500 by 500, and the ball is no longer in the middle. That is because the starting position is hard coded into the program. That is, the starting position is a fixed number that is independent of the window dimensions. A better way to create the animation is to make the starting position dependent upon the window. Processing has two variables that you do no need to declare: `width` and `height`. These variables represent the width and height of the window. Divide them by 2 when instantiating the `Ball` object. The ball should always start in the middle of the window.

```java
ball = new Ball(width / 2, height / 2);
```


|||challenge
## Try these variations:
* If you change the window size, the ball no longer bounces when it touches the edge of the screen. Modify the `bounceBall` method so that it always bounces when it touches the edge of the screen.

<details>
  <summary><strong>Possible Solution</strong></summary>
  The problem is that <code>400</code> is hard coded in this method. Replace these numbers with <code>width</code> (x-direction) and <code>height</code> (y-direction).
  
  ```java
  void bounceBall() {
    if (xPosition - radius < 0 || xPosition + radius > width) {
      xVelocity *= -1;
      changeColor();
    }

    if (yPosition - radius < 0 || yPosition + radius > height) {
      yVelocity *= -1;
      changeColor();
    }
  }
  ```
</details><br>

* Add a method that increases the speed of the ball each time it bounces.

<details>
  <summary><strong>Possible Solution</strong></summary>
  Note, the x-velocity increases when the ball hits the left or right sides of the window, and the y-velocity when the ball hits the top or bottom of the window. Call the <code>increaseVelocity</code> method after the ball bounces. Then create the <code>increaseVelocity</code> method and pass it <code>"x"</code> or <code>"y"</code> to increase the correct velocity. If the current velocity is negative, subtract 1. If the current velocity is positive, then add 1.
  
  ```java
  void bounceBall() {
    if (xPosition - radius < 0 || xPosition + radius > width) {
      xVelocity *= -1;
      changeColor();
      increaseVelocity("x");
    }

    if (yPosition - radius < 0 || yPosition + radius > height) {
      yVelocity *= -1;
      changeColor();
      increaseVelocity("y");
    }
  }
      
  void increaseVelocity(String direction) {
    if (direction.equals("x")) {
      if (xVelocity > 0) {
        xVelocity += 1;
      } else {
        xVelocity -= 1;
      }
    } else {
      if (yVelocity > 0) {
        yVelocity += 1;
      } else {
        yVelocity -= 1;
      }
    }
  }
  ```
  
</details> <br>

* Add a method that makes the ball grow each time it bounces.

<details>
  <summary><strong>Possible Solution</strong></summary>
  
  Call the <code>growBall</code> method after the ball bounces. Then define this method to increase the <code>radius</code> attribute by 1.
  
```java
  void bounceBall() {
    if (xPosition - radius < 0 || xPosition + radius > width) {
      xVelocity *= -1;
      changeColor();
      increaseVelocity("x");
      growBall();
    }

    if (yPosition - radius < 0 || yPosition + radius > height) {
      yVelocity *= -1;
      changeColor();
      increaseVelocity("y");
      growBall();
    }
  }
      
  void growBall() {
    radius += 1;
  }
  ```
  
</details>

|||

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
      xVelocity = randomVelocity();
      yVelocity = randomVelocity();
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
      if (xPosition - radius < 0 || xPosition + radius > width) {
        xVelocity *= -1;
        changeColor();
        increaseVelocity("x");
        growBall();
      }

      if (yPosition - radius < 0 || yPosition + radius > height) {
        yVelocity *= -1;
        changeColor();
        increaseVelocity("y");
        growBall();
      }
    }

    void growBall() {
      radius += 1;
    }

    void increaseVelocity(String direction) {
      if (direction.equals("x")) {
        if (xVelocity > 0) {
          xVelocity += 1;
        } else {
          xVelocity -= 1;
        }
      } else {
        if (yVelocity > 0) {
          yVelocity += 1;
        } else {
          yVelocity -= 1;
        }
      }
    }

      void changeColor() {
        int red = floor(random(256));
        int green = floor(random(256));
        int blue = floor(random(256));
        ballColor = color(red, green, blue);
      }

      float randomVelocity() {
        if (random(1) < 0.5) {
          return random(1, 3);
        } else {
          return random(-3, -1);
        }
      }
    }

    //add class definitions above this line

    Ball ball;

    void setup() {
      size(500, 500);
      ball = new Ball(width / 2, height / 2);
    }

    void draw() {
      background(55, 55, 55);
      ball.drawBall();
      ball.updateBall();
      ball.bounceBall();
    }
  ```
  
</details>

{Check It!|assessment}(parsons-puzzle-2434922771)
