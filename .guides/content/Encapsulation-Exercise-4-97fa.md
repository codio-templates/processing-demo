----------

## Exercise 4

Create the `Atm` class. This class has the attribute `money` that gets its value as an argument from the constructor. 

* `money` - double that represents the amount of money in the account

This attribute should have a getter method, but not a setter. The class should have two method, `deposit` and `withdrawal`. The `deposit` method should contain data validation to check if the amount of money deposited is positive. Print a message if the data validation fails. The `withdrawal` method should check the data to see if there is enough money to withdraw **and** that the amount is positive. Print a message to the user if data validation fails.

### Expected Output
Verify that your program works for each of the following scenarios.
* **Scenario 1** - Deposit and withdraw valid amounts of money

```java
    //add code below this line

    Atm myAtm = new Atm(1000);
    myAtm.deposit(50);
    System.out.println(myAtm.getMoney());
    myAtm.withdraw(925);
    System.out.println(myAtm.getMoney());    

    //add code above this line
```

This code should produce the following output:

```java
1050.0
125.0
```

* **Scenario 2** - Deposit amount is not positive

```java
    //add code below this line

    Atm myAtm = new Atm(1000);
    myAtm.deposit(-50);
    System.out.println(myAtm.getMoney());    

    //add code above this line
```

This code should produce the following output:

```java
You cannot deposit a negative amount of money.
1000.0
```

* **Scenario 3** - Withdrawal amount is too large

```java
    //add code below this line

    Atm myAtm = new Atm(1000);
    myAtm.withdraw(5000);
    System.out.println(myAtm.getMoney());    

    //add code above this line
```

This code should produce the following output:

```java
You do not have enough funds to withdraw that amount.
1000.0
```

* **Scenario 4** - Withdrawal amount is not positive

```java
    //add code below this line

    Atm myAtm = new Atm(1000);
    myAtm.withdraw(-50);
    System.out.println(myAtm.getMoney());    

    //add code above this line
```

This code should produce the following output:

```java
You cannot withdraw a negative amount of money.
1000.0
```

### Important
In order withdraw money, the amount leftover must be greater than 0.

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise4.java java -cp code/encapsulation/exercises/ CodingExercise4 1)

{Check It!|assessment}(test-2521092329)
