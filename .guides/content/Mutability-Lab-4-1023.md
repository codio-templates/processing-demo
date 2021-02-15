----------

## Lab 4 - Tips and Tricks

### Change Colors

One way to make the animation more interesting would be to have the ball change color each time it bounces. Since color is represented by three numbers, you could add to or subtract from these numbers. Doing so would only make minor changes to the color. Colors are represented by number between 0 and 255, so you have to think about what happens when the color values are smaller than 0 or greater than 255. A better way to implement this is to choose three random numbers each time the ball bounces. To do this, import the `random` module at the top of the program.

```python
import pygame
import random

class Ball:
  def __init__(self, surface, color, x, y, r):
```

Next, modify the `bounce` method so that `self.color` has a new value. Be sure to add the method call for `self.change_color()` to both conditionals. If not, the ball will only change color when it hits two of the four walls.

```python
def bounce(self):
    if self.x < self.r or self.x > 400 - self.r:
      self.vel_x *= -1
      self.change_color()
    if self.y < self.r or self.y > 400 - self.r:
      self.vel_y *= -1
      self.change_color()
```

Finally, declare the `change_color` method. To make the code easy to read, the variables `red`, `green`, and `blue` each get a random integer between 0 and 255. These new values will be the new color. Do not forget the parentheses as colors in Pygame are stored as a tuple.

```python
def change_color(self):
  red = random.randint(0, 255)
  green = random.randint(0, 255)
  blue = random.randint(0, 255)
  self.color = (red, green, blue)
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 5)

### Random Direction

The animation always starts in the same way. It would be more interesting if the ball moved in a randomly selected direction. Using the `randint` method from above, a random value for `self.vel_x` and `self.vel_y` seems pretty easy; just use `random.randint(-3, 3)`. However, there is a one-in-seven chance that 0 will be selected. That means the ball will not move diagonally, and perhaps not move at all if both velocities are 0. What you really want to do is pick a random number between -3 and -1 or between 1 and 3. In the constructor, set the values of `self.vel_x` and `self.vel_y` to `Ball.random_velocity`.

```python
class Ball:
  def __init__(self, surface, color, x, y, r):
    self.surface = surface
    self.color = color
    self.x = x
    self.y = y
    self.r = r
    self.vel_x = Ball.random_velocity()
    self.vel_y = Ball.random_velocity()
```

Since the `random_velocity` method is not changing an instance variable (it is just returning a value), this would be a good time to use a static method. That also explains why the method call is `Ball.random_velocity` and not `self.random_velocity`. This method is going to use `random.choice` which takes a list as a parameter. Python will randomly select one element from the list. The list `direction` contains the strings `"positive"` and `"negative"`. If `"positive"` is selected, the velocity will be between 1 and 3. If `"negative"` is selected, the velocity will be between -3 and -1.

```python
@staticmethod
def random_velocity():
  direction = random.choice(["positive", "negative"])
  if direction == "positive":
    return random.randint(1, 3)
  else:
    return random.randint(-3, -1)
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 6)

### Avoiding Hard Coding

The ball always starts in the middle of the window. That is because the window is 400 by 400 and the ball's starting position is (200, 200). Change the window dimensions to 500 by 500, and the ball is no longer in the middle. That is because the starting position is hard coded into the program. That is, the starting position is a fixed number that is independent of the window dimensions. A better way to create the animation is to make the starting position dependent upon the window. Before `window` is declared, create the variables `WIDTH` and `HEIGHT` and set their values to 400. Use these variables when setting the size of the window. Finally, set the ball's starting position to middle of the window (divide these variables by 2). **Note**, Pygame requires that x and y positions be represented as an integer. Make sure the dimensions are even numbers or use floor division to avoid floating point positions.

```python
pygame.init()
WIDTH = 400
HEIGHT = 400
window = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Bouncing Ball")
clock = pygame.time.Clock()
ball = Ball(window, (255, 0, 0), WIDTH/2, HEIGHT/2, 20)
```

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 7)

<details>
  <summary><strong>Why are some variables in all caps?</strong></summary>
  A constant is a variable whose value never changes. Using all capital letters is a Python convention for declaring a constant. Since the animation window should not change once it starts, this is a good example of when to use a constant.
</details>

|||challenge
## Try these variations:
* Change the size of the window and run the animation.
* Add a method that increases the speed of the ball each time it bounces.

<details>
  <summary><strong>Possible Solution</strong></summary>
  Note, the x velocity increases when the ball hits the left or right sides of the window, and the y velocity when the ball hits the top or bottom of the window. So there are two methods to increase the velocity.
  
  ```python
  def bounce(self):
    if self.x < self.r or self.x > 400 - self.r:
      self.vel_x *= -1
      self.change_color()
      self.increase_vel_x()
    if self.y < self.r or self.y > 400 - self.r:
      self.vel_y *= -1
      self.change_color()
      self.increase_vel_y()
      
  def increase_vel_x(self):
    if self.vel_x > 0:
      self.vel_x += 1
    else:
      self.vel_x -= 1

  def increase_vel_y(self):
    if self.vel_y > 0:
      self.vel_y += 1
    else:
      self.vel_y -= 1
  ```
  
</details> <br>

* Add a method that makes the ball grow each time it bounces.

<details>
  <summary><strong>Possible Solution</strong></summary>
  
  ```python
  def bounce(self):
    if self.x < self.r or self.x > 400 - self.r:
      self.vel_x *= -1
      self.change_color()
      self.increase_vel_x()
      self.grow_ball()
    if self.y < self.r or self.y > 400 - self.r:
      self.vel_y *= -1
      self.change_color()
      self.increase_vel_y()
      self.grow_ball()
      
  def grow_ball(self):
    self.r += 1
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/Animation.java java -cp code/mutability/ Animation 8)


