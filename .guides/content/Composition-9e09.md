----------

## Composition

Composition is a way to make a functional whole out of smaller parts. If you were to create a `Car` class, this would start out as a simple exercise. Every car has a make, a model, and a year it was produced. Representing this data is simple: two strings and an integer. 

```java
//add class definitions below this line

class Car {
  private String make;
  private String model;
  private int year;
  
  public Car(String ma, String mo, int y) {
    make = ma;
    model = mo;
    year = y;
  }
  
  public void describe() {
    System.out.println(String.format("%s %s %s", make, model, year));
  }
}
 
//add class definitions above this line
```

Create an instance of the `Car` class and call the `describe` method.

```java
  //add code below this line

  Car car = new Car("De Tomaso", "Pantera", 1979);
  car.describe();

  //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/Composition.java java -cp code/advanced/ Composition 1)

The `Car` class, however, is missing an important component: the engine. What data type would you use to represent an engine? Creating another class is the best way to do this. Modify the `Car` class so that it has an `engine` attribute and a getter for this attribute. Then create the `Engine` class with attributes for configuration (V8, V6, etc.), displacement, horsepower, and torque. Finally, add the `ignite` method to the `Engine` class. 

```java
//add class definitions below this line

class Car {
  private String make;
  private String model;
  private int year;
  private Engine engine;
  
  public Car(String ma, String mo, int y, Engine e) {
    make = ma;
    model = mo;
    year = y;
    engine = e;
  }
  
  public void describe() {
    System.out.println(String.format("%s %s %s", make, model, year));
  }
  
  public Engine getEngine() {
    return engine;
  }
}

class Engine {
  private String configuration;
  private double displacement;
  private int horsepower;
  private int torque;
  
  public Engine(String c, double d, int h, int t) {
    configuration = c;
    displacement = d;
    horsepower = h;
    torque = t;
  }
  
  public void ignite() {
    System.out.println("Vroom vroom!");
  }
}
 
//add class definitions above this line
```

Since the `Car` class takes an `Engine` object, instantiate an `Engine` object first. Then pass that object to the constructor for the `Car` class. To call the `ignite` method, you need to call the getter method for the `engine` attribute and then call the method.

```java
  //add code below this line

  Engine engine = new Engine("V8", 5.8, 326, 344);
  Car car = new Car("De Tomaso", "Pantera", 1979, engine);
  car.getEngine().ignite();

  //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/Composition.java java -cp code/advanced/ Composition 2)

The combination of the `Car` class and the `Engine` class lead to a better representation of an actual car. This is the benefit of object composition. Because the `Engine` class is a part of the `Car` class, we can say that the `Engine` class is the component class and the `Car` class is the composite class.

![.guides/img/advanced/composite_component](.guides/img/advanced/composite_component.png)

|||challenge
## Try these variations:
* In the `Car` class, add the `start` method then have the last line of the script call `start` instead of `ignite`:

```java
  // Car class
  public void start() {
    engine.ignite();
  }

  // main method
  Engine engine = new Engine("V8", 5.8, 326, 344);
  Car car = new Car("De Tomaso", "Pantera", 1979, engine);
  car.start();
```

* In the `Engine` class, create the `info` method then call `info` instead of `describe`:

```java
  // Engine class
  public void info() {
    describe();
  }

  // main method
  Engine engine = new Engine("V8", 5.8, 326, 344);
  Car car = new Car("De Tomaso", "Pantera", 1979, engine);
  car.getEngine().info();
```

<details>
  <summary><strong>Why is there an error?</strong></summary>
  Composition is a one-way street. The composite class (the <code>Car</code> class) has access to all of the attributes and methods of the component classes (the <code>Engine</code> class). However, component classes cannot access the attributes and methods of the composite class.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/advanced/Composition.java java -cp code/advanced/ Composition 3)

## Composition versus Inheritance

Assume you have the class `MyClass`. You want to use this class in your program, but it is missing some functionality. Do you use inheritance and extend the parent class, or do you use composition and create a component class? Both of these techniques can accomplish the same thing. This is a complex topic, but you can use a simple test to help you decide. Use inheritance if there is an "is a" relationship, and use composition if there is a "has a" relationship.

For example, you have the `Vehicle` class and you want to make a `Car` class. Ask yourself if a car has a vehicle or if a car is a vehicle. A car is a vehicle; therefore you should use inheritance. Now imagine that you have a `Phone` class and you want to represent an app for the phone. Ask yourself if a phone is an app or if a phone has an app. A phone has an app; therefore you should use composition.

{Check It!|assessment}(fill-in-the-blanks-2967844050)
