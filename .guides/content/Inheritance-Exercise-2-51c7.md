----------

## Exercise 2

Use the superclass `Book` to help you solve this problem. Create the subclass `BlogPost` so that it has the following attributes:
* `website` - a string that represents the website hosting the blog post
* `title` - a string that represents the title of the blog post
* `author` - a string that represents the author of the blog post
* `wordCount` - an integer that represents the number of words in the blog post
* `genre` - a string that represents the genre of the blog post
* `pageViews` - an integer that represents the page views for the blog post

## Expected Output

The table below shows the expected output for the indicated instantiation. Use the `TRY IT` button below and verify that your `BlogPost` object works as expected.

First, instantiate a `BlogPost` object:
```java
BlogPost myPost = new BlogPost("Vogue", "Hot Summer Trends", "Amy Gutierrez", 2319, "fashion", 2748);
```

|Print Statement|Output|
|:--------------|:-----|
|System.out.println(myPost.website)|`Vogue`|
|System.out.println(myPost.title)|`Hot Summer Trends`|
|System.out.println(myPost.author)|`Amy Gutierrez`|
|System.out.println(myPost.word_count)|`2139`|
|System.out.println(myPost.genre)|`fashion`|
|System.out.println(myPost.page_views)|`2748`|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise2/Exercise2.java java -cp code/inheritance/exercise2/ Exercise2 1)