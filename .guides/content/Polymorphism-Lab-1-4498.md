----------

## Lab 1

This lab will focus on using polymorphism while interacting with a contact list. There will be a main class `Contacts` that controls the "view" the user sees and responds to user input. The contact information (personal and work) will be an instance of the `Information` class.

## The Contacts Class

This lab is built around the `Contacts` class, which has four attributes:
* `view` - This attribute controls what the user sees. When the value for `view` changes, the information changes. There are four different views.
  * List view - Shows the list of all of the contacts.
  * Information view - Shows the work and personal information for a particular contact.
  * Add view - Add information for a new contact.
  * Quit view - Leave a message for the user and then end the script.
* `contact_list` - This is a list of objects that contain the information for each contact.
* `choice` - This attribute represents input from the user and is used to change the `view`.
* `index` - This attribute keeps track of the particular contact whose information is to be displayed.

For testing purposes, set `self.view` to `'quit'`. We will change this to a more appropriate value later on. The other attributes do not need a value when instantiating the object. Make `contact_list` an empty list, and set `choice` and `index` to `None`.

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