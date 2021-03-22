----------

## Exercise 4

The code to the left creates a class called `Bank`. This class has a branch name, the number of customers, and a list of the amount of money in each customer's bank account. The method `branchTotal` takes the list of customer money and returns the total amount of money held by the bank.

Create the class `RegionalBank` as a subclass of the `Bank` class. This class has a name, the number of customers in the region, and a 2D list of all of the money in the bank accounts for each branch. Extend the `RegionalBank` class by adding the method `regionalTotal` which returns the total amount of money kept in all of the banks in the region.

Instantiate an object from the `RegionalBank` class and use the variable `accounts` as the 2D list of bank account. Print out the result from `regionalTotal`.

## Expected Output

The `TRY IT` button will run your code with the following value for the `accounts` variable. Your program should print `170000`.

```java
accounts = [
              [10000, 13000, 22000],
              [30000, 7000, 19000],
              [15000, 23000, 31000]
           ]
```

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise4/Exercise4.java java -cp code/inheritance/exercise4/ Exercise4 1)