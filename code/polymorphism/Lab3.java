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
    view = "list";
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
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter their name: ");
    String name = sc.nextLine();
    names.add(name);

    System.out.print("Enter their personal phone number: ");
    String personalPhone = sc.nextLine();
    personalPhoneNumbers.add(personalPhone);

    System.out.print("Enter their personal email: ");
    String personalEmail = sc.nextLine();
    personalEmails.add(personalEmail);

    System.out.print("Enter their work title: ");
    String title = sc.nextLine();
    titles.add(title);

    System.out.print("Enter their work phone number: ");
    String workPhone = sc.nextLine();
    workPhoneNumbers.add(workPhone);

    System.out.print("Enter their work email: ");
    String workEmail = sc.nextLine();
    workEmails.add(workEmail);

    length++;
    view = "list";
  }

  public void showList() {
    System.out.println();
    Scanner sc = new Scanner(System.in);
    if (length == 0) {
      System.out.print("(A)dd a new contact \n(Q)uit \n> ");
      choice = sc.nextLine().toLowerCase();
    } else {
      view = "quit";
    }
    handleChoice();
  }

  public void handleChoice() {
    switch(choice) {
      case "q":
        view = "quit";
        break;
      case "a":
        if (view.equals("list")) {
          view = "add";
          break;
        }
    }
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

  public int getLength() {
    return length;
  }
}

//add class definitions above this line

public class Lab3 {  
  public static void main(String[] args) {

    //add code below this line

    Contacts contacts = new Contacts();
    contacts.display();
    System.out.println(contacts.getLength());

    //add code above this line
  }
}