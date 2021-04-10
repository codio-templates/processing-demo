class Game {
  private PImage background;
  private boolean active;
  private Bird bird;
  private Ground ground;
  private Pipe[] pipes = new Pipe[4];
  private float score;
  private PFont scoreFont;
  private PFont msgFont;
  private float highScore;

  public Game() {
    active = true;
    background = loadImage("background.png");
    bird = new Bird();
    ground = new Ground();

    for (int i = 0; i < pipes.length; i++) {
      pipes[i] = new Pipe(width + i * 250);
    }

    score = 0;
    scoreFont = createFont("Ubuntu Bold", 32);
    msgFont = createFont("Ubuntu Bold", 48);
    highScore = 0;
  }

  public PImage getBackground() {
    return background;
  }

  public void show() {  
    for (Pipe pipe : pipes) {
      pipe.show();
    }

    ground.show();

    if (active) {
      bird.show();
    } else {
      gameOver();
    }

    showScore();
  }

  public void update() {
    for (Pipe pipe : pipes) {
      pipe.move();
      if (pipe.touching(bird)) {
        gameOver();
      }
    }
    
    ground.update();
    
    if (active) {
      bird.update();
      updateScore();
    } else if (keyPressed) {
      if (key  == ' ') {
      restart();
      }
    }
  }

  public void updateScore() {
    score += 0.01;
  }

  public void showScore() {
    textAlign(CENTER, CENTER);
    if (active) {
      textFont(scoreFont);
      fill(255);
      text((int)score, 25, 25);
    } else {
      String msg = "Press Space Bar\nto Play Again\nHigh Score: " + (int)highScore;
      textFont(msgFont);
      fill(255, 0, 0);
      text(msg, width/2, height/2);
    }
  }

  public void gameOver() {
    active = false;
    if (score > highScore) {
      highScore = score;
    }
  }

  public void restart() {
    active = true;
    score = 0;
    bird.setY(80);
    bird.setVelocity(0);

    for (int i = 0; i < pipes.length; i++) {
      pipes[i] = new Pipe(width + i * 250);
    }
  }
}
