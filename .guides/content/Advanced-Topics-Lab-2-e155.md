----------

## Lab 2 - The Ground

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `advanced`, and double click on `FlappyBird`. Finally, open the `FlappyBird.pde` file. This should open five different files.

![Processing IDE with all of the game files open in separate tabs](.guides/img/advanced/files.png)

|||

In this game, the bird only moves up and down. To give the impression that the bird is flying to the right, the ground is going to be animates. **In the `FlappyBird` file**, add the `ground` attribute. This is going to be another component class. Instantiate the `ground` object in the constructor. **Note**, Processing will underline these lines of code as the `Ground` class does not yet exist.

```java
class Game {
  private PImage background;
  private Ground ground;

  public Game() {
    background = loadImage("background.png");
    ground = new Ground();
  }
```

**In the `Ground` file**, declare the `Ground` class with attributes for an image file and an x-position. Give the attributes a value in the constructor.

```java
class Ground {
  private PImage ground;
  private int x;
  
  public Ground() {
    ground = loadImage("ground.png");
    x = 0;
  }
}
```

Next, we need the ground image appear in the game. Start by adding a `show` method for the `Ground` class. This should place the image to align with the bottom of the background. Use the `x` attribute to represent the horizontal position of the ground image. The y-coordinate should be 650 so the bottom of the ground image touches the bottom of the window.

```java
class Ground {
  private PImage ground;
  private int xPos;
  
  public Ground() {
    ground = loadImage("ground.png");
    xPos = 0;
  }
  
  public void show() {
    image(ground, xPos, 650);
  }
}
```

**In the `Game` file**, update the `show` method to display the ground image. Do this with by calling `show` on the `ground object`.

```java
  public void show() {
    ground.show();
  }
```

|||info
## Try It
Click the triangle button to run you program. You should see the background and ground images in the window. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

## Animating the Ground

To make the bird appear to fly to the right, the ground needs to move to the left. **In the `Ground` file**, add the `update` method which decreases the `x` attribute by one pixel.

```java
  public void update() {
    x -= 1;
  }
```

**In the `Game` file**, go to the `update` method and add the code `ground.update()`. This will move the ground image to the left. 

```java
  public void update() {
    ground.update();
  }
```

However, you will notice that the ground image will disappear. **Go to the `Ground` file.** We need the ground image to infinitely move to the left. First, update the `show` method so that two ground images next to each other. The first image is at position `x`, and the second is at `x + 470` because the ground image is 470 pixels wide.

```java
  public void show() {
    image(ground, x, 650);
    image(ground, x + 470, 650);
  }
```

The ground images will still disappear however. We want this animation to repeat itself. To do this, reset the value of `x` to 0 when the first image is completely out of the window (when `x` is less than -470). After `x` has decreased by 1, use an if-statement to check for this condition. If true, set `x` back to 0. This creates a smooth, infinite animation.

```java
  public void update() {
    x -= 1;
    if (x <= -470) {
      x = 0;
    }
  }
```

|||info
## Try It
Click the triangle button to run you program. You should see the background with an animation that moves ground image infinitely to the left. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

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
  ```
  
  ### `Game` File
  
  ```java
  class Game {
    private PImage background;
    private Ground ground;

    public Game() {
      background = loadImage("background.png");
      ground = new Ground();
    }

    public PImage getBackground() {
      return background;
    }

    public void show() {
      ground.show();
    }

    public void update() {
      ground.update();
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
  
</details>

{Check It!|assessment}(multiple-choice-1248934826)
