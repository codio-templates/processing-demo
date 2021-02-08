//add class definitions below this line

class Player {
  int health;
  int score;
  int level;
  
  Player(int h, int s, int l) {
    health = h;
    score = s;
    level = 1;
  }
  
  void changeLevel() {
    level += 1;
  }
}
 
//add class definitions above this line

public class Mutability {  
  public static void main(String[] args) {
    
    //add code below this line

    Player mario = new Player(100, 0, 1);
    System.out.println(mario.level);
    mario.changeLevel();
    System.out.println(mario.level);

    //add code above this line
  }
}