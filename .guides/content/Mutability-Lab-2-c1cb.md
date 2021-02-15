----------

## Lab 2 - Ball Class

The purpose of this lab is to build a bouncing ball animation with objects and Pygame. Before the animation can take place, the `Ball` class needs to be defined. Since the animation is built on top of Pygame, look at how to draw a circle in Pygame. That will inform you on how to structure the class.

`pygame.draw.circle(surface, color, center, radius)`

The parameters of the circle in Pygame will be the instance variables for the class. The color will be kept as a tuple (three numbers surrounded by parentheses), but the coordinates will be separate instance variables. These variables will change independently of one another, so it is easier to not use a tuple. Start the project by importing Pygame, and then begin building the `Ball` class.

```python
import pygame

class Ball:
  def __init__(self, surface, color, x, y, r):
    self.surface = surface
    self.color = color
    self.x = x
    self.y = y
    self.r = r
```

Next comes all of the setup for getting Pygame to work — initialize Pygame, create a surface, set the caption, create a main loop, etc. Run the program when done. The window should be gray.

```python
import pygame

class Ball:
  def __init__(self, surface, color, x, y, r):
    self.surface = surface
    self.color = color
    self.x = x
    self.y = y
    self.r = r
    
pygame.init()
window = pygame.display.set_mode((400, 400))
pygame.display.set_caption("Bouncing Ball")
clock = pygame.time.Clock()

run = True
while run:
  window.fill((120, 120, 120))
  
  for event in pygame.event.get():
    if event.type == pygame.QUIT:
      run = False

  pygame.display.update()
  clock.tick(30)
pygame.quit()
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 1)

Now that Pygame is up and running, we can turn our attention to the `Ball` class. First, instantiate a `Ball` object called `ball`. The ball should start in the middle of the window, have the color red, and have a radius of 20. The `Ball` object should be created after `window` has been declared, but before the main loop.

```python
pygame.init()
window = pygame.display.set_mode((400, 400))
pygame.display.set_caption("Bouncing Ball")
clock = pygame.time.Clock()
ball = Ball(window, (255, 0, 0), 200, 200, 20)

run = True
```

The `ball` object does not do anything right now. Add the instance method `draw` which will draw the ball on the window. This method will use the instance variables to draw a circle using the Pygame syntax.

```python
class Ball:
  def __init__(self, surface, color, x, y, r):
    self.surface = surface
    self.color = color
    self.x = x
    self.y = y
    self.r = r
    
  def draw(self):
    pygame.draw.circle(self.surface, self.color, (self.x, self.y), self.r)
```

Call this method to draw the ball to the screen. Since the ball will eventually be animated, the `draw` method should be called from within the main loop and after the window has been filled.

```python
run = True
while run:
  window.fill((120, 120, 120))
  ball.draw()
  
  for event in pygame.event.get():
    if event.type == pygame.QUIT:
      run = False

  pygame.display.update()
  clock.tick(30)
pygame.quit()
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 2)



