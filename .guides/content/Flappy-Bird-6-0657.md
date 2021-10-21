## Flappy Bird 6 - Showing the Score

{Launch Processing}(bash .guides/processing.sh 6)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `advanced`, and double click on `FlappyBird`. Finally, open the `FlappyBird.pde` file. This should open five different files.

![Processing IDE with all of the game files open in separate tabs](.guides/img/advanced/files.png)

|||

**Go to the `Game` file.** We need to determine when the game is being played and when it is over. Add the `active` attribute to the `Game` class. When this attribute is `true`, the game is being played. If `false`, then the game is over. Set the value to `true` in the constructor. Also add the `score` attribute of type float. Set its value to 0 in the constructor.

```java
class Game {
  private PImage background;
  private Ground ground;
  private Bird bird;
  private Pipe[] pipes = new Pipe[4];
  private boolean active;
  private float score;
  private PFont scoreFont;

  public Game() {
    background = loadImage("background.png");
    ground = new Ground();
    bird = new Bird();
    active = true;
    score = 0;
    scoreFont = createFont("Dejavu Sans Bold", 32);
    
    for (int i = 0; i < pipes.length; i++) {
      pipes[i] = new Pipe(width + i * 250);
    }
  }
```

Find the `update` method in the `Game` class. We are only going to update the `Bird` object only if `active` is true. We are also going to update the score with the `updateScore` method.

```java
    if (active) {
      bird.update();
      updateScore();
    }
```

Define the `updateScore` method so that it adds 0.01 to the `score` attribute every frame of the game. The score slowly increases as the game does not end.

```java
  public void updateScore() {
    score += 0.01;
  }
```

Find the `show` method in the `Game` class. Add a conditional so that the bird only appears in the game if `active` is true. Then call the `showScore` method.

```java
    if (active) {
      bird.show();
    }

    showScore();
```

Start by aligning the text to be centered left and right as well as up and down. If `active` is true, the set the font to `scoreFont` and make the font white. Remember, the `score` attribute is a float, but we only want to display the score as a whole number. Convert `score` to an integer and place it in the top-left corner.

```java
  public void showScore() {
    textAlign(CENTER, CENTER);
    if (active) {
      textFont(scoreFont);
      fill(255);
      text((int)score, 25, 25);
    } 
  }
```

Finally, change the `gameOver` method so that it changes `active` to false. Remove the line about `noLoop`. The bird and score should disappear while pipes and ground are still animated.

```java
  public void gameOver() {
    active = false;
  }
```

|||info
## Try It
Click the triangle button to run you program. As you play the game should increase. When you hit a pipe, the bird should disappear from the window. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

## High Score

The next step is to keep track of the high score. Add the attributes `highScore` and `msgFont` to the `Game` class.

```java
  private float highScore;
  private PFont msgFont;
```

In the constructor, set `highScore` to 0 and set the font family and size for `msgFont`.

```java
    highScore = 0;
    msgFont = createFont("Dejavu Sans Bold", 40);
```

We want to show a message when the game is over. Modify the `showScore` method with and `else` statement. Create the variable `msg` that has the message to appear when the game is over. This is a long message, so use the newline character (`\n`) to break up the message over three lines. Concatenate the `highScore` attribute as well. Set the color to red, and place the message in the middle of the window.

```java
  public void showScore() {
    textAlign(CENTER, CENTER);
    if (active) {
      textFont(scoreFont);
      fill(255);
      text((int)score, 25, 25);
    } else {
      String msg = "Press Space Bar\nto Play Again\nHigh Score: " + (int)highScore;
      textFont(msgFont);
      fill(255, 0, 0);
      text(msg, width/2, height/2);
    }
  }
```

Right now, `highScore` is 0. In the `gameOver` method, ask if `score` is greater than `highScore`. If so, set `highScore` to the value of `score`. This should allow the high score to appear in the message when the game is over.

```java
  public void gameOver() {
    active = false;
    if (score > highScore) {
      highScore = score;
    }
  }
```

|||info
## Try It
Click the triangle button to run you program. When you hit a pipe, a red message appears on the screen with the high score. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

## Restarting the game

The final part of the game is to restart it when the space bar is pressed. In the `update` method of the `Game` class, add an `else if` statement for when `active` is false. `keypressed` is a built-in method that returns true if any key on the keyboard is pressed. You then have to ask if `key` (a built-in variable that stores the key that was pressed) if the space character. If this is true, call the `restart` method.

```java
    if (active) {
      bird.update();
      updateScore();
    } else if (keyPressed) {
      if (key  == ' ') {
        restart();
      }
    }
```

The `restart` method should put the game back to its starting state. Set `active` to true, set `score` to 0, put the `bird` back to 80 pixels from the top of the window, set the `velocity` of bird back to 0, and set the pipes back to their original starting positions.

```java
  public void restart() {
    active = true;
    score = 0;
    bird.setY(80);
    bird.setVelocity(0);

    for (int i = 0; i < pipes.length; i++) {
      pipes[i] = new Pipe(width + i * 250);
    }
  }
```

|||info
## Try It
Click the triangle button to run you program. After hitting a pipe, you should be able to restart the game by pressing the space bar. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

<details>
  <summary><Strong>Code</Strong></summary>
  Your code should look like this:
  
  ### `FlappyBird` File
  
  ```java
  Game game;

  void setup() {
    size(400, 719);
    game = new Game();
  }

  void draw() {
    background(game.getBackground());
    game.show();
    game.update();
  }

  void mouseReleased() {
    game.bird.flap();
  }
  ```
  
  ### `Game` File
  
  ```java
  class Game {
    private PImage background;
    private Ground ground;
    private Bird bird;
    private Pipe[] pipes = new Pipe[4];
    private boolean active;
    private float score;
    private PFont scoreFont;
    private float highScore;
    private PFont msgFont;

    public Game() {
      background = loadImage("background.png");
      ground = new Ground();
      bird = new Bird();
      active = true;
      score = 0;
      scoreFont = createFont("Dejavu Sans Bold", 32);
      highScore = 0;
      msgFont = createFont("Dejavu Sans Bold", 40);

      for (int i = 0; i < pipes.length; i++) {
        pipes[i] = new Pipe(width + i * 250);
      }
    }

    public PImage getBackground() {
      return background;
    }

    public void show() {
      for (Pipe p : pipes) {
        p.show();
      }
      ground.show();
      if (active) {
        bird.show();
      }
      showScore();
    }

    public void update() {
      ground.update();
      if (active) {
        bird.update();
        updateScore();
      } else if (keyPressed) {
        if (key  == ' ') {
          restart();
        }
      }

      for (Pipe p : pipes) {
        p.update();
        if (p.touching(bird)) {
          gameOver();
        }
      }
    }

    public void gameOver() {
      active = false;
      if (score > highScore) {
        highScore = score;
      }
    }

    public void updateScore() {
      score += 0.01;
    }

    public void showScore() {
      textAlign(CENTER, CENTER);
      if (active) {
        textFont(scoreFont);
        fill(255);
        text((int)score, 25, 25);
      } else {
        String msg = "Press Space Bar\nto Play Again\nHigh Score: " + (int)highScore;
        textFont(msgFont);
        fill(255, 0, 0);
        text(msg, width/2, height/2);
      }
    }

    public void restart() {
      active = true;
      score = 0;
      bird.setY(80);
      bird.setVelocity(0);

      for (int i = 0; i < pipes.length; i++) {
        pipes[i] = new Pipe(width + i * 250);
      }
    }
  }
  ```
  
  ### `Ground` File
  
  ```java
  class Ground {
    private PImage ground;
    private int x;

    public Ground() {
      ground = loadImage("ground.png");
      x = 0;
    }

    public void show() {
      image(ground, x, 650);
      image(ground, x + 470, 650);
    }

    public void update() {
      x -= 1;
      if (x <= -470) {
        x = 0;
      }
    }
  }
  ```
  
  ### `Bird` File
  
  ```java
  class Bird {
    private PImage bird;
    private float x;
    private float y;
    private float gravity;
    private float velocity;

    public Bird() {
      bird = loadImage("bird.png");
      x = 70;
      y = 80;
      gravity = 0.1;
      velocity = 0;
    }

    public float getX() {
      return x;
    }

    public float getY() {
      return y;
    }

    public void setY(float newY) {
      y = newY;
    }
  
    public void setVelocity(float newVelocity) {
      velocity = newVelocity;
    }

    public void show() {
      image(bird, x, y);
    }

    public void update() {
      velocity += gravity;
      y += velocity;
      y = constrain(y, 0, 612);
    }

    public void flap() {
      velocity = 0;
      velocity -= 2.5;
    }
  }
  ```
  
  ### `Pipe` File
  
  ```java
  class Pipe {
    private int x;
    private int y;
    private PImage top;
    private PImage bottom;
    private float speed;
    private int[] heights = new int[3];

    public Pipe(int xPos) {
      heights = new int[]{295, 425, 562};
      x = xPos;
      y = heights[(int)random(heights.length)];
      speed = 2.0;
      top = loadImage("topPipe.png");
      bottom = loadImage("bottomPipe.png");
    }

    public void show() {
      image(top, x, y - 635);
      image(bottom, x, y);
    }

    public void update() {
      x -= speed;
      if (x < -80) {
        startOver();
      }
    }

    private void startOver() {
      x = 910;
      y = heights[(int)random(heights.length)];
    }

    public boolean touching(Bird bird) {
      if (bird.getX() + 51 > x && bird.getX() < x + 80) {
        if (!(bird.getY() + 38 < y && bird.getY() > y - 224)) {
          return true;
        } 
      }
      return false;
    }
  }
  ```
  
</details>
  
{Check It!|assessment}(multiple-choice-3905612445)
