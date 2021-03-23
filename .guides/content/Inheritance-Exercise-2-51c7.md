----------

## Exercise 2

Use the superclass `Book` to help you solve this problem. Create the subclass `BlogPost` so that it has the following attributes:
* `title` - a string that represents the title of the blog post
* `author` - a string that represents the author of the blog post
* `genre` - a string that represents the genre of the blog post
* `website` - a string that represents the website hosting the blog post
* `wordCount` - an integer that represents the number of words in the blog post
* `pageViews` - an integer that represents the page views for the blog post

## Expected Output

The table below shows the expected output for the indicated instantiation. Use the `TRY IT` button below and verify that your `BlogPost` object works as expected.

First, instantiate a `BlogPost` object:
```java
    //add code below this line
  
    BlogPost myPost = new BlogPost("Hot Summer Trends", "Amy Gutierrez", "fashion", "Vogue", 2319, 2748);
  
    //add code above this line
```

|Print Statement|Output|
|:--------------|:-----|
|`System.out.println(myPost.getTitle());`|`Hot Summer Trends`|
|`System.out.println(myPost.getAuthor());`|`Amy Gutierrez`|
|`System.out.println(myPost.getGenre());`|`fashion`|
|`System.out.println(myPost.getWebsite());`|`Vogue`|
|`System.out.println(myPost.getWordCount());`|`2139`|
|`System.out.println(myPost.getPageViews());`|`2748`|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise2/Exercise2.java java -cp code/inheritance/exercise2/ Exercise2 1)

{Check It!|assessment}(test-3351852341)
