----------

## Lab 3 - Animating the Ball

|||info
## Animation File
For the next three pages, you are going to use the `animation.pde` file. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `mutability`, and double click on `animation`. Finally, open the `animation.pde` file.

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

Call this method after `ball` is drawn to the screen.

```python
run = True
while run:
  window.fill((120, 120, 120))
  ball.draw()
  ball.update()
  
  for event in pygame.event.get():
    if event.type == pygame.QUIT:
      run = False

  pygame.display.update()
  clock.tick(30)
pygame.quit()
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 3)

<details>
  <summary><strong>Why is the animation not always smooth?</strong></summary>
  This has to do with how Pygame works and how Codio was built. Pygame uses something called X server to display graphical output. X server runs on a machine, not in a browser. Codio was designed to have a coding environment run in your browser. To get Pygame output into your browser, X server is running on a server farm somewhere far away. Your Pygame code gets sent to the server farm, Pygame output is generated, and then sent to your browser. This means Pygame output depends on network speeds. If your internet connection is not very good, or there is lots of network traffic, this will decrease the quality of your animation.
</details><br>

The animation should work, but the ball disappears off the screen. It is time to make the ball bounce. The general steps to getting ball to bounce are:

1) Use `self.x` and `self.y` and ask if the ball is at the edge of the window
1) If yes, then change direction of the velocity

The ball will bounce, but the animation will not look quite right. That is because the location of the circle is its center. So asking if `self.x` is less than 0 (the left side of the window) means that this boolean expression will be true when half the circle is off of the window. A better way to build the animation is to ask if `self.x` is less than `self.r` (which is the radius of the circle). The animation on the left tests if the ball is at the edge of the window. The animation on the right tests if the ball is touching the edge of the window plus or minus the radius.

<iframe width="600" height="300" src=".guides/animation/index.html"></iframe>

<br>
<details>
  <summary><strong>Why is this animation much smoother than mine?</strong></summary>
  The animation above is written in JavaScript. This language runs entirely in the browser. So internet connectivity or network traffic will not affect the animation once the JavaScript code has been downloaded to your browser.
</details><br>

Bouncing should take place in the `update` method. This function currently updates the position of the circle. To make things more clear, we are going to refactor (rewrite) this function. The `update` method should move the ball and then bounce the ball if necessary. These two tasks will have their own methods. All the `update` method should do is call the methods `move` and `bounce`.

```python
def update(self):
  self.move()
  self.bounce()
```

The `move` method updates the x and y coordinates of the circle with their respective velocities.

```python
def move(self):
  self.x += self.vel_x
  self.y += self.vel_y
```

The `bounce` method will change the direction of the ball if the distance from the center of the ball to the edge of the window is less than the radius. The boolean expressions that ask if the position is `< self.r` are testing the left and top edges of the window. The boolean expressions that ask if the position is `> 400 - self.r` are testing the right and bottom edges of the window. The act of bouncing happens when the velocity changes direction. Multiplying a number by -1 changes the sign from positive to negative or from negative to positive. So if the ball is touching the left or right sides, multiply `self.vel_x` by -1, and if the ball is touching the top or bottom multiply `self.vel_y` by -1.

```python
def bounce(self):
    if self.x < self.r or self.x > 400 - self.r:
      self.vel_x *= -1
    if self.y < self.r or self.y > 400 - self.r:
      self.vel_y *= -1
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 4)

You should now have a complete bouncing ball animation.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```python
  import pygame
  class Ball:
    def __init__(self, surface, color, x, y, r):
      self.surface = surface
      self.color = color
      self.x = x
      self.y = y
      self.r = r
      self.vel_x = 1
      self.vel_y = 2
    
    def draw(self):
      pygame.draw.circle(self.surface, self.color, (self.x, self.y), self.r)
    
    def update(self):
      self.move()
      self.bounce()
    
    def move(self):
      self.x += self.vel_x
      self.y += self.vel_y
    
    def bounce(self):
      if self.x < self.r or self.x > 400 - self.r:
        self.vel_x *= -1
      if self.y < self.r or self.y > 400 - self.r:
        self.vel_y *= -1
    
  pygame.init()
  window = pygame.display.set_mode((400, 400))
  pygame.display.set_caption("Bouncing Ball")
  clock = pygame.time.Clock()
  ball = Ball(window, (255, 0, 0), 20, 20, 20)
  run = True
  while run:
    window.fill((120, 120, 120))
    ball.draw()
    ball.update()
  
    for event in pygame.event.get():
      if event.type == pygame.QUIT:
        run = False
    pygame.display.update()
    clock.tick(30)
  pygame.quit()
  ```
  
</details>


