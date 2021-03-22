----------

## Exercise 4

Use the superclass `Bank` to help you solve this problem. Create the subclass `RegionalBank` so that it has the following attributes:

* `name` - string that represents the name of the bank
* `customers` - integer that represents the number of customers at the bank
* `regionalAccounts` - 2D array of doubles that represent the amount of money in the region

The `RegionalBank` class also has the method `regionalTotal` that calculates the .

## Expected Output

Instantiate an instance of the `RegionalBank` class with the information below. Your program should print `170000.0`.

```java
    //add code below this line
    double[][] accounts = {{10000, 13000, 22000},
                           {30000, 7000, 19000},
                           {15000, 23000, 31000}};
    RegionalBank rb = new RegionalBank("Main Street Bank", 9, accounts);
    System.out.println(rb.regionalTotal());
  
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise4/Exercise4.java java -cp code/inheritance/exercise4/ Exercise4 1)