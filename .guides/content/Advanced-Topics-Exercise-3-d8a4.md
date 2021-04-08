----------

## Exercise 3

Create the `Dog` class with the string attributes for `name` and `breed`. These attributes need to have getter methods. Then create the method `makeDogs` that returns an ArrayList of five `Dog` objects according to the following table:

|Dog|Name     |Breed           |
|---|---------|----------------|
|1  |Marceline|German Shepherd |
|2  |Cajun    |Belgian Malinois|
|3  |Daisy    |Border Collie   |
|4  |Rocky    |Golden Retriever|
|5  |Bella    |Irish Setter    |

## Expected Output

Verify that the name and breed of the dogs in the list match the order of the table. If you create a `toString` method for the `Dog` class, you can see the contents of the ArrayList.

```java
    //add code below this line

    ArrayList<Dog> dogs = makeDogs();
    System.out.println(dogs);

    //add code above this line
```

The above code should produce the following output:

```markdown
[Dog[name=Marceline, breed=German Shepherd], Dog[name=Cajun, breed=Belgian Malinois], Dog[name=Daisy, breed=Border Collie], Dog[name=Rocky, breed=Golden Retriever], Dog[name=Bella, breed=Irish Setter]]
```

{Try it}(sh .guides/bg.sh javac code/advanced/exercise3/Exercise3.java java -cp code/advanced/exercise3/ Exercise3 1)

{Check It!|assessment}(test-3997253090)
