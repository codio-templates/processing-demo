import java.util.ArrayList;
import java.util.Scanner;

//add class definitions below this line

abstract class Information {
  public abstract void displayInfo();
  public abstract void addInfo();
}

class Contacts extends Information {
  private String view;
  private ArrayList<String> names;
  private ArrayList<String> titles;
  private ArrayList<String> workPhoneNumbers;
  private ArrayList<String> workEmails;
  private ArrayList<String> personalPhoneNumbers;
  private ArrayList<String> personalEmails;
  private String choice;
  private int index;
  private int length;

  public Contacts() {
    view = "quit";
    names = new ArrayList<String>();
    titles = new ArrayList<String>();
    workPhoneNumbers = new ArrayList<String>();
    workEmails = new ArrayList<String>();
    personalPhoneNumbers = new ArrayList<String>();
    personalEmails = new ArrayList<String>();
    choice = null;
    index = 0;
    length = 0;
  }

  public void displayInfo() {

  }

  public void addInfo() {

  }

  public void showList() {

  }

  public void display() {
    while (true) {
      if (view.equals("list")) {
        showList();
      } else if (view.equals("info")) {
        displayInfo();
      } else if (view.equals("add")) {
        System.out.println();
        addInfo();
      } else if (view.equals("quit")) {
        System.out.println("\nClosing the contact list...\n");
        break;
      }
    }
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