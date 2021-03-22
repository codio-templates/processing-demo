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

class RegionalBank extends Bank {
  public double[][] regionalAccounts;
  
  public RegionalBank(String n, int c, double[][] a) {
    setName(n);
    setCustomers(c);
    regionalAccounts = a;
  }
  
  public double regionalTotal() {
    double total = 0;
    for (double[] accounts : regionalAccounts) {
      setAccounts(accounts);
      total += branchTotal();
    }
    return total;
  }
}

//add class definitions above this line

public class Exercise4 {
  public static void main(String[] args) {
    
    //add code below this line
    double[][] accounts = {{10000, 13000, 22000},
                           {30000, 7000, 19000},
                           {15000, 23000, 31000}};
    RegionalBank rb = new RegionalBank("Main Street Bank", 9, accounts);
    System.out.println(rb.regionalTotal());
  
    //add code above this line   
  }
}