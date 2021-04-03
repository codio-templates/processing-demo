----------

## Lab 4 - Extending the Superclass

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `inheritance`, and double click on `InheritanceLab2`. Finally, open the `InheritanceLab2.pde` file. This file will be used for the animation.

|||

Now that we have a superclass, it is time to extend it through inheritance. We want a more general `Polygon` class that can have a user-defined number of vertices. Start by creating the `Polygon` class as a subclass of the `Hexagon` class. Then override the constructor so `vertices` is user-defined. Use the `setVertices` method to update the value `vertices`. In addition, we need to recalculate the `angle` attribute, otherwise the `Polygon` class will draw a hexagon.

```java
class Polygon extends Hexagon {
  
  public Polygon(int x, int y, float r, color c, float sw, int v) {
    super(x, y, r, c, sw);
    setVertices(v);
    setAngle(TWO_PI / getVertices());
  }
}
```

Next, replace references to `Hexagon` with `Polygon`. Do not forget that you need to provide the number of vertices when instantiating a `Polygon` object. In the main loop, call the `show` method for the `Polygon` object. Run your code to make sure you see an octagon.

```java
Polygon p;

void setup() {
  size(400, 400);
  p = new Polygon(width/2, height/2, 175, color(39, 209, 220), 3, 8);
}

void draw() {
  background(0);
  p.show();
}
```

|||challenge
## Try these variations:
* Instantiate the `Polygon` object with 3 vertices
* Instantiate the `Polygon` object with 2 vertices
* Instantiate the `Polygon` object with 1 vertex
* Instantiate the `Polygon` object with 0 vertices

|||

### Animating the Polygon

We are going to animate the polygon by overriding the `show` method. Instead of having a fixed radius (the distance from the vertices from the center of the polygon), we are going to create a radius that increases and decreases over time. This will give the appearance that the polygon is growing and shrinking.

Start by adding the `time` attribute to the `Polygon` constructor. As this value changes, the shape will animate. This value needs to be a `float` since we want to increment this attribute by amounts less than 1.

```java
class Polygon extends Hexagon {
  private float time;
  
  public Polygon(int x, int y, float r, color c, float sw, int v) {
    super(x, y, r, c, sw);
    time = 0;
    setVertices(v);
    setAngle(TWO_PI / getVertices());
  }
}
```

Override the `show` method. There are three small differences in this new method. The local variable `length` is calculated with the helper method `calculateLength`. This variable will replace the `radius` attribute. Be sure to use `length` instead of `radius` when calculating `x` and `y`.

```java
  public void show() {
    beginShape();
    noFill();
    stroke(getClr());
    strokeWeight(getStrokeW());
    float length = calculateLength();
    for (int i = 0; i < getVertices(); i++) {
      float x = cos(getAngle() * i) * length + getXPosition();
      float y = sin(getAngle() * i) * length + getYPosition();
      vertex(x, y);
    }
    endShape(CLOSE);
```

Now we need to define `calculateLength`, which will return a float. Increment the `time` attribute by `.0.01`. This amount represents the speed of the animation. Increase the amount to increase the speed, decrease it to slow down the animation. The variable `length` represents the new distance between the vertex and the center of the polygon. `sin` is used because this function will return a value between -1 and 1. When the result is positive, the polygon grows. When the result is negative, the polygon shrinks. This will create a never-ending animation. It is important to multiply `sin(time)` by `getRadius()`. If not, maximum size the polygon can have is 1 pixel. Return `length` so it can be used to calculate the coordinate pairs for each vertex.

```java
  public float calculateLength() {
    time += 0.01;
    float length = sin(time) * getRadius();
    return length;
  }
```

### Test Your Code

Your octagon should now grow and shrink. Adjust the animation by changing attributes like `vertices`, `time`, `radius`, and `clr`.

|||important
## Save Your Work
If Processing runs your code without any errors, be sure to save your work. This **will not** happen automatically. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

<details>
  <summary><strong>Expected Output</strong></summary>
  <iframe src=".guides/img/inheritance/animations/hexagon_grow/index.html" width=400 height=400/>
</details>

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  class Hexagon {
    private int xPosition;
    private int yPosition;
    private float radius;
    private int vertices;
    private float angle;
    private color clr;
    private float strokeW;

    public float getRadius() {
      return radius;
    }

    public color getClr() {
      return clr;
    }

    public float getStrokeW() {
      return strokeW;
    }

    public int getVertices() {
      return vertices;
    }

    public void setVertices(int newVertices) {
      vertices = newVertices;
    }

    public float getAngle() {
      return angle;
    }

    public void setAngle(float newAngle) {
      angle = newAngle;
    }

    public int getXPosition() {
      return xPosition;
    }

    public int getYPosition() {
      return yPosition;
    }

    public Hexagon() {
      xPosition = 0;
      yPosition = 0;
      radius = 50;
      vertices = 6;
      angle = TWO_PI / vertices;
      clr = color(255, 255, 255);
      strokeW = 1;
    }

    public Hexagon(int x, int y, float r, color c, float sw) {
      xPosition = x;
      yPosition = y;
      radius = r;
      vertices = 6;
      angle = TWO_PI / vertices;
      clr = c;
      strokeW = sw;
    }

    public void show() {
      beginShape();
      noFill();
      stroke(clr);
      strokeWeight(strokeW);
      for (int i = 0; i < vertices; i++) {
        float x = cos(angle * i) * radius + xPosition;
        float y = sin(angle * i) * radius + yPosition;
        vertex(x, y);
      }
      endShape(CLOSE);
    }
  }

  class Polygon extends Hexagon {
    private float time;

    public Polygon(int x, int y, float r, color c, float sw, int v) {
      super(x, y, r, c, sw);
      time = 0;
      setVertices(v);
      setAngle(TWO_PI / getVertices());
    }

    public float calculateLength() {
      time += 0.01;
      float length = sin(time) * getRadius();
      return length;
    }

    public void show() {
      beginShape();
      noFill();
      stroke(getClr());
      strokeWeight(getStrokeW());
      float length = calculateLength();
      for (int i = 0; i < getVertices(); i++) {
        float x = cos(getAngle() * i) * length + getXPosition();
        float y = sin(getAngle() * i) * length + getYPosition();
        vertex(x, y);
      }
      endShape(CLOSE);
    }
  }

  Polygon p;

  void setup() {
    size(400, 400);
    p = new Polygon(width/2, height/2, 175, color(39, 209, 220), 3, 8);
  }

  void draw() {
    background(0);
    p.show();
  }
  ```
</details>

<details>
  <summary><strong>Why is the animation not always smooth?</strong></summary>
  This has to do with how Processing works and how Codio was built. Processing uses something called X server to display graphical output. X server runs on a machine, not in a browser. Codio was designed to have a coding environment run in your browser. To get Processing output into your browser, X server is running on a server farm somewhere far away. Your Processing code gets sent to the server farm, Processing output is generated, and then sent to your browser. This means Processing output depends on network speeds. If your internet connection is not very good, or there is lots of network traffic, this will decrease the quality of your animation.
</details>

|||challenge
## Try these variations:
* Change the `show` method in the `Polygon` class to look like this:
```java
  public void show() {
    beginShape();
    noFill();
    stroke(getClr());
    strokeWeight(getStrokeW());
    float length = calculateLength();
    for (int i = 0; i < getVertices(); i++) {
      float x = cos(getAngle() * i) * length + getXPosition();
      float y = sin(getAngle() * i) * getRadius() + getYPosition();
      vertex(x, y);
    }
    endShape(CLOSE);
  }
```
<details>
  <summary><strong>Expected Output</strong></summary>
  <iframe src=".guides/img/inheritance/animations/hexagon_spin_y/index.html" width=400 height=400/>
</details>

* Change the `show` method in the `Polygon` class to look like this:
```java
  public void show() {
    beginShape();
    noFill();
    stroke(getClr());
    strokeWeight(getStrokeW());
    float length = calculateLength();
    for (int i = 0; i < getVertices(); i++) {
      float x = cos(getAngle() * i) * getRadius() + getXPosition();
      float y = sin(getAngle() * i) * length + getYPosition();
      vertex(x, y);
    }
    endShape(CLOSE);
  }
```
<details>
  <summary><strong>Expected Output</strong></summary>
  <iframe src=".guides/img/inheritance/animations/hexagon_spin_x/index.html" width=400 height=400/>
</details>
<details>
  <summary><strong>Why is this happening?</strong></summary>
  In the first variation, the x-coordinate is animated while the y-coordinate remains the same. This gives the appearance that the polygon is "spinning" around a the y-axis. The second variation animates the x-coordinate while the y-coordinate remains the same. This gives the appearance that the polygon is "spinning" around the x-axis.
</details>

|||

{Check It!|assessment}(multiple-choice-172195837)