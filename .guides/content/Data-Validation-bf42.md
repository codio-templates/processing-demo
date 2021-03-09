----------
Java already has a type system which will flag errors when a boolean value is passed to a method that takes an integer. However, just because a method takes an integer does not mean that all integers are valid for that method. Data validation is the process of asking if this data is appropriate for its intended use. Take a look at the `Person` class.

```java
//add class definitions below this line
    
class Person {
  private String name;
  private int age;
  
  public Person(String n, int a) {
    name = n;
    age = a;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int newAge) {
    age = newAge;
  }
}
  
//add class definitions above this line
```

The `setAge` method will assign any value to the attribute `age` as long as the value is an integer. There are some integers which makes no sense when thought of as an age. The code sample below sets the age of `myPerson` to `-100`. `-100` is a valid integer, but it is not a valid age. This is why data validation is important. Java's compiler is not sufficient to catch all errors.

```java
    //add code below this line

    Person myPerson = new Person("Calvin", 6);
    System.out.println(myPerson.getName() + " is " + myPerson.getAge() + " years old.");
    myPerson.setAge(-100);
    System.out.println(myPerson.getName() + " is " + myPerson.getAge() + " years old.");

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/DataValidation.java java -cp code/encapsulation/ DataValidation 1)

Another benefit to using setters is that data validation can take place before the new value is assigned to the attribute. Modify `setAge` so that it will only update the `age` attribute if the new value is greater than or equal to 0. This way you can ensure that the `Person` object always has a valid age.

```java
  public void setAge(int newAge) {
    if (newAge >= 0) {
      age = newAge;
    }
  }
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/DataValidation.java java -cp code/encapsulation/ DataValidation 2)

|||challenge
## Try these variations:
* Change the data validation for `setAge` method so that values over 200 are not valid.

<details>
  <summary><strong>Possible Solution</strong></summary>
  Here is one possible solution.
  
  ```java
    public void setAge(int newAge) {
      if (newAge >= 0 && newAge <= 200) {
        age = newAge;
      }
    }
  ```
  
</details><br>

* Add data validation to the `setName` method so that all strings with one or more characters are valid.
  
  <details>
  <summary><strong>Possible Solution</strong></summary>
  Here is one possible solution.
  
  ```java
    public void setName(String newName) {
      if (newName != "") {
        name = newName;
      }
    }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/encapsulation/DataValidation.java java -cp code/encapsulation/ DataValidation 3)
  
{Check It!|assessment}(multiple-choice-3712924918)
