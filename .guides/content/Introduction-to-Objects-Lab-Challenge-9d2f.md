----------

## Lab Challenge

Create the variable `dog1`, and instantiate an object of the `Dog` class. This dog's name is `Marceline` and she is a `German Shepherd`. Create the variable `dog2` and make a **deep copy** of `dog1`. `dog2` should be named `Cajun` and have the breed `Belgian Malinois`. 

### Expected Output

Test your code by printing the `name` and `breed` of each dog to make sure they fulfill the requirements above. Most importantly, the third print statement will print `false`.

```java
    //add code below this line

    Dog dog1 = new Dog("Marceline", "German Shepherd");
    Dog dog2 = new Dog(dog1);
    dog2.name = "Cajun";
    dog2.breed = "Belgian Malinois";
    
    System.out.println(dog1.name + " " + dog1.breed);
    System.out.println(dog2.name + " " + dog2.breed);
    System.out.println(dog2 == dog1);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/LabChallenge.java java -cp code/introObjects/ LabChallenge 1)

{Check It!|assessment}(test-3706534948)
