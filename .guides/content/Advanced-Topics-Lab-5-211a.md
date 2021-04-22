## Lab 5 - Repeating the Pipes

{Launch Processing}(bash .guides/processing.sh 5)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `advanced`, and double click on `FlappyBird`. Finally, open the `FlappyBird.pde` file. This should open five different files.

![Processing IDE with all of the game files open in separate tabs](.guides/img/advanced/files.png)

|||

**Go to the `Pipe` file.** Each time a pipe leaves the game window to the left, it needs to reappear. This pipe should also choose a different height to add a bit of randomness to the game. When the `x` attribute is less than -80, then the pipe has passed the left side of the game window. Modify the `update` method to check for this condition. If true, call the `startOver` method.

```java
  public void update() {
    x -= speed;
    if (x < -80) {
      startOver();
    }
  }
```

We now need to declare the `startOver` method. Set the `x` attribute to 910. This means the "first" pipe becomes the "fourth" pipe. The also maintains the same distance between pipes. The `y` attribute should change as well. Select at random an element from the `pipes` array.

```java
  private void startOver() {
    x = 910;
    y = heights[(int)random(heights.length)];
  }
```

|||info
## Try It
Click the triangle button to run you program. You should see four sets of pipes (top and bottom) move to the left. This should be an infinite animation. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

## Stopping the Game

When the bird hits a pipe, the game should be over. Create the method `touching` and pass it a `Bird` object. This method returns a boolean. Since most of the time the bird is not touching a pipe, the default return value is `false`. Determining if the bird is touching a pipe is a two-step problem. First, ask if the bird (defined by the `x` value plus 51) overlaps the `x` value of the pipe. That means the bird is greater than `x` (the front of the pipe) and less than `x` plus 80 (the end of the pipe).

```java
  public boolean touching(Bird bird) {
    if (bird.getX() + 51 > x && bird.getX() < x + 80) {
      
    }
    return false;
  }
```

The next step in solving this problem is to ask if the bird is **not** flying through the vertical gap between the pipes. The bottom pipe is at location `y` and the gap is 224 pixels. So the top pipe is `y` plus 224. Add another conditional that asks if the bottom of the bird (`y` plus 38) is less than the bottom pipe and if the top of the bird is greater than the top pipe (`y` minus 224). Put the not operator (`!`) in front of this compound conditional. If a bird is overlapping the x-values of the pipe and it's y-value is not in the gap, then the bird is touching a pipe. If all of this is true, return `true`.

```java
  public boolean touching(Bird bird) {
    if (bird.getX() + 51 > x && bird.getX() < x + 80) {
      if (!(bird.getY() + 38 < y && bird.getY() > y - 224)) {
        return true;
      } 
    }
    return false;
  }
```

**Go to the `Game` file.** Once we have determined that the bird is touching a pipe, we are going to stop the game. In the `update` method, find the for loop that moves each pipe. Use a conditional that asks if that pipe is touching the bird. If this is true, call the `gameOver` method.

```java
    for (Pipe p : pipes) {
      p.update();
      if (p.touching(bird)) {
        gameOver();
      }
    }
```

For now, the `gameOver` method will completely stop the game. Use the `noLoop` command. This tells Processing to stop the `draw` method in the `FlappyBird` file. This stops the entire program.

```java
  public void gameOver() {
    noLoop();
  }
```

|||info
## Try It
Click the triangle button to run you program. When the bird hits a pipe, the game stops. You have to close the window before restarting the game. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

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

  void mouseClicked() {
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

    public Game() {
      background = loadImage("background.png");
      ground = new Ground();
      bird = new Bird();

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
      bird.show();
    }

    public void update() {
      ground.update();
      bird.update();

      for (Pipe p : pipes) {
        p.update();
        if (p.touching(bird)) {
          gameOver();
        }
      }
    }

    public void gameOver() {
      noLoop();
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
  
{Check It!|assessment}(multiple-choice-558474011)
