//add class definitions below this line
    
class SodaMachine {
  private String[] sodas = new String[5];
  private int cokeInventory;
  private int pepsiInventory;
  private int spriteInventory;
  private int drPepperInventory;
  private int canadaDryInventory;
  private double money;
    
  public SodaMachine() {
    sodas = {"coke", "pepsi", "sprite", "dr. pepper"};
    cokeInventory = 20;
    pepsiInventory = 20;
    spriteInventory = 20;
    drPepperInventory = 20;
    money = 10;
  }
  
  public String[] getSodas() {
    return sodas;
  }
  
  public void setSodas(int inde, String newSoda) {
    sodas[index] = newSoda;
  }
  
  public int getCokeInventory() {
    return cokeInventory;
  }
  
  public void setCokeInventory(int newInventory){
    cokeInventory = newInventory;
  }
  
  public int getPepsiInventory() {
    return pepsiInventory;
  }
  
  public void setPepsiInventory(int newInventory){
    pepsiInventory = newInventory;
  }
  
  public int getSprteInventory() {
    return spriteInventory;
  }
  
  public void setSpriteInventory(int newInventory){
    spriteInventory = newInventory;
  }
  
  public int getDrPepperInventory() {
    return drPepperInventory;
  }
  
  public void setDrPepperInventory(int newInventory){
    drPepperInventory = newInventory;
  }
  
  public int getMoney() {
    return money;
  }
  
  public void setMoney(int newMoney){
    money = newMoney;
  }
  
  public int totalInventory() {
    return cokeInventory + pepsiInventory + spriteInventory + drPepperInventory + canadaDryInventory;
  }
  
  public void buySoday(String soda, int amount) {
    if (validSoda(soda) && enoughMoney(amount) && positiveAmount(amount)) {
      updateInventory(soda);
      updateMoney();
    }
  }
  
  private boolean validSoda(String soda) {
    boolean correctSoda = false;
    
    for (String s : sodas) {
      if (soda.equals(s)) {
        correctSoda = true;
      }
    }
    
    if (correctSoda == false) {
      System.out.println("That soda is not sold in this machine");
    }
    return correctSoda;
  }
  
  private boolean enoughMoney(int amount) {
    if (amount >= 2) {
      return true;
    } else {
      System.out.println("You did not insert enough money");
      return false;
    }
  }
  
  private boolean positiveAmount(int amount) {
    if (amount > 0) {
      return true;
    } else {
      System.out.println("You must enter a positive number");
      return false;
    }
  }
  
  private void updateInventory(String soda) {
    if (soda.equals("coke")) {
      cokeInventory--;
    } else if (soda.equals("sprite")) {
      spriteInventory--;
    } else if (soda.equals("pepsi")) {
      pepsiInventory--;
    } else if (soda.equals("dr. pepper")) {
      drPepperInventory--;
    }
  }
  
  private updateMoney() {
    money += 2;
  }
}
  
//add class definitions above this line

public class CodingExercise5 {
  public static void main(String[] args) {
    
    //add code below this line

    

    //add code above this line
  }
}