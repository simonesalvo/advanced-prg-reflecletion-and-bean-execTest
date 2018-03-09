# Java Beans and Reflection

Write the Java program ExecTest that takes as arguments the names of other Java classes. 
For each class name, ExecTest loads the corresponding class, say it C, by using the reflection API. 
After loading C, ExecTest must create a new instance t of C, must search and invoke on t all the non private methods with no arguments whose name starts with test. 

Test your program using the provided class ClassWithTest either setting the Arguments field in the Project Properties configuration window of NetBeans or running in a shell the command
java ExecTest ClassWithTest

### The expected output should be
Tests ready to run

Invocation of testAbs

* |abs(-2) = 2: ok
* abs(-3) = -2: no

Invocation of testRound

* round(0.7) = 1: ok
* round(0.2) = 1: no

Invocation of testMin

* min(7,3) = 3: ok
* min(5,7) = 7: no

Invocation of testMax

* max(7,14) = 14: ok
* max(5,7) = 5: no

__Solution format: Source java files__