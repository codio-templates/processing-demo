class Game {
  private PImage background;
  private Ground ground;
  private Bird bird;
  private Pipe[] pipes = new Pipe[4];
  private boolean active;
  private float score;
  private PFont scoreFont;
  private float highScore;
  private PFont msgFont;

  public Game() {
    background = loadImage("background.png");
    ground = new Ground();
    bird = new Bird();
    active = true;
    score = 0;
    scoreFont = createFont("Dejavu Sans Bold", 32);
    highScore = 0;
    msgFont = createFont("Dejavu Sans Bold", 40);

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
    if (active) {
      bird.show();
    }
    showScore();
  }

  public void update() {
    ground.update();
    if (active) {
      bird.update();
      updateScore();
    } else if (keyPressed) {
      if (key  == ' ') {
        restart();
      }
    }

    for (Pipe p : pipes) {
      p.update();
      if (p.touching(bird)) {
        gameOver();
      }
    }
  }

  public void gameOver() {
    active = false;
    if (score > highScore) {
      highScore = score;
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