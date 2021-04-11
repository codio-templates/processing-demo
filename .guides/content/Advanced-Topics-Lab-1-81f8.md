----------

## Lab 1 - Setup

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `advanced`, and double click on `FlappyBird`. Finally, open the `FlappyBird.pde` file. This should open five different files.

![Processing IDE with all of the game files open in separate tabs](.guides/img/advanced/files.png)

|||

We are going to create a clone of the game Flappy Bird that makes use of the topics covered in this module. The tutorial above uses a collection of Processing objects to make the game. We are going to create a composite class, an array of objects, and the lab will use five Processing files.

The first thing to do is set up a generic game. **In the `FlappyBird` file**, Declare the `game` variable. In the `setup` method, set the size of the game and instantiate a `Game` object. In the `draw` method, set the background to the `background` attribute of `game`. Then call the `show` and `update` methods.

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

Processing should underline a few lines of code in red, indicating an error. We need to create the `Game` class with a few methods to make these error go away. **In the `Game` file**, declare the `Game` class. For now, give it the attribute `background`. In the constructor, load an image for the background. Then, make a getter for the `background` attribute. Declare the `show` and `update` methods, but do not write any code in the body. The underlined code should go away. The `show` method will be used to place images on the game window. The `update` method will be used to update the positions of the images in the game window.

```java
class Game {
  private PImage background;

  public Game() {
    background = loadImage("background.png");
  }

  public PImage getBackground() {
    return background;
  }
  
  public void show() {
    
  }
  
  public void update() {
    
  }
}
```

|||info
## Try It
Click the triangle button to run you program. You should see a 400 x 719 window appear with a background image. Close the window or click the square button to stop the program. **Note**, you need to manually save your work in Processing. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

<details>
  <summary><strong>Code</strong></summary>
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

    public Game() {
      background = loadImage("background.png");
    }

    public PImage getBackground() {
      return background;
    }

    public void show() {

    }

    public void update() {

    }
  }
  ```
  
</details>

{Check It!|assessment}(multiple-choice-2800255607)
