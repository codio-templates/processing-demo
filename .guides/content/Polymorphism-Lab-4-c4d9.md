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

We want the user to be able to list view of all contacts from the info view when the user enters `c`. Modify the `handleChoice` method to set `view` to `'list'` when `choice` is `c`.

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

## Testing Your Code

This program should be complete now. To test it, add at least two contacts. Pull up their information and use `n` and `p` to cycle through the contact information. Enter `c` to return to the list view of all the contacts.

{Try it | terminal}(sh .guides/bg.sh javac code/polymorphism/Lab4.java java -cp code/polymorphism/ Lab4 1)