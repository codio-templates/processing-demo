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
  
  void drawBall() {
    noStroke();
    fill(ballColor);
    circle(xPosition, yPosition, radius * 2);
  }
  
  void updateBall() {
    xPosition += xVelocity;
    yPosition += yVelocity;
  }
  
  void bounceBall() {
    if (xPosition - radius < 0 || xPosition + radius > 400) {
      xVelocity *= -1;
    }
    
    if (yPosition - radius < 0 || yPosition + radius > 400) {
      yVelocity *= -1;
    }
  }
}

//add class definitions above this line

Ball ball;

void setup() {
  size(400, 400);
  ball = new Ball(50, 50);
}

void draw() {
  background(55, 55, 55);
  ball.drawBall();
  ball.updateBall();
  ball.bounceBall();
}
