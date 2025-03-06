# Technical Documentation CS1050 #

**Table Of Contents**
- [Module 01](#module-01-programming-fundamentals-and-java)
- [Module 02](#module-02-predefined-classes-methods-and-decision-structures)

## Module 01: Programming Fundamentals and Java ##

### Naming Conventions ###

These are a set of rules that each type of programming language has (ex: java, python, css) to help make code more **readable**.

Readability in code is paramount because it allows you to *quickly* and *easily* identify what is going on. Using standard naming convenetions for ***whatever*** language you are working in helps make your code a) editable and b) scalable. Even after you have left the project. It allows others to come behind you and work within the program you wrote.

There are a few types of naming conventions discussed in this module

1. Variables
    - The first word is lowercase then the rest are uppercase
    - <ins>**b**</ins>right<ins>**S**</ins>un<ins>**F**</ins>lower
2. Constants
    - All caps, with underscores to separate words
    - LIVE_LAUGH_LOVE
3. Classes
    - Capitalize the beginning of each word
    - <ins>**B**</ins>est<ins>**E**</ins>xample<ins>**E**</ins>ver
4. Methods
    - All lower case, but will be clearly separate so it won't be confusing
5. Data Types
    - All lower case
    - `double; int; string`

### Types of Errors ###

There are several types of errors that you may come across as you code. They can generally be categorized into the below categories.

#### Syntax Errors ####

This type of error occurs when you **violate** the syntax of the code. Kind of self explanatory right? This can happen whenever you don't put on a semicolon `;` at the end of a line of code.

[comment]: # (Insert picture of syntax error due to ;)

This will be detected by the compiler, so your code won't actually run.

#### Runtime Errors ####

These error types aren't caught by the initial compiling, and instead happens whenever the code is actually running.

An ***error*** message will display in the console as a result.

[comment]: # (Insert picture of error message in console)

This is caused by something being off *within* your code that the computer can't understand. For example, dividing something by a `0`. This is not technically possible, and the computer will go wtf and throw it back at you.

#### Logic Errors ####

Logic errors are another way of saying **user error** essentially.  
You designed your algorithm wrong somewhere and now your code is going off the rails doing stuff that you aren't anticipating.   

`It's become sentient.`

Scary stuff for sure. Apocalyptic scene where computers are taking over the world. 

Anyways this can be something as simple as your program getting stuck in a loop forever whenever it was supposed to exit eventually.

Another example that we've used in class can be with the assigning letter grades based on your final grade result.

```javascript
if (finalGrade => 90)
    {
        System.out.println ("A");
    }

if (finalGrade => 80)
    {
        System.out.println ("B");
    }
```

In the above example, what I'm trying to do is have the program display **1** output, either A or B. What actually will happen is if the `finalGrade` is over 80, then it will display as ***both*** A **and** B.

In this case, a more appropriate code would be as follows...

```javascript

double finalGrade = 85

if (finalGrade => 90)
    {
        System.out.println ("A");
    }
if else (finalGrade => 80)
    {
        System.out.println ("B");
    }
```

Because the program will check each case until it finds one that is true, it won't give multiple outputs. This is called a multi-way if *further discussed in [module 2](#module-02-predefined-classes-methods-and-decision-structures)*

### Primitive Data Types ###

These are data types that can only hold **one** value at a time. 

In order from smallest to largest for numbers;

1. Byte
2. Short
3. Int
4. Long
5. Float
6. Double

However, in this class we're mainly going to be using `int` and `double`. These are relatively simple yet extremely versatile.

`int` can only hold **whole** numbers.   
25, 348, 1268308

`double` can hold whole numbers **including** decimals.  
85.3, 0.943, 1000.987

There is also `boolean`'s and `char`'s  
A boolean holds a true/false value  
Char holds a single character

#### Implicit vs Explicit Casting ####

**<ins> Implicit Casting </ins>**  
This is moving smaller data types into a **larger** bucket. This does **not** need to be specifically coded. Because there is still "room" for the smaller data type to be in the larger bucket without overflowing.

```java
    int DOG_AGE = 5

    double humanAge = (DOG_AGE)(5)
```

**<ins> Explicit Casting </ins>**  
This is moving a larger data type into a **smaller** bucket. You have to *explicitly* (cute right?) state that you're wanting to cast this into a smaller bucket. This essentially compresses the value to fit into the smaller bucket.

```java
    double QUIZ_AVERAGE = 79

    int finalGrade = (int)(QUIZ_AVERAGE)(0.20)
```

### How does Division work?

How the program executes division has everything to do with what **data type** you are using. 

`1/2` will output `0`  
That's weird? Why would it do that? It's because you used two values that were `int`. The result of this operation is technically a double, because it is `0.5`.

You have to *explicitly* state what type of output you want if it is something other than what is being used initially. 

`(double)(1/2)` will output `0.5`

### What is **hard coding** and why is it bad?

Hardcoding is when you put in a value into the code itself instead of assigning a constant to use for it. This makes your code not only more readable, but also more adaptable. Instead of having to go through and change each instance of the constant number being used, you just have to change it once.

## Module 02: Predefined Classes, Methods, and Decision Structures ##

### Packages ###

Packages are essentially an umbrella term for classes that share similar functions and characteristics.

- Prevent naming conflicts by allowing classes with the same name to exist in different packages, like **college.staff.cse.Employee** and **college.staff.ee.Employee**
-  They make it easier to organize, locate, and use classes, interfaces, and other components.

You may have to import packages/classes sometimes. For example, to use the **Scanner** class, you must put the following *before* you implement the main method.

```java
import java.util.Scanner
```

The **java.util** is the package, and the Scanner is the specific class that you are calling.

### Classes ###

Every Java program must have a **class**. This is like a set of blueprints that you can call from to execute specific functions. 

For example the *Math* class has useful methods within it that relate to mathematical computation.

Once you import the desired class, you can then use **methods** within that class to create objects to utilize within your code.

#### Creating an Object from a Class ####

To use imported classes, you must first create an object that utilizes the blueprint of them. 

```java
Point originOne = new Point(23, 94);
Rectangle rectOne = new Rectangle(originOne, 100, 200);
Rectangle rectTwo = new Rectangle(50, 100);
```

`Point` is a class, `originOne` is the object name, and `new Point(23,94);` is giving instructions from the point class to the new object.

There are some classes that you do not have to create objects from before utilizing them. An example of this would be the Math or System class. At any point within the program you can call on these classes without having to create an object first.

### Methods ###

Methods are essentially blueprints within a class. They have formal parameters that dictate what they are able to execute. These formal parameters are then passed onto the actual parameters once a value has been assigned.

Some classes/methods are **already** imported into java by default. For example, you do not need to explicitly import the `Math` class or the `System` class in order to utilize methods from them. These are baked into the `java.lang` and that is a package that is *auto imported*.

