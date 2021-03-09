----------

As discussed on the previous page, we will be making all attributes private. Instance attributes, static attributes, constants — it does not matter, they will all be private.

## Private Methods

Methods too, can be private. And just like private attributes, private methods are accessed by public methods. Here is an example class with a private method.

```java
//add class definitions below this line
    
class PrivateExample {
  private int num;
  
  public PrivateExample(int n) {
    num = n;
  }
  
  public void publicMethod() {
    hiddenMethod();
  }
  
  private void privateMethod() {
    System.out.println("The double of " + num + " is: " + num * 2);
    System.out.println(num + " squared is: " + num * num);
  }
}
  
//add class definitions above this line
```

Instantiate an object and try to call `privateMethod`.

```java
    //add code below this line

    PrivateExample myExample = new PrivateExample(5);
    myExample.privateMethod();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PrivateKeyword.java java -cp code/encapsulation/ PrivateKeyword 1)

Java throws an error message because an instance cannot directly access a private method. Change the method call to `publicMethod` and run the code again. This time it should work because public methods can access private methods and/or attributes.

```java
    //add code below this line

    PrivateExample myExample = new PrivateExample(5);
    myExample.publicMethod();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PrivateKeyword.java java -cp code/encapsulation/ PrivateKeyword 2)

## Public and Private Methods

A well written Java program will make use of both public and private methods. Deciding what to make public and what to make private comes down to how you want the user to interact with your code. Only make public those methods you want the user to call. Keep everything else private. The example below is a class that counts the number of vowels in a list of strings. 

```java
//add class definitions below this line
    
class Words {
  private String[] words;
  private int[] count;
  
  public Words(String[] listOfWords) {
    words = listOfWords;
    count = new int[words.length];
  }
  
  public void countVowels() {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        for (int k = 0; k < vowels.length; k++) {
          if (word.charAt(j) == vowels[k]) {
            count[i]++;
          }
        }
      }
    }
  }
  
  public void printVowelCount() {
    for (int num : count) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
  
//add class definitions above this line
```

Instantiate a `Words` object with a list of strings. Then call the `countVowels` and `printVowelCount` methods. Your results should be `3 1 3 2`.

```java
    //add code below this line

    String[] wordList = {"house", "cat", "computer", "Java"};
    Words w = new Words(wordList);
    w.countVowels();
    w.printVowelCount();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PrivateKeyword.java java -cp code/encapsulation/ PrivateKeyword 3)

Both methods are public because the user is expected to use both of them. However, the `countVowels` method is hard to follow. For the sake of readability, we can create the helper method `isVowel`. The user is not expected to use this method, so make it private. The results should be the same.

```java
  public void countVowels() {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        if (isVowel(word.charAt(j))) {
          count[i]++;
        }
      }
    }
  }
  
  private boolean isVowel(char letter) {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    for (int i = 0; i < vowels.length; i++) {
      if (letter == vowels[i]) {
        return true;
      }
    }
    return false;
  }
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PrivateKeyword.java java -cp code/encapsulation/ PrivateKeyword 4)

|||challenge
## Try these variations:
* Create the helper method `checkWord` that iterates through a string and determines if each character is a vowel or not. Your `countVowels` method should now look like this.

```java
  public void countVowels() {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      checkWord(i, word);
    }
  }
```

<details>
  <summary><strong>Possible Solution</strong></summary>
  Here is one way to create the <code>checkWord</code> method. Remember to make this method private as it not to be called by the user.
  
  ```java
    private void checkWord(int index, String word) {
      for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);                                
        if (isVowel(letter)) {
          count[index]++;
        }
      }
    }
  ```
</details>

|||

{Try it}(sh .guides/bg.sh javac code/encapsulation/PrivateKeyword.java java -cp code/encapsulation/ PrivateKeyword 5)
  
{Check It!|assessment}(multiple-choice-2739099056)
