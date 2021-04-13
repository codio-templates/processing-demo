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
      for (int i = 0; i < length; i++) {
        System.out.println(i + 1 + ") " + names.get(i));
      }
      System.out.print("\n(#) Select a name \n(A)dd a new contact\n(Q)uit \n> ");
      String input = sc.nextLine().toLowerCase();
      choice = input;
    }
    handleChoice();
  }
  
    private boolean isNumeric(String s) {
    int value;
    
    if (s == null || s.equals("")) {
      return false;
    }
    
    try {
      value = Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public void handleChoice() {
    if (choice.equals("q")) {
      view = "quit";
    } else if (choice.equals("a") && view.equals("list")) {
      view = "add";
    } else if (isNumeric(choice) && view.equals("list")) {
      int num = Integer.parseInt(choice) - 1;
      if (num >= 0 && num < length) {
        index = num;
        view = "info";
      }
    } else if (choice.equals("c") && view.equals("info")) {
      view = "list";
    } else if (choice.equals("n") && view.equals("info")) {
      index = (index + 1 < length) ? index + 1 : 0;
    } else if (choice.equals("p") && view.equals("info")) {
      index = (index - 1 >= 0) ? index - 1 : length - 1;
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