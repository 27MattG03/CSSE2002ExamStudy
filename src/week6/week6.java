package week6;

import java.util.ArrayList;
import java.util.List;

public class week6 {
    /**
     * For objects, the reference cannot be modified after its first assignment. But the object itself can be modified.
     */
    final static Integer CONSTANT_OBJECT = new Integer(1);

    /**
     * The final keyword has two possible meanings depending on its context.
     * For variables, the value cannot be modified after its first assignment.
     */
    final static int CONSTANT = 1;


    public static void main(String[] args) {
        equalsProperties();
    }

    /**
     * instanceof is used to check if an object is an instance of a particular class.
     * <p>
     * -> Returns true if the value of the expression can be treated (with appropriate casts) as type.
     * -> It is not the same as asking “Is this instance of precisely this class (i.e. not a subclass)?”
     * -> Does not tell us exactly what class the object was created as1.
     */
    public static void instanceOfExample() {
        Object o = "Hello World!";
        if (o instanceof String) {
            String s = (String) o;
            System.out.println(s);
        }
    }

    /**
     * Different operating systems have different ideas about how to encode a new line in characters:
     * -> Windows: \r\n
     * -> Mac OS: \r
     * -> Unix: \n
     * <p>
     * println() automatically uses the correct newline character for the operating system you are using.
     * System.lineSeparator() or String.format("%n") will give you the string if you need it.
     */

    public static void newlines() {
        System.out.println("Hello" + System.lineSeparator() + "World!");
    }

    /**
     * The ternary operator is a shorthand for if-else statements.
     * <p>
     * format:
     * test expression ? true expression : false expression
     */

    public static void ternaryOperatorExample() {
        int x = 1;
        int y = 2;
        int z = x < y ? x : y;
        System.out.println(z); // 1
    }

    /**
     * Final methods cannot be overridden in subclasses.
     */
    public final void finalMethodExample() {
        System.out.println("Hello world!");
    }
    /**
     * Final classes:
     * -> members variables cannot be modified after their first assignment.
     * -> no subclasses can be created.
     */
    final class FinalClass {
        /** x cannot be modified after its first assignment. */
        public int x = 1;
    }
    /**
     * Abstract methods:
     * -> no implementation.
     * -> must be implemented by subclasses.
     *
     * if a class has an abstract method, the class must be declared abstract.
     *
     * Abstract classes:
     * -> cannot be instantiated.
     * -> can have abstract methods.
     * -> must be subclassed to be used.
     */
    abstract class AbstractClass {
        public abstract void abstractMethod();
    }
    /**
     * Operators example
     */
    public static void operatorExample (int x, int y){
        System.out.println(x++); // post-increment
        System.out.println(++x); // pre-increment
        System.out.println(x--); // post-decrement
        System.out.println(--x); // pre-decrement
        System.out.println(+x); // unary plus
        System.out.println(-x); // unary minus
        System.out.println(x + y); // addition
        System.out.println(x - y); // subtraction
        System.out.println(x * y); // multiplication
        System.out.println(x / y); // integer division
        System.out.println(x % y); // remainder
        System.out.println(x == y);  // equal to
        System.out.println(x != y); // not equal to
        System.out.println(x > y); // greater than
        System.out.println(x < y); // less than
        System.out.println(x >= y); // greater than or equal to
        System.out.println(x <= y); // less than or equal to
        System.out.println(x & y); // and
        System.out.println(x | y); // inclusive or
        System.out.println(x ^ y); // exclusive or
        System.out.println(~x); // complement
        System.out.println(x << y); // sign fill
        System.out.println(x >> y); // sign fill
        System.out.println(x >>> y); // zero fill
        System.out.println(x == y && y > 2); // and
        System.out.println(x == y || y > 2); // or
        System.out.println(!(x == y)); // not
        x ^= y; // x = x to the power of y
        x &= y; // x = x and y
        x |= y; // x = x or y
        x <<= y; // x = x shifted left by y
        x >>= y; // x = x shifted right by y
        x >>>= y; // x = x shifted right by y with zero fill
    }

    /**
     * StringBuilders are mutable.
     * -> append() adds a string to the end of the StringBuilder.
     * -> insert() adds a string at a particular index.
     * -> delete() removes a range of characters.
     * -> reverse() reverses the string.
     * -> toString() converts the StringBuilder to a String.
     * -> length() returns the length of the StringBuilder.
     * -> charAt() returns the character at a particular index.
     * -> setCharAt() sets the character at a particular index.
     * -> substring() returns a substring.
     * -> indexOf() returns the index of a character.
     * -> lastIndexOf() returns the last index of a character.
     * -> equals() compares two StringBuilders.
     * -> compareTo() compares two StringBuilders.
     * -> equalsIgnoreCase() compares two StringBuilders ignoring case.
     * -> startsWith() checks if a StringBuilder starts with a particular string.
     * -> endsWith() checks if a StringBuilder ends with a particular string.
     * -> contains() checks if a StringBuilder contains a particular string.
     * -> replace() replaces a substring with another string.
     * -> trim() removes whitespace from the beginning and end of a StringBuilder.
     * -> toLowerCase() converts the StringBuilder to lowercase.
     * -> toUpperCase() converts the StringBuilder to uppercase.
     *
     */

    public static void stringBuildersExample() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World!");
        sb.insert(5, "Big ");
        sb.delete(5, 9);

        System.out.println(sb.toString());
    }

    /**
     * The shallowest copy is a reference to the original object.
     * -> If you change the original object, the copy will change.
     * -> If you change the copy, the original object will change.
     *
     * The object class has a clone() method.
     *  -> As it is protected, you must override it in your class.
     *
     * Class needs to implement the Cloneable interface.
     * Typically, call Object.clone()
     * Copy mutable objects that represent the state of the object.
     *
     * Object.clone() will make a new object of the same type with copies of the instance variables.
     */
    public static void copyingExample () {
        //Shallowest copy
        int[] a = {1, 2, 3};
        int[] b = a;
        //Object.clone
        int[] c = a.clone();
        System.out.println(c != a); // true
        System.out.println(c.getClass() == a.getClass()); // true
        a.clone().equals(a); // true
    }
    static class A {
        public int x;
        public int y;

        public A(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof A && this.x == ((A) obj).x && this.y == ((A) obj).y) {
                return true;
            } else {
                return false;
            }
        }
    }
    static class B extends A {

        public int z;

        public B(int x, int y, int z) {
            super(x, y);
            this.z =z ;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof B && this.x == ((B) obj).x && this.y == ((B) obj).y && this.z == ((B) obj).z  ) {
                return true;
            } else {
                return false;
            }
        }
    }
        /**
     * The equals() method compares two objects.
     * -> It returns true if the objects are equal.
     * -> It returns false if the objects are not equal.
     */
    public static void equalsProperties() {
        List<String> x = new ArrayList<>();
        x.add("Hello");
        x.add(" World!");
        List<String> y = new ArrayList<>();
        y.add("Hello");
        y.add(" World!");
        List<String> z  = new ArrayList<>();
        z.add("Hello");
        z.add(" World!");

        // Reflexive
        x.equals(x); // true


        // Symmetric
        x.equals(y); // true
        y.equals(x); // true

        // Transitive
        if (x.equals(y) && y.equals(z)) {
            x.equals(z); // true
        }

        //Deterministic
        x.equals(y); // gives the same result every time

        //Null
        x.equals(null); // false

        A a = new A(1, 2);
        B b = new B(1, 2, 3);

        // The equals method used by a subclass will depend on which class is calling it.

        // super calls A.equals() therefore it will return true
        System.out.println(a.equals(b)); // true

        // child calls B.equals() therefore it will return false
        System.out.println(b.equals(a)); // false
    }

    /**
     * Equals and Hashcode:
     * If x.equals(y), then x.hashCode() == y.hashCode()
     * if .equals() is overridden, .hashCode() should be as well
     * Which parts of state should be used for .equals() and
     * .hashCode() calculations?
     *
     * Two schools of thought:
     * 1. Use all instance variables
     *        -> Shows if two objects states are the same
     * 2. Use only immutable instance variables
     *       -> Shows object identity
     *       -> If two objects have the same identity, they will always have the same hashcode\
     *
     * What is a hashcode?
     * Hash codes are computed values.
     *
     * Hash functions:
     * -> take an input
     * -> perform a computation on the input
     * -> return the resulting hash code
     *      \
     *       -> usually a numeric value
     * Intent is that the hash code can be used to identify an object
     * -> Hash codes are not guaranteed to be unique
     *  x.equals(y) => x.hashCode() == y.hashCode()
     *  not x.hashCode() == y.hashCode() => x.equals(y)
     *
     *
     * Which parts of state should be used for .equals() and .hashCode() calculations?
     * -> for this course .equals is about state
     *     \
     *      -> an objects reference provides identity
     *
     * -> hence we should use state to calculate hashcodes
     *
     *
     *  need to consider:
     *    ->  Does changing state make it a different object?
     *    -> Or, is it different internal state of the same object?
     *    -> Context in which objects are used will have different answers.
     *    -> That will determine whether only immutable parts of state should be used
     *    to calculate hash code or also mutable
     */
    public void hashCodeAndEqualsPrinciples () {
        System.out.println("Refer to documentation for this section");
    }

}

