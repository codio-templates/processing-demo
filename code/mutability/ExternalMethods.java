//add class definitions below this line

class Player {
  int health;
  int score;
  int level;
  
  Player() {
    health = 100;
    score = 0;
    level = 1;
  }
}    
 
//add class definitions above this line

public class ExternalMethods {  
  public static void main(String[] args) {
    
    //add code below this line

    Player player1 = new Player();
    System.out.println(printPlayer(player1));
    player1.health = 0;
    player1.score += 25;
    player1.level += 1;
    System.out.println(printPlayer(player1));

    //add code above this line
  }
  
  //add method definitions below this line
  
  public static String printPlayer(Player p) {
    if (p.health <= 0) {
      return "This player is dead. They died on level " + p.level + " with a score of " + p.score + ".";
    } else {
      return "This player has " + p.health + " health, a score of " + p.score + " and is on level " + p.level + ".";
    }
  }
  
  //add method definitions above this line
}