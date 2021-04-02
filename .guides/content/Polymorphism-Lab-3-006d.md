----------

## Displaying the List View

Now that we can add a contact to the list, we will want to show all of the contacts in the list. But before doing that, we need to remove the print statement at the end of the script. The final two lines of code should look like this:

```java
    //add code below this line

    Contacts contacts = new Contacts();
    contacts.display();

    //add code above this line
```

We are going to iterate through the list of contacts and print the name. To help users select a contact, a number will appear before each name. This way, the user types the number, and the contact's information appears. In the `else` branch of the `showList` method, create a for loop to go from 0 to `length`. We want a number followed by the name. The numbers should start at 1, so print the loop index plus 1 followed by the element from the `names` ArrayList. After displaying the list of names, ask the user to make a selection. Entering a number will show all of the information about a contact.

```java
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
```

## Handling Numeric Input

Add an `else if` branch to the `handleChoice` method that asks if the user input is numeric (remember, the `nextLine` method stores user input as a string) and if the user is in the list view. If yes, then convert the user input to an integer, subtract 1, and store it in the variable `num`. Remember, we added one to the loop index in the `showList` method. If the user made a mistake in entering the number, the script will crash if you try to access an index that is outside of the ArrayList. So we need to verify that the number is between 0 and `length`. Finally, set `index` to `num` and set `view` to `'info'`.

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
    } 
  }
```

We need to create the boolean helper method `isNumeric` which takes the user input and determines if they entered a number. First see if the user input (a string) is `null` or empty. Return `false` if either condition is true. Then try to convert the string to an integer. If this works return `true`. If Java throws an exception because the string cannot be converted to an integer, then return `false`.

```java
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
```

## Testing Your Code

Before moving on to the next part of the program, we want to check that our code is displaying all of the contacts in the list. To do that, enter two different contacts. The first one is:

```markdown
John Calvin
555 111-2222
john.calvin@email.net
Philosopher
555 333-4444
jcalvin@work.org
```

You should see a list that looks like this:

![Contact 1](.guides/img/polymorphism/lab3_pic1.png)

Now add a second contact to the list:

```markdown
Thomas Hobbes
555 666-7777
t_hobbes@email.net
Philosopher
555 888-9999
tom_hobbes@work.org
```

Your program should now show the following output:

![Contact 2](.guides/img/polymorphism/lab3_pic2.png)

{Try it | terminal}(sh .guides/bg.sh javac code/polymorphism/Lab3.java java -cp code/polymorphism/ Lab3 1)

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

      //add code above this line
    }
  }
  ```
  
</details>

{Check It!|assessment}(fill-in-the-blanks-195896886)
