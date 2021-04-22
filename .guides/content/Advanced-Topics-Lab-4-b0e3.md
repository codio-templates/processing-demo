----------

## Lab 4 - Pipes

{Launch Processing}(bash .guides/processing.sh 4)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `advanced`, and double click on `FlappyBird`. Finally, open the `FlappyBird.pde` file. This should open five different files.

![Processing IDE with all of the game files open in separate tabs](.guides/img/advanced/files.png)

|||

**Go to the `Pipe` file.** Create the `Pipe` class. It has `x` and `y` coordinates. A `Pipe` object has both a top pipe and a bottom pipe, so the class needs an image for each of them. The `speed` attribute controls how fast the pipes move. Finally, the `heights` attribute is an array of 3 different integers. These numbers determine if the gap between the pipes is towards the bottom, in the middle, or towards the top of the window.

```java
class Pipe {
  private int x;
  private int y;
  private PImage top;
  private PImage bottom;
  private float speed;
  private int[] heights = new int[3];
}
```

The `Pipe` constructor takes an argument for the `x` attribute. The first thing to do is give the `heights` array its values. The `y` attribute is randomly selected from the `heights` array. Set the speed attribute, and load images for the two pipes.

```java
  public Pipe(int xPos) {
    heights = new int[]{295, 425, 562};
    x = xPos;
    y = heights[(int)random(heights.length)];
    speed = 2.0;
    top = loadImage("topPipe.png");
    bottom = loadImage("bottomPipe.png");
  }
```

**Go to the `Game` file.** We want four different pipes, so we need the attribute `pipes` which is an array of type `Pipe` with a length of 4. Since `pipes` is an array, we need a loop that runs four times in the constructor. Each time the loop runs, a new `Pipe` object is created. The `250` represents the number of pixels between each set of pipes.

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
```

## Drawing and Moving the Pipes

In the `show` method for the `Game` class, loop through the `pipes` array and call the `show` method for each element. Processing will show an error because the `show` method has not yet been created. This is okay for now. We want the ground image to appear on top of the pipes, so put the loop before the `ground` object.

```java
  public void show() {
    for (Pipe p : pipes) {
      p.show();
    }
    ground.show();
    bird.show();
  }
```

We are going to do something similar in the `update` method. Instead of calling `show`, call the `update` method. Again, Processing shows an error, but this is okay. It does not matter if the loop is before the `ground` object.

```java
  public void update() {
    ground.update();
    bird.update();
    
    for (Pipe p : pipes) {
      p.update();
    }
```

**Go to the `Pipe` file.** Create the `show` method which will display the top and bottom pipes. We want to create a gap of 224 pixels between the pipes. That is why the y-position of the top pipe subtracts 635 (the height of the pipe image plus 224). In the `update` method, subtract the `speed` attribute from the `x` attribute.

```java
  public void show() {
    image(top, x, y - 635);
    image(bottom, x, y);
  }
  
  public void update() {
    x -= speed;
  }
```

|||info
## Try It
Click the triangle button to run you program. You should see four sets of pipes (top and bottom) move to the left. Eventually they will all disappear. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

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
    }
  }
  ```
  
</details>

{Check It!|assessment}(parsons-puzzle-1661160302)
