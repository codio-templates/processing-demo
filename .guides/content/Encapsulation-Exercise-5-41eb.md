----------

## Exercise 5

Create the class `SodaMachine` which sells soda. Assume that this machine only takes bills and that each can of soda costs $2. The class has the following attributes:

* `sodas` - array of strings that represents the types of soda sold. It should be initialized as `{"coke", "pepsi", "sprite", "dr. pepper"}`.
* `cokeInventory` - integer representing how many cans of Coke are in the machine. Start with 20.
* `pepsiInventory` - integer representing how many cans of Pepsi are in the machine. Start with 20.
* `spriteInventory` - integer representing how many cans of Sprite are in the machine. Start with 20.
* `drPepperInventory` - integer representing how many cans of Dr. Pepper are in the machine. Start with 20.
* `money` - integer representing how much money is in the machine. Start with $10.

Each attribute should have a getter and a setter. In addition, `buySoda` is a public method. This method takes a string that represents the type of soda to purchase and the amount of money inserted in the machine. The `buySoda` method should add the value of the soda ($2) to the `money` attribute and update the inventory the particular soda. It also needs to provide the following data validation:

* Validate that the soda is sold by the machine; provide a message to the user.
* Validate that the user inserted enough money; provide a message to the user.
* Validate that there is enough cans of soda to be sold; provide a message to the user.

### Expected Output
Verify that your program works for each of the following scenarios.
* **Scenario 1** - Select a valid soda and a valid amount of money

```java
    //add code below this line

    SodaMachine myMachine = new SodaMachine();
    myMachine.buySoda("coke", 4);
    System.out.println(myMachine.getMoney());
    System.out.println(myMachine.getCokeInventory());

    //add code above this line
```

This code should produce the following output. The `money` attribute is increased by the price of the soda, and `cokeInventory` has decreased by 1.

```java
12
19
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise5.java java -cp code/encapsulation/exercises/ CodingExercise5 1)

* **Scenario 2** - Select an invalid soda and a valid amount of money

```java
    //add code below this line

    SodaMachine myMachine = new SodaMachine();
    myMachine.buySoda("diet coke", 4);
    System.out.println(myMachine.getMoney());
    System.out.println(myMachine.getCokeInventory());
    System.out.println(myMachine.getSpriteInventory());
    System.out.println(myMachine.getPepsiInventory());
    System.out.println(myMachine.getDrPepperInventory());

    //add code above this line
```

This code should produce the following output. There should be a message about the soda not being sold. The `money` attribute should not change, and none of the inventory attributes should change either.

```markdown
That soda is not sold in this machine.
10
20
20
20
20
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise5.java java -cp code/encapsulation/exercises/ CodingExercise5 2)

* **Scenario 3** - Select a valid soda and not enough money

```java
    //add code below this line

    SodaMachine myMachine = new SodaMachine();
    myMachine.buySoda("sprite", 1);
    System.out.println(myMachine.getMoney());
    System.out.println(myMachine.getSpriteInventory());

    //add code above this line
```

This code should produce the following output. There should be a message about not inserting enough money. Because this is not a valid transaction, the `money` and `spriteInventory` attributes should not change.

```markdown
You did not insert enough money.
10
20
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise5.java java -cp code/encapsulation/exercises/ CodingExercise5 3)

* **Scenario 4** - The machine ran out of a particular soda

```java
    //add code below this line

    SodaMachine myMachine = new SodaMachine();
    myMachine.setDrPepperInventory(0);
    myMachine.buySoda("dr. pepper", 2);
    System.out.println(myMachine.getMoney());
    System.out.println(myMachine.getDrPepperInventory());

    //add code above this line
```

This code should produce the following output. There should be a message about not having any cans for a particular soda. The `money` attribute should not change, and the `drPepperInventory` attribute should remain at `0`.

```markdown
There are no cans of Dr. Pepper.
10
0
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise5.java java -cp code/encapsulation/exercises/ CodingExercise5 4)

### Important
The constructor does not have any parameters. Use the Java convention for naming getters and setters. The setter method for `sodas` needs an index and the name of the new soda.

{Check It!|assessment}(test-336914172)
