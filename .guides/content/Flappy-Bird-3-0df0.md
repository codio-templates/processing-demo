----------

## Flappy Bird 3 - The Bird

{Launch Processing}(bash .guides/processing.sh 3)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `advanced`, and double click on `FlappyBird`. Finally, open the `FlappyBird.pde` file. This should open five different files.

![Processing IDE with all of the game files open in separate tabs](.guides/img/advanced/files.png)

|||

You are going to see a pattern emerge. Create a component class. Instantiate an object in the `Game` class. Put the object in the game with the `show` method, then update the object in the `update` method.

**In the `Bird` file**, create the `Bird` class. It should have attributes for an image, an x-position, and a y-position. In the constructor, load the image and set the position of the bird toward the top-left corner.

```java
class Bird {
  private PImage bird;
  private float x;
  private float y;
  
  public Bird() {
    bird = loadImage("bird.png");
    x = 70;
    y = 80;
  }
}
```

The `x` attribute needs a getter method. The `y` attribute needs a getter and a setter. Finally, create the `show` method which draws the bird image to the window using the `x` an `y` attributes.

```java
  public float getX() {
    return x;
  }
  
  public float getY() {
    return y;
  }
  
  public void setY(float newY) {
    y = newY;
  }
  
  public void show() {
    image(bird, x, y);
  }
```

**In the `Game` file**, create the `bird` attribute, and instantiate the `Bird` object in the constructor. In the `show` method, add `bird.show();`. This draws the bird image to the game window.

```java
class Game {
  private PImage background;
  private Ground ground;
  private Bird bird;

  public Game() {
    background = loadImage("background.png");
    ground = new Ground();
    bird = new Bird();
  }

  public PImage getBackground() {
    return background;
  }
  
  public void show() {
    ground.show();
    bird.show();
  }
  
  public void update() {
    ground.update();
  }
}
```

|||info
## Try It
Click the triangle button to run you program. You should see the bird image toward the top-left corner of the window. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

## Gravity

**Be sure you are in the `Bird` file.** Gravity should constantly be pulling the bird towards the ground. In addition, the bird should fall faster the further it falls. To do this, we need attributes for `gravity` and `velocity`. Add them to the `Bird` class and the constructor.

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
```

Add the setter method `seVelocity` to the `Bird` class. This will be used later in the program.

```java
  public void setVelocity(float newVelocity) {
    velocity = newVelocity;
  }
```

Create the `update` method for the `Bird` class. The `velocity` should increase by the amount of `gravity` for every frame of the game. Then add `velocity` to the y-position of the bird. Finally, the bird should not be allowed to fly through the top of the window or fall through the bottom of the window. Use the `constrain` method for the `y` attribute. The `0` represents the top of the window; `612` represents when the bottom of the bird image touches the top of the ground image.

```java
  public void update() {
    velocity += gravity;
    y += velocity;
    y = constrain(y, 0, 612);
  }
```

**In the `Game` file**, modify the `update` method so that the `bird` object calls its `update` method.

```java
  public void update() {
    ground.update();
    bird.update();
  }
```

|||info
## Try It
Click the triangle button to run you program. You should see the bird fall to the ground and stay there. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

## Flapping the Bird's Wings

Click the mouse will cause the bird to "flap" its wings. **Go to `FlappyBird` file**. Processing has a built-in method called `mouseClicked`. This is called whenever the mouse button is pressed and then released. When this happens, have the bird flap its wings. However, we are not in the `Game` file, so you have to say `game.bird.flap` to call the `flap` method on the `bird` object.

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

**Go to the `Bird` file.** Add the `flap` method to the `Bird` class. Set `velocity` to 0 so that the bird stops its downward descent. Then subtract 2.5 from the `velocity` attribute. This will cause the bird to fly up a bit.

```java
  public void flap() {
    velocity = 0;
    velocity -= 2.5;
  }
```

|||info
## Try It
Click the triangle button to run you program. You should see the bird rise when the mouse is clicked. The bird should not be able to fly out of the window. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

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

    public Game() {
      background = loadImage("background.png");
      ground = new Ground();
      bird = new Bird();
    }

    public PImage getBackground() {
      return background;
    }

    public void show() {
      ground.show();
      bird.show();
    }

    public void update() {
      ground.update();
      bird.update();
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
  
</details>
  
{Check It!|assessment}(fill-in-the-blanks-3612340120)
