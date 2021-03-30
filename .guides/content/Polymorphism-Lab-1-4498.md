----------

## Lab 1

This lab will focus on using polymorphism while interacting with a contact list. There will be a main class `Contacts` that controls the "view" the user sees and responds to user input. The contact information (personal and work) will be an instance of the `Information` class.

## The Contacts Class

This lab is built around the `Contacts` class, which has four attributes:
* `view` - This string attribute controls what the user sees. When the value for `view` changes, the information changes. There are four different views.
  * List view - Shows the list of all of the contacts.
  * Information view - Shows the work and personal information for a particular contact.
  * Add view - Add information for a new contact.
  * Quit view - Leave a message for the user and then end the script.
* `names` - ArrayList of strings that stores the names of each person in the contact list.
* `titles` - ArrayList of strings that stores the titles for each person in the contact list.
* `workPhoneNumbers` - ArrayList of strings that stores the work phone numbers for each person in the contact list.
* `workEmails` - ArrayList of strings that stores the work email addresses for each person in the contact list.
* `personalPhoneNumbers` - ArrayList of strings that stores the personal phone numbers for each person in the contact list.
* `personalEmails` - ArrayList of strings that stores the personal email addresses for each person in the contact list.
* `choice` - This string attribute represents input from the user and is used to change `view`.
* `index` - This integer attribute keeps track of the particular contact whose information is to be displayed.
* `length` - This integer attribute keeps track of the length of the above ArrayLists.

To put polymorphism into practice, we are going to create the abstract class `Information`. This calls will have the abstract methods `displayInfo` and `addInfo`. The `Contacts` class inherits from `Information`, and therefore it must override the `displayInfo` and `addInfo` methods.

```java
//add class definitions below this line

abstract class Information {
  public abstract void displayInfo();
  public abstract void addInfo();
}

class Contacts extends Information {
  
  public void displayInfo() {
    
  }
  
  public void addInfo() {
    
  }
}

//add class definitions above this line
```

Add the attributes and constructor for the `Contacts` class. For testing purposes, set `view` to `"quit"`. We will change this to a more appropriate value later on. The other attributes do not need a value when instantiating the object. Instantiate each ArrayList attribute, set `choice` to `null`, and set `index` and `length` to `0`.

```java
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
}

//add class definitions above this line
```

## The Display Method

The `display` method is designed to be a loop that runs until the user tells the script to end. The method checks the value of the `view` attribute and calls the appropriate method that displays the information for each view. Since the loop is `while (true)`, be sure to include a `break` statement otherwise the loop would never stop (Java would eventually stop the script with an error message).

```java
  public void displayInfo() {
    
  }
  
  public void addInfo() {
    
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
```

## Starting the Other Methods

The `display` method calls three other methods; `displayInfo` and `addInfo` have already been declared. Trying to test the code would cause your script to crash as the `showList` method has not yet been defined. Create the empty method `showList` just as was done with `displayInfo` and `addInfo`. We will come back later and add working code to each method.

```java
  public void displayInfo() {
    
  }
  
  public void addInfo() {
    
  }

  public void showList() {
    
  }
```

## Testing Your Code

Before moving on to the next part of the script, we want to check that our code is working. To do that, instantiate a `Contacts` object and call the `display` method. 

```java
    //add code below this line

    Contacts contacts = new Contacts();
    contacts.display();
    
    //add code above this line
```

Run your program. Because the `view` attribute is `'quit'`, the script should immediately display a message and then stop. Your output should look something like this.

![Lab 1 Output](.guides/img/polymorphism/output_lab1.png)

{Try it | terminal}(sh .guides/bg.sh javac code/polymorphism/Lab1.java java -cp code/polymorphism/ Lab1 1)

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

  public class Lab1 {  
    public static void main(String[] args) {

      //add code below this line

      Contacts contacts = new Contacts();
      contacts.display();

      //add code above this line
    }
  }
  ```
  
</details>
  
{Check It!|assessment}(multiple-choice-29167309)
