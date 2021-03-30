----------

## Adding a Contact

The first thing we need to do is change the default view when a `Contacts` object is instantiated. The list view should be the first view shown to the user. Change the value for `view` from `"quit"` to `"list"` in the constructor. The rest of the constructor should not be changed.

```java
  public Contacts() {
    view = "list";
    // rest of the constructor remains unchanged
  }
```

Next we want to modify the `showList` method to show the list of people in the contact list. There are two possible states for the list view: the list is empty or there are contacts in the list. When the list is empty, the user will be provided with the choice to add a contact or quit the script. Use a conditional to represent these two states. For now, set `view` to `"quit"` in the `else` branch.

The print statement is to add a blank line for legibility. We also need a scanner object to collect input from the user. If `length` is 0, then present the user with a choice. Store their input in `choice`. The `.toLowerCase()` will convert the user choice to a lowercase letter. This will make comparisons easier. Remember, Java is case sensitive; `q` and `Q` are not the same. By forcing all input to lowercase, we only need to test for the lowercase letter. The `showList` method ends by calling another method to handle the user's choice.

```java
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
```

## Handling User Choices

Every time the user makes a choice, we want to evaluate that choice and perform the appropriate action. In this case, the user can choose between adding a contact or quitting the script. Notice that `view` only changes to `"add"` if `"a"` is entered **and** we are in list view. We only want to add new contacts from the list view. Options for user input will grow, so a `switch` statement makes sense even if there are only two choices right now.

```java
  public void handleChoice() {
    switch(choice) {
      case "q":
        view = "quit";
        break;
      case "a" && view.equals("list"):
        view = "add";
        break;
    }
  }
```

## Adding a Contact

When the user enters `"a"`, we need to create a new contact. To do this, we are going to modify the `addInfo` method. Create a scanner object and ask the user to enter the name, personal phone number, personal email, work title, work phone number, and work email. Each piece of information should go into the corresponding ArrayList attribute. Once the information has been added, increase the `length` attribute and revert back to the list view.

```java
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
```

## Testing Your Code

Before moving on to the next part of the script, we want to check that our code is adding a contact to the list. To do that, we need to create a getter for the `length` attribute.

```java
  public int getLength() {
    return length;
  }
```

Now call print the result from the `getLength` method.

```java
    //add code below this line

    Contacts contacts = new Contacts();
    contacts.display();
    System.out.println(contacts.getLength());
    
    //add code above this line
```

Run the program and enter `a` when prompted, then add the following contact:

```markdown
Rachel Kim
555 123-4567
rachel_k@myMail.com
Senior Software Engineer
555 890-1234
rkim@appleComputer.com
```

If everything worked properly, your program should print `1` in the terminal as there is one person in our contact list.

{Try it | terminal}(sh .guides/bg.sh javac code/polymorphism/Lab2.java java -cp code/polymorphism/ Lab2 1)

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

  public class Lab2 {  
    public static void main(String[] args) {

      //add code below this line

      Contacts contacts = new Contacts();
      contacts.display();
      System.out.println(contacts.getLength());

      //add code above this line
    }
  }
  ```
  
</details>
  
{Check It!|assessment}(fill-in-the-blanks-3330823136)
