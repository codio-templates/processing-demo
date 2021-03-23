class Bank {
  private String name;
  private int customers;
  private double[] accounts;
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public int getCustomers() {
    return customers;
  }
  
  public void setCustomers(int newCustomers) {
    customers = newCustomers;
  }
  
  public double[] getAccounts() {
    return accounts;
  }
  
  public void setAccounts(double[] newAccounts) {
    accounts = newAccounts;
  }
  
  public double branchTotal() {
    double total = 0;
    for (double account : accounts) {
      total += account;
    }
    return total;
  }
}

//add class definitions below this line



//add class definitions above this line

public class Exercise4 {
  public static void main(String[] args) {
    
    //add code below this line
    
    
  
    //add code above this line   
  }
}