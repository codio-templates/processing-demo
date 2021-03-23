----------

## Exercise 3

Create the class `Child` such that the following criteria are met:
* `Child` is a subclass of `Parent1` and `Parent2`
* Override `identify` so that it returns "This method is called from Child"
* Create the method `identify2` that invokes the `identify` method from `Parent2`.
* Create the method `identify3` that invokes the `identify` method from `Parent1`.

**Important**, Changes will need to be made to the `Parent1` and/or `Parent2` classes.

## Expected Output

The table below shows the expected output for the indicated instantiation. Use the `TRY IT` button below and verify that your `Child` object works as expected.

First, instantiate a `Child` object:

```java
    //add code below this line
  
    Child childObject = new Child();
  
    //add code above this line
```

|Print Statement|Output|
|:--------------|:-----|
|`System.out.println(childObject.identify());`|`his method is called from Child`|
|`System.out.println(childObject.identify2());`|`This method is called from Parent2`|
|`System.out.println(childObject.identify3());`|`This method is called from Parent1`|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise3/Exercise3.java java -cp code/inheritance/exercise3/ Exercise3 1)

{Check It!|assessment}(test-665191771)
