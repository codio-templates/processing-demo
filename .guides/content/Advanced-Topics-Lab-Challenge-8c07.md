----------

### Problem
The `BankAccount` class is defined in the IDE to the left. Create the `toString` method that returns a string representation of a `BankAccount` object.

### Expected Output
Create two different `BankAccount` objects.

```java
    //add code below this line

    BankAccount account1 = new BankAccount(2432, 89.52);
    BankAccount account2 = new BankAccount(1998, 239.43);

    //add code above this line
```

If you print each object, you should see the following output.

|Method Call                    |Output                                      |
|-------------------------------|--------------------------------------------|
|`System.out.println(account1);`|BankAccount[checking=2432.0, savings=89.52] |
|`System.out.println(account2);`|BankAccount[checking=1998.0, savings=239.43]|

{Try it}(sh .guides/bg.sh javac code/advanced/labChallenge/LabChallenge.java java -cp code/advanced/labChallenge/ LabChallenge 1)

{Check It!|assessment}(test-2414713005)
