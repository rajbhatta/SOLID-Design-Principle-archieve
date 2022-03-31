# What is Liskov Substitution Principle #
- Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

- This means that every subclass or derived class should be substitutable for their base or parent class. To be clear: if a program is referencing base class then reference to a base class can be replaced with a dervied class without affecting the functionality of the program.
