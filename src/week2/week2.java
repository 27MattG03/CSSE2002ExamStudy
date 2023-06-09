package week2;
import java.io.FileNotFoundException;
public class week2 {
    //Unless specific requirement, all variables should be private.
    public static String staticExample = "This variable is shared by all instances of this class";
    private String privateExample = "Only this class can use this variable";
    public String publicExample = "Any class can use this variable";
    protected String protectedExample = "Only this class and subclasses can use this variable";
    String noneExample = "Only classes in this package can use this variable";
    public static void main(String[] args) {
       equalsExample();
    }

    /**
     * If users of your class are calling its methods,
     * do they need to know how state is represented (or how methods are implemented)?
     *
     * If the answer is no, then you should hide the implementation details.
     * @return 2 + 2
     */
    public int abstractionExample () {
        Adder add = new Adder();
        //We don't need to know how the adder class does this.
        return add.add2Numbers(2, 2);
    }
    /**
     * Don't necessarily need import if you use full name.
     *
     * java.lang is imported by default.
     */
    public void importExample() throws FileNotFoundException {
        java.io.FileReader f = new java.io.FileReader("file.txt");

    }

    /**
     * Every function call reserves some memory to store local variables.
     * This memory is released when the function returns, i.e. as long as the call is active.
     * A call won't end while it still has active calls.
     * A new call means a new block of memory is added to the end, this is called the call stack.
     *
     * Memory heap:
     * Storage on the heap is not bound to calls.
     *
     * In Java, all objects are stored on the heap.
     * All local variables are stored on the stack.
     */
    public int stackAndHeapExample() {
        int x = 1;
        int y = 2;
        int z = x + y;
        return z;
        //The memory for x, y and z is released when this function returns.
    }

    /**
     * Objects are stored by reference.
     * Primitive types are stored by value.
     */
    public static void equalsExample() {
        //Primitive type example
        int y = 1;
        int x;
        x = y; // make x store a copy of y’s value
        System.out.println(x == y); // does x store the same value as y?
        System.out.println(x != y); // or not?
        //Reference type example
        Integer y2 = new Integer(1);
        Integer x2;
        x2 = y2; // make x2 refer to the same object as y2
        System.out.println(x2 == y2); // does x2 refer to the same object as y2?
        System.out.println(x2 != y2); // or not?

        // Equality in floating point number is tricky
        double a = 0.1;
        double b = 0.2;
        double c = 0.3;
        System.out.println(a + b == c); // false
        System.out.println(a + b); // 0.30000000000000004
        // instead use Math.abs(a + b - c) < 0.0001
        System.out.println(Math.abs(a + b - c) < 0.0001); // true

        //object equality example
        String s1 = "Hello World!";
        String s2 = "Hello ";
        String s3 = "World!";
        String s4 = "Hello World!";
        String s5 = s1;

        System.out.println(s1 == s4); // true
        System.out.println(s1 == s5); // true
        System.out.println(s1 == s2 + s3); // false
        System.out.println(s1.equals(s2 + s3)); // true
    }
    /**
     * Inheritance:
     * A subclass inherits all the methods and variables of its superclass.
     * Instances of subclasses can be used wherever instances of the superclass are expected.
     * A subclass can override methods of its superclass.
     */
    public void inheritanceExample() {

    }
    /**
     * java.lang.Object is the superclass of all classes in Java.
     * Important methods:
     * equals(Object o) : boolean -> true if this object is equal to o
     * hashCode() : int -> number that is unique to this object
     * toString() : String -> string representation of this object
     * clone() : Object -> clone of this object
     */
    public void objectExample() {
        Object o = new Object();
        System.out.println(o.equals(o)); // true
        System.out.println(o.hashCode()); // 366712642
        System.out.println(o.toString()); // java.lang.Object@15db9742

    }

    /**
     * Example of overriding pre-existing methods.
     * @return
     */
    @Override
    public String toString() {
        return "This is a string representation of this object";
    }









}
