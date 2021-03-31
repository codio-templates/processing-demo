----------

## Displaying Contact Info

The next step is to display the contact information for a selected contact. On the last page, we already modified `handleChoice` to deal with numeric input. So let's update the `displayInfo` method to display the information. Print the elements from each ArrayList using the attribute `index`. Create a scanner object for user input. Then present the user with some options to return to the list view, go to the next contact, go to the previous contact, or quit. Call the `handleChoice` method to act on the user input.

```java
  public void displayInfo() {
    System.out.println();
    System.out.println(names.get(index));
    System.out.println("Personal email address: " + personalEmails.get(index));
    System.out.println("Personal phone number: " + personalPhoneNumbers.get(index));
    System.out.println("Work title: " + titles.get(index));
    System.out.println("Work email address: " + workEmails.get(index));
    System.out.println("Work phone number: " + workPhoneNumbers.get(index));
    Scanner sc = new Scanner(System.in);
    System.out.print("\n(C)ontact List \n(P)revious contact \n(N)ext contact \n(Q)uit \n> ");
    String input = sc.nextLine().toLowerCase();
    choice = input;
    handleChoice();
  }
```

## Return to Contact List

We want the user to be able to see a list view of all contacts from the info view when the user enters `c`. Modify the `handleChoice` method to set `view` to `'list'` when `choice` is `c`.

```java
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
    }
  }
```

## Next and Previous Contacts

The next feature to add is the ability to change contacts (next or previous) from the info view. Moving the next contact should increase `index` by 1, and moving to the previous contact should decrease `index` by 1. However, we need to make sure that the index is not out of the range of an ArrayList; this would cause the program to crash. To avoid this we are going to have a "wrapping" effect. If the index is at the end of the ArrayList, advancing to the next contact takes you back to the beginning. Similarly, going to the previous contact from the beginning of the ArrayList will take you to the end of the ArrayList.

To do this, we could write a traditional conditional statement. However, that is several lines of code. Instead, you can use a [ternary operator](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html) (also called a conditional expression) to write the same logic in one line of code.

![Ternary Operator](.guides/img/polymorphism/ternary.png)

So when the user enters `n` the index will increase by 1 as long as the index plus 1 is less than `length`. If not, the index becomes 0 (the first contact). Similarly, when the user enters `p`, the index will decrease by 1 as long as the index minus 1 is greater than or equal to 0. If not, the index becomes `length` minus 1 (the last contact). Add the following conditional branches to the `handleChoice` method.

```java
    // The end of the handleChoice method
    } else if (choice.equals("c") && view.equals("info")) {
      view = "list";
    } else if (choice.equals("n") && view.equals("info")) {
      index = (index + 1 < length) ? index + 1 : 0;
    } else if (choice.equals("p") && view.equals("info")) {
      index = (index - 1 >= 0) ? index - 1 : length - 1;
    }
```

## Testing Your Code

This program should be complete now. To test it, add at least two contacts. Pull up their information and use `n` and `p` to cycle through the contact information. Enter `c` to return to the list view of all the contacts.

{Try it | terminal}(sh .guides/bg.sh javac code/polymorphism/Lab4.java java -cp code/polymorphism/ Lab4 1)

<details>
  <summary><strong>Code</strong></summary>
  Your code should look like this:
  
  ```java
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
      System.out.println();
      System.out.println(names.get(index));
      System.out.println("Personal email address: " + personalEmails.get(index));
      System.out.println("Personal phone number: " + personalPhoneNumbers.get(index));
      System.out.println("Work title: " + titles.get(index));
      System.out.println("Work email address: " + workEmails.get(index));
      System.out.println("Work phone number: " + workPhoneNumbers.get(index));
      Scanner sc = new Scanner(System.in);
      System.out.print("\n(C)ontact List \n(P)revious contact \n(N)ext contact \n(Q)uit \n> ");
      String input = sc.nextLine().toLowerCase();
      choice = input;
      handleChoice();
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

  public class Lab4 {  
    public static void main(String[] args) {

      //add code below this line

      Contacts contacts = new Contacts();
      contacts.display();

      //add code above this line
    }
  }
  ```
  
</details>

{Check It!|assessment}(multiple-choice-2280652319)
