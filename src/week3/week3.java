/**
 * Package declaration:
 * Packages can be used to avoid name clashes instead of using very long names.
 * Package declarations must be the first line in a file.
 *
 * The directory structure must match the package structure.
 * Example: src/week3/week3.java
 *
 *
 * Packages and Access Control:
 * -> protected members are accessible to all methods in any classes in the same package.
 * -> Items with no explicit access specifier can be used by any class in the same package but not by subclasses.
 *
 *
 */
package week3;

import java.util.Stack;

public class week3 implements InterfaceExample{


    public static void main(String[] args) {

    }
    /**
     * Now this class can be used as an InterfaceExample.
     */
    public void doSomething() {
        System.out.println("Hello world!");
    }

    public void castingExample () {

        int i = 1;
        float f = i; // implicit casting
        int i2 = (int) f; // explicit casting

        // Casting reference types
        // Casting a reference type is like casting a primitive type.

        Object o = "Hello World!";
        String s = (String) o; // explicit casting
        Object o2 = s; // implicit casting
        // Upcasts are always allowed
        // Downcasts must be explicit
        // You cannot cast between unrelated types
        // You cannot cast to a primitive type
    }
    /**
     * Consequences of Java’s design
     *
     * All callable code is in methods
     *  -> No free functions
     *  -> Greater use of static methods than in other languages
     *  -> More implementation/non-model classes
     * All variables and constants must be in classes and methods
     * Primitive types are not objects
     *  -> Containers only hold objects
     *  -> Need to use wrapper classes to store primitives in containers
     * Single inheritance means interfaces are needed to declare extra capabilities into the class hierarchy.
     *
     */
    public String infoDump (){
        return "Read documentation";

    }

    /**
     * Exceptions are used to signal that something has gone wrong.
     * We can catch exceptions and handle them.
     *
     * -> Don't just squash exceptions.
     * -> Once an exception has been thrown it will keep going up the call stack until it is caught.
     * -> If an exception is not caught, the program will terminate.
     * -> A try can have multiple catches.
     * -> finally is always executed.
     * -> trigger an exception with throw.
     *
     * 2 options for handling exceptions:
     * 1. try-catch
     * 2. throws in declaration of method
     */

    public void exceptionExample() {
        try {
            // code that might throw an exception
        } catch (Exception e) {
            // code to handle the exception
        } finally {
            // code that is always executed
        }
    }

    /**
     * Exceptions are classes and we can create our own.
     * Inheritance hierarchy:
     *
     * Throwable -> Exception -> RuntimeException
     *            \
     *             -> Error -> Do not catch these
     *
     * Pros and Cons of Exceptions:
     * • Code that detects the problem may not know what it should do about it (move IO to borders of the program).
     * • Exception propagation means decisions can be made elsewhere (without needing to code a return path all the way back).
     * • Can carry a lot of information
     * • Can’t be ignored (unless squashed)
     * • Java likes them
     * • Did something go wrong (waves vaguely) somewhere in there.
     * • Not as good if the problem should be checked immediately.
     * • Less convienient where fine control is needed
     * • Better for “exceptional” circumstances
     * • If it can be checked for ahead of time, is it better to do that instead?
     */
    class ExampleException extends Exception {
        public ExampleException(String message) {
            super(message);
        }
    }

    /**
     * Collections are used to store groups of objects.
     * Collections only store objects.
     *
     * A stack is a collection that is LIFO (last in first out).
     * Good for:
     * -> Reversing things
     * -> Putting something asside to be dealt with later
     * -> Depth first algorithms
     */
    public void stackExample() {
        Stack<String> stack = new Stack<>();
        stack.empty(); // returns true if the stack is empty
        stack.peek(); // returns the top item without removing it
        stack.pop(); // returns the top item and removes it
        stack.push("Hello World!"); // adds an item to the top of the stack
    }




}
