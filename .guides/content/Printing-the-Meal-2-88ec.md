----------

## One Item Was Served

This is a simple case. If only one item is served, that item should be capitalized followed by `" was served with the meal."`. Use the `substring` string method to capitalize the first letter.

```python
def print_meal(self):
    """Prints the meal"""
    courses = [self.drinks, self.appetizers, self.main_course, self.desserts]
    for position in range(4):
      course = courses[position]
      if len(course) == 0: #check for an empty list
        print(f"No {self.course_name(position)} served with the meal.")
      elif len(course) == 1: #check for only one item
        print(f"{course[0].capitalize()} was served with the meal.")
```

**Note**, remove the comment symbol `#` for `dinner.add_dessert("chocolate cake")`.

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 6)

## Two Items Were Served

If there are two items being served, the first item should be capitalized followed by `and` and the second item. The sentence will end with `" were served with the meal."`.

```python
def print_meal(self):
    """Prints the meal"""
    courses = [self.drinks, self.appetizers, self.main_course, self.desserts]
    for position in range(4):
      course = courses[position]
      if len(course) == 0: #check for an empty list
        print(f"No {self.course_name(position)} served with the meal.")
      elif len(course) == 1: #check for only one item
        print(f"{course[0].capitalize()} was served with the meal.")
      elif len(course) == 2: #check for only two items
        print(f"{course[0].capitalize()} and {course[1]} were served with the meal.")
```

**Note**, remove the comment symbol `#` for `dinner.add_drink("water")` and `dinner.add_drink("coffee")`.

{try it}(python3 code/mutability/methods2.py 8)

## More than Two Items Were Served

If more than two items are served, then you need a comma-separated list. The first item should be capitalized followed by a comma and a space. The next items are followed by commas and spaces. The final item in the list is prefaced with `and`. No comma is used after the last item. The sentence ends with `" were served with the meal."`. Remember, the final print statement needs to add a new line character. Be sure that it does not have `end=""` in it.

```python
def print_meal(self):
    """Prints the meal"""
    courses = [self.drinks, self.appetizers, self.main_course, self.desserts]
    for position in range(4):
      course = courses[position]
      if len(course) == 0: #check for an empty list
        print(f"No {self.course_name(position)} served with the meal.")
      elif len(course) == 1: #check for only one item
        print(f"{course[0].capitalize()} was served with the meal.")
      elif len(course) == 2: #check for only two items
        print(f"{course[0].capitalize()} and {course[1]} were served with the meal.")
      else: #many items were served
        for item in course:
          if course.index(item) == 0: #check to see if first element
            print(f"{item.capitalize()}, ", end="")
          elif item == course[-1]: #check to see if last element
            print(f"and {item} ", end="")
          else:
            print(f"{item}, ", end="")
        print("were served with the meal.")
```

{try it}(python3 code/mutability/methods2.py 9)

|||challenge
## Check your work:
Create different meals and make sure your program works as expected. For example:

```python
dinner = Meal()
dinner.add_drink("white wine")
dinner.add_appetizer("tapenade")
dinner.add_appetizer("antipasto")
dinner.add_course("cauliflower bolognese")
dinner.add_course("butternut squash soup")
dinner.add_course("kale salad")
dinner.print_meal()
```
<details>
  <summary><strong>Meal Code</strong></summary>
  
  ```python
  class Meal:
    """Class to represent a meal"""
    def __init__(self):
    self.drinks = []
    self.appetizers = []
    self.main_course = []
    self.desserts = []
  
    def add_drink(self, d):
      """Add a drink (d) to the meal (self)"""
      self.drinks.append(d)
  
    def add_appetizer(self, a):
      """Add an appetizer (a) to the meal (self)"""
      self.appetizers.append(a)
  
    def add_course(self, c):
      self.main_course.append(c)
  
    def add_dessert(self, d):
      self.desserts.append(d)
  
    def course_name(self, position):
      if position == 0:
        return "drinks were"
      elif position == 1:
        return "appetizers were"
      elif position == 2:
        return "main course was"
      elif position == 3:
        return "dessert was"
  
    def print_meal(self):
      """Prints the meal"""
      courses = [self.drinks, self.appetizers, self.main_course, self.desserts]
      for position in range(4):
        course = courses[position]
        if len(course) == 0: #check for an empty list
          print(f"No {self.course_name(position)} served with the meal.")
        elif len(course) == 1: #check for only one item
          print(f"{course[0].capitalize()} was served with the meal.")
        elif len(course) == 2: #check for only two items
          print(f"{course[0].capitalize()} and {course[1]} were served with the meal.")
        else: #many items were served
          for item in course:
            if course.index(item) == 0: #check to see if first element
              print(f"{item.capitalize()}, ", end="")
            elif item == course[-1]: #check to see if last element
              print(f"and {item} ", end="")
            else:
              print(f"{item}, ", end="")
          print("were served with the meal.")
  
  dinner = Meal()
  dinner.add_drink("water")
  dinner.add_drink("coffee")
  dinner.add_course("roast chicken")
  dinner.add_course("mashed potatoes")
  dinner.add_course("salad")
  dinner.add_dessert("chocolate cake")
  dinner.print_meal()
  ```
  
</details>

|||

{try it}(python3 code/mutability/methods2.py 10)

{Check It!|assessment}(fill-in-the-blanks-4152483883)

