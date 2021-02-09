----------

## One Item Was Served

This is a relatively simple case. The trickiest part will be capitalizing the word at the beginning of the sentence. Start by asking if the size of `course` is 1. If only one item is served, that item should be capitalized followed by `" was served with the meal."`.

```java
  void printCourse(ArrayList<String> course, String name) {
    if (course.size() == 0) { // check for empty ArrayList
      String verb = "";
      if (name.equals("drinks")) {
        verb = "drinks were";
      } else if (name.equals("appetizers")) {
        verb = "appetizers were";
      } else if (name.equals("main course")) {
        verb = "main course was";
      } else if (name.equals("dessert")) {
        verb = "dessert was";
      }
      System.out.println("No " + verb + " served with the meal.");
    } else if (course.size() == 1) { // check for one item
      
    }
  }
```

Create the string variable `item` and set it to the first element in `course`. This string needs to be capitalized. Use `substring(0,1)` to represent the first character in the string. Then call the `toUpperCase()` method to capitalize this character. Finally, concatenate this character with the rest of the string, which is represented by `substring(1)`. Print out a sentence using the `item` string.

```java
    } else if (course.size() == 1) { // check for one item
      String item = course.get(0);
      item = item.substring(0, 1).toUpperCase() + item.substring(1);
      System.out.println(item + " was served with the meal.");
    }
```

**Note**, remove the comment symbol `//` for `dinner.addDessert("chocolate cake");`.

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 6)

## Two Items Were Served

If there are two items being served, the first item should be capitalized followed by `and` and the second item. The sentence will end with `" were served with the meal."`. Start by asking if the size of `course` is 2.

```java
  void printCourse(ArrayList<String> course, String name) {
    if (course.size() == 0) {
      String verb = "";
      if (name.equals("drinks")) {
        verb = "drinks were";
      } else if (name.equals("appetizers")) {
        verb = "appetizers were";
      } else if (name.equals("main course")) {
        verb = "main course was";
      } else if (name.equals("dessert")) {
        verb = "dessert was";
      }
      System.out.println("No " + verb + " served with the meal.");
    } else if (course.size() == 1) { // check for one item
      String item = course.get(0);
      item = item.substring(0, 1).toUpperCase() + item.substring(1);
      System.out.println(item + " was served with the meal.");
    } else if (course.size() == 2) { // check for two items
      
    }
  }
```

Create the string variables `item1` and `item2`. Set them to the two elements in `course`. Capitalize `item1` just as before. Print out a sentence that incorporates `item1` and `item2`.

```java
    } else if (course.size() == 2) { // check for two items
      String item1 = course.get(0);
      String item2 = course.get(1);
      item1 = item1.substring(0, 1).toUpperCase() + item1.substring(1);
      System.out.println(item1 + " and " + item2 + " were served with the meal.");
    }
```

**Note**, remove the comment symbol `//` for `dinner.addDrink("water");` and `dinner.addDrink("coffee");`.

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 7)

## More than Two Items Were Served

If more than two items are served, then you need a comma-separated list. The first item should be capitalized followed by a comma and a space. The next items are followed by commas and spaces. The final item in the list is prefaced with `and`. No comma is used after the last item. The sentence ends with `" were served with the meal."`. Remember, the final print statement needs to add a new line character. Be sure that it does not have `end=""` in it.

```java
  void printCourse(ArrayList<String> course, String name) {
    if (course.size() == 0) {
      String verb = "";
      if (name.equals("drinks")) {
        verb = "drinks were";
      } else if (name.equals("appetizers")) {
        verb = "appetizers were";
      } else if (name.equals("main course")) {
        verb = "main course was";
      } else if (name.equals("dessert")) {
        verb = "dessert was";
      }
      System.out.println("No " + verb + " served with the meal.");
    } else if (course.size() == 1) { // check for one item
      String item = course.get(0);
      item = item.substring(0, 1).toUpperCase() + item.substring(1);
      System.out.println(item + " was served with the meal.");
    } else if (course.size() == 2) { // check for two items
      String item1 = course.get(0);
      String item2 = course.get(1);
      item1 = item1.substring(0, 1).toUpperCase() + item1.substring(1);
      System.out.println(item1 + " and " + item2 + " were served with the meal.");
    } else { // more than two items
      
    }
  }
```

```java
    } else { // more than two items
      String item1 = course.get(0);
      item1 = item1.substring(0, 1).toUpperCase() + item1.substring(1);
      System.out.print(item1 + ", ");
    }
```

```java
    } else { // more than two items
      String item1 = course.get(0);
      item1 = item1.substring(0, 1).toUpperCase() + item1.substring(1);
      System.out.print(item1 + ", ");
      for (int i = 1; i < course.size(); i++) {
        if (i == course.size() - 1) {
          System.out.print("and " + course.get(i) + " ");
        } else {
          System.out.print(course.get(i) + ", ");
        }
      }
      System.out.println("were served with the meal.");
    }
```

**Note**, remove the comment symbol `//` for remaining lines of code.

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 8)

|||challenge
## Check your work:
Create different meals and make sure your program works as expected. For example:

```java
Meal dinner = new Meal();
dinner.addDrink("white wine");
dinner.addappetizer("tapenade");
dinner.addAppetizer("antipasto");
dinner.addCourse("cauliflower bolognese");
dinner.addCourse("butternut squash soup");
dinner.addCourse("kale salad");
dinner.printMeal();
```
<details>
  <summary><strong>Code</strong></summary>
  
  ```java
  import java.util.ArrayList;

  //add class definitions below this line

  class Meal {
    ArrayList<String> drinks = new ArrayList<String>();
    ArrayList<String> appetizers = new ArrayList<String>();
    ArrayList<String> mainCourse = new ArrayList<String>();
    ArrayList<String> dessert = new ArrayList<String>();

    void addDrink(String d) {
      drinks.add(d);
    }

    void addAppetizer(String a) {
      appetizers.add(a);
    }

    void addCourse(String c) {
      mainCourse.add(c);
    }

    void addDessert(String d) {
      dessert.add(d);
    }

    void printMeal() {
      printCourse(drinks, "drinks");
      printCourse(appetizers, "appetizers");
      printCourse(mainCourse, "main course");
      printCourse(dessert, "dessert");
    }

    void printCourse(ArrayList<String> course, String name) {
      if (course.size() == 0) {
        String verb = "";
        if (name.equals("drinks")) {
          verb = "drinks were";
        } else if (name.equals("appetizers")) {
          verb = "appetizers were";
        } else if (name.equals("main course")) {
          verb = "main course was";
        } else if (name.equals("dessert")) {
          verb = "dessert was";
        }
        System.out.println("No " + verb + " served with the meal.");
      } else if (course.size() == 1) { // check for one item
        String item = course.get(0);
        item = item.substring(0, 1).toUpperCase() + item.substring(1);
        System.out.println(item + " was served with the meal.");
      } else if (course.size() == 2) { // check for two items
        String item1 = course.get(0);
        String item2 = course.get(1);
        item1 = item1.substring(0, 1).toUpperCase() + item1.substring(1);
        System.out.println(item1 + " and " + item2 + " were served with the meal.");
      } else { // more than two items
        String item1 = course.get(0);
        item1 = item1.substring(0, 1).toUpperCase() + item1.substring(1);
        System.out.print(item1 + ", ");
        for (int i = 1; i < course.size(); i++) {
          if (i == course.size() - 1) {
            System.out.print("and " + course.get(i) + " ");
          } else {
            System.out.print(course.get(i) + ", ");
          }
        }
        System.out.println("were served with the meal.");
      }
    }
  }

  //add class definitions above this line

  public class MoreMethods {  
    public static void main(String[] args) {

      //add code below this line

      Meal dinner = new Meal();
      dinner.addDrink("water");
      dinner.addDrink("coffee");
      dinner.addCourse("roast chicken");
      dinner.addCourse("mashed potatoes");
      dinner.addCourse("salad");
      dinner.addDessert("chocolate cake");
      dinner.printMeal();

      //add code above this line
    }
  }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 9)

