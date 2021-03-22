class Person {
  private String name;
  private String address;
  
  public Person(String n, String a) {
    name = n;
    address = a;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String newAddress) {
    address = newAddress;
  }
  
  public String info() {
    return name + " lives at " + address + ".";
  }
}

//add class definitions below this line

class CardHolder extends Person {
  private int accountNumber;
  private double balance;
  private int creditLimit;
  
  public CardHolder(String n, String a, int an) {
    super(n, a);
    accountNumber = an;
    balance = 0;
    creditLimit = 5000;
  }
  
  public int getAccountNumber() {
    return accountNumber;
  }
  
  public void setAccountNumber(int newAccountNumber) {
    accountNumber = newAccountNumber;
  }
  
  public double getBalance() {
    return balance;
  }
  
  public void setBalance(double newBalance) {
    balance = newBalance;
  }
  
  public int getCreditLimit() {
    return creditLimit;
  }
  
  public void setCreditLimit(int newCreditLimit) {
    creditLimit = newCreditLimit;
  }
  
  public void processSale(double price) {
    balance += price;
  }
  
  public void makePayment(double amount) {
    balance -= amount;
  }
}

class PlatinumClient extends CardHolder {
  private double cashBack;
  private double rewards;
  
  public PlatinumClient(String n, String a, int an) {
    super(n, a, an);
    cashBack = 0.02;
    rewards = 0;
  }
  
  public double getCashBack() {
    return cashBack;
  }
  
  public void setCashBack(double newCashBack) {
    cashBack = newCashBack;
  }
  
  public double getRewards() {
    return rewards;
  }
  
  public void setRewards(double newRewards) {
    rewards = newRewards;
  }
  
  public void processSale(double price) {
    rewards += cashBack * price;
    setBalance(getBalance() + price);
  }
}

//add class definitions above this line

public class Exercise5 {
  public static void main(String[] args) {
    
    //add code below this line
  
    PlatinumClient p = new PlatinumClient("Sarah", "101 Main Street", 123364);
    p.processSale(100);
    System.out.println(p.getRewards());
    System.out.println(p.getBalance());
    p.makePayment(50);
    System.out.println(p.getBalance());
    System.out.println(p.info());
  
    //add code above this line   
  }
}