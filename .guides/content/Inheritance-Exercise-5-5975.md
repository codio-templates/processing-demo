----------

## Exercise 5

Use the `Person` class to the left to help you solve this problem. First, create the `CardHolder` that inherits from the `Person` class. It should have the following attributes and methods:

* `accountNumber` - integer representing the credit card account.
* `balance` - double representing how much money the holder owes.
* `creditLimit` - integer representing how the holder can spend.
* Constructor - the constructor takes arguments for `name`, `address`, and `accountNumber`. The `balance` should be set to `0` and `creditLimit` should be set to `5000`.
* `processSale` - method that takes the sale amount (double) and adds it to `balance`.
* `makePayment` - method that takes an amount (double) and deducts it from `balance`.

You also need to create the `PlatinumClient` class that inherits from `CardHolder`. It should have the following attributes and methods:

* `cashBack` - double representing the percentage of each sale the holder gets back as a reward.
* `rewards` - double representing how much money the holder has earned as cash back.
* Constructor - the constructor takes arguments for `name`, `address`, and `accountNumber`. It should set `cashBack` to `0.02` and set `rewards` to `0`.
* `processSale` - override the method so that 2% of each sale is added to `rewards`.

## Expected Output

Declare an instance of the `PlatinumClient` class as shown below.

```python
PlatinumClient p = new PlatinumClient("Sarah", "101 Main Street", 123364);
```

Your class should be able to execute the code below in the stated order and produce the given return values.

|Order|Code|Return Value|
|:----|:---|:-----------|
|1|`p.processSale(100);`|N/A|
|2|`System.out.println(p.getRewards());`|`2.0`|
|3|`System.out.println(p.getBalance());`|`100.0`|
|4|`p.makePayment(50);`|N/A|
|5|`System.out.println(p.getBalance());`|`50.0`|
|6|`System.out.println(p.info());`|`Sarah lives at 101 Main Street.`|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise5/Exercise5.java java -cp code/inheritance/exercise5/ Exercise5 1)