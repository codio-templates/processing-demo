----------
## What is a Black Box?
The term "black box" is used to describe a system in which the internal workings are hidden from the user. In fact, the user is not expected to know how the system works; they only need to know how to use it. Encapsulation allows you to create classes that are black boxes. For example the `Words` class from the previous page is an example of this. By the time you finished the page, you transformed the code on the left to the code on the right.

![.guides/img/encapsulation/small-black-box](.guides/img/encapsulation/small-black-box.png)

From the user's point of view, there is no difference in how they interact with the class. In both cases they call the `countVowels` method. The user does not need to know about any of the changes because they cannot access private methods. The `Words` class is a black box. You should strive to use encapsulation to create classes that are black boxes.

## Creating a Black Box

We are going to create the black box class `Numbers`. This class requires a tab-delimited CSV file with numbers in it. These numbers are integers between 1 and 100 (including both 1 and 100). The only public method is `summary` which will print a summary of the numbers in the CSV file. Start by creating the class and the constructor.

```java
//add class definitions below this line
    
class Numbers {
  private String file;
  private int[] data;
  
  public Numbers(String f) {
    file = f;
    data = getData();
  }
}
  
//add class definitions above this line
```

Notice how the `data` attribute calls the `getData` method. This is because the file needs to be automatically read and converted into an array of integers when a `Numbers` object is instantiated. The `getData` method should be private because it is a helper method. Most of this method comes from the previous lesson on reading files. Remember, the `readLine` method returns a single string of all the numbers read from the CSV file. The `split` method turns that single string into an array of strings. However, we need an array of integers, so the `convertToInts` method is called to make this transformation.

```java
  private int[] getData() {
    int[] intTokens = new int[0];
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = reader.readLine();
      String[] stringTokens = line.split("\t");
      intTokens = convertToInts(stringTokens);
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    } finally {
      System.out.println("Finished reading a file.");
      return intTokens;
    }
  }
```

The `convertToInts` method creates an array of ints that is the same length as the array of strings. It then iterates over the array of strings, taking each element and converting it to an integer. This integer is then stored in the `ints` array. 

```java
  private int[] convertToInts(String[] strings) {
    int size = strings.length;
    int[] ints = new int[size];
    for (int i = 0; i < size; i++) {
      ints[i] = Integer.parseInt(strings[i]);
    }
    return ints;
  }
```

<details>
  <summary><strong>What are all of these methods doing?</strong></summary>
  To create the value for the <code>data</code> attribute, the constructor calls the <code>getData</code> method. This method takes an array of strings and passes it to the <code>convertToInts</code> method. This method converts the array of strings into an array of integers. The integer array is returned to the <code>getData</code> method, which returns the same integer array to the <code>data</code> attribute.
</details><br>

We are now ready to make the public method `summary`. This method is going to provide a summary of information about the numbers in the CSV file. Start by calculating how many numbers there are.

```java
  public void summary() {
    printCount();
  }

  private void printCount() {
    System.out.println("There are " + data.length + " numbers.");
  }
```

Instantiate a `Numbers` object and pass it a file path to a CSV file. Calling the `summary` method should prin that there are 37 numbers in the file.

```java
    //add code below this line

    String path = "studentFolder/numbers.csv";
    Numbers myNumbers = new Numbers(path);
    myNumbers.summary();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/BlackBox.java java -cp code/encapsulation/ BlackBox 1)

<details>
  <summary><strong>Code</strong></summary>
  
  ```java
  import java.io.*;

  //add class definitions below this line

  class Numbers {
    private String file;
    private int[] data;

    public Numbers(String f) {
      file = f;
      data = getData();
    }

    private int[] getData() {
      int[] intTokens = new int[0];
      try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        String[] stringTokens = line.split("\t");
        intTokens = convertToInts(stringTokens);
        reader.close();
      } catch (IOException e) {
        System.out.println(e);
      } finally {
        System.out.println("Finished reading a file.");
        return intTokens;
      }
    }

    private int[] convertToInts(String[] strings) {
      int size = strings.length;
      int[] ints = new int[size];
      for (int i = 0; i < size; i++) {
        ints[i] = Integer.parseInt(strings[i]);
      }
      return ints;
    }

    public void summary() {
      printCount();
    }

    private void printCount() {
      System.out.println("There are " + data.length + " numbers.");
    }
  }

  //add class definitions above this line

  public class BlackBox {
    public static void main(String[] args) {

      //add code below this line

      String path = "studentFolder/numbers.csv";
      Numbers myNumbers = new Numbers(path);
      myNumbers.summary();

      //add code above this line
    }
  }
  ```
  
</details>
  
|||challenge
## Try these variations:
* Create the `printNumbers` method that prints all of the numbers in the file.
  
<details>
  <summary><strong>Possible Solution</strong></summary>
  Here is one possible solution for the <code>printNumbers</code> method:
  
  ```java
    public void summary() {
      printCount();
      printNumbers();
    }
  
    private void printNumbers() {
      System.out.print("The numbers are: ");
      for (int num : data) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  ```
  
</details><br>

* Create the `printSmallest` method that prints the smallest number in the file.
  
<details>
  <summary><strong>Possible Solution</strong></summary>
  Here is one possible solution for the <code>printSmallest</code> method:
  
  ```java
    public void summary() {
      printCount();
      printNumbers();
      printSmallest();
    }
  
    private void printSmallest() {
      int smallest = 100;
      for (int num : data) {
        if (num < smallest) {
          smallest = num;
        }
      }
      System.out.println("The smallest number is " + smallest + ".");
    }
  ```
  
</details><br>

* Create the `printLargest` method that prints the largest number in the file.
  
<details>
  <summary><strong>Possible Solution</strong></summary>
  Here is one possible solution for the <code>printLargest</code> method:
  
  ```java
    public void summary() {
      printCount();
      printNumbers();
      printSmallest();
      printLargest();
    }
  
    private void printLargest() {
      int largest = 1;
      for (int num : data) {
        if (num > largest) {
          largest = num;
        }
      }
      System.out.println("The largest number is " + largest + ".");
    }
  ```
  
</details>
  
|||
  
{Try it}(sh .guides/bg.sh javac code/encapsulation/BlackBox.java java -cp code/encapsulation/ BlackBox 2)
  
{Check It!|assessment}(multiple-choice-44663644)
