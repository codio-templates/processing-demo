import java.util.ArrayList;

//add class definitions below this line

class Information {
  
}

class Contacts {
  private String view;
  private ArrayList<Information> contactList;
  private String choice;
  private int index;
  
  public Contacts() {
    view = "quit";
    contactList = new ArrayList<Information>();
    choice = "";
    index = 0;
  }
  
  public void display() {
    while (true) {
      if (view.equals("list")) {
        showList();
      } else if (view.equals("info")) {
        showInfo();
      } else if (view.equals("add")) {
        System.out.println();
        addConctact();
      } else if (view.equals("quit")) {
        System.out.println("\nClosing the contact list...\n");
        break;
      }
    }
  }
  
  public void showList() {
    
  }
  
  public void showInfo() {
    
  }
  
  public void addConctact() {
    
  }
}

//add class definitions above this line

public class Lab2 {  
  public static void main(String[] args) {
    
    //add code below this line

    Contacts contacts = new Contacts();
    contacts.display();
    
    //add code above this line
  }
}