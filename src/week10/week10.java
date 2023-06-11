package week10;

import java.util.List;

public class week10 {

    /**
     * A generic type is a class or interface that uses other classes or interfaces
     * as parameters at compile time.
     *
     * Convention is types are designated by a single letter (e.g. T)
     *
     * Java libraries use:
     *
     * E - Element (used extensively by the Java Collections Framework)
     * K - Key
     * N - Number
     * T - Type
     * V - Value
     * S, U, V - 2nd, 3rd and 4th types
     *
     * https://docs.oracle.com/javase/tutorial/java/generics/types.html
     *
     * @param <T> The first type
     * @param <T2> the second type
     */
    public class GenericType<T , T2> {
        //T is determined at complile time.
        private T daVariable;
        // This can be a different type
        private T2 daOtherVariable;
        public GenericType (T daVariable , T2 daOtherVariable) {
            this.daVariable =  daVariable;
            this.daOtherVariable = daOtherVariable;
        }
        public T getDaVariable () {
            return this.daVariable;
        }

        public T2 getDaOtherVariable() {
            return this.daOtherVariable;
        }
    }

    /**
     * Generics can be applied at the method level
     *
     * Call with week9.<String>randomGenericMethod("Hello World!")
     * @param in
     * @return
     * @param <T>
     */
    public static <T> String randomGenericMethod (T in) {
        return in.toString();
    }

    /**
     * Bounded Type parameters
     * - Sometimes we want to restrict the possible types of generic parameters
     * - We can use bounded type parameters:
     * - We know that any objects of type T can access the nessecary methods
     */
    public <T extends Number> int getAsInt(T number) {
        return number.intValue();
    }

    /**
     * Multiple ways of inheriting from a generic class:
     * - Extend by passing type paramters
     * @param <T>
     * @param <T2>
     */
    class genericSubclass1 <T,T2> extends GenericType<T, T2> {

        public genericSubclass1(T daVariable, T2 daOtherVariable) {
            super(daVariable, daOtherVariable);
        }
    }

    /**
     * - Extend by passing concrete types.
     * @param <T>
     */
    class genericSubclass2 <T> extends GenericType<T, String> {

        public genericSubclass2(T daVariable, String daOtherVariable) {
            super(daVariable, daOtherVariable);
        }
    }
    /**
     * Using a subclass as a generic parameter does not imply any relationship between the generic classes.
     *
     * i.e. class B extends A {...}
     * does not imply that
     * ArrayList<B> extends ArrayList<A>
     * therefore:
     * The following will not work
     * // will not compile - "incompatible types
     * ArrayList<A> listOfA new ArrayList<B>();
     *
     */
    public void genericInheritance() {

    }

    /**
     * Wildcards in Java (indicated by a ?) represent an unknown. They are useful when generic types are required
     * but do not nessecarily need to be named.
     *
     * Why not just take a List<Object> as an argument
     * -> That would only take a List<Object> as an object
     * -> List<?> allows any types of list as an argument
     *
     * Bounded wild card.
     * ? - Allows any type
     * ? extends Type - Allows Type or any subclass of Type.
     * ? super Type - allows Type or any superclass of Type
     * @param toPrint Some list.
     */
    public void printList(List<?> toPrint) {
        for (Object item: toPrint){
            System.out.println(item);
        }
    }
    /**
     * The Java compiler handles generics at compile time by:
     * - Replacing generic types with Object
     * - Replacing bounded generic types with the bound
     * - Adding casts where required
     * - Adding existing bridging methods when required
     *
     * Restrictions on Generics:
     * - No primitive types
     * - No instantiating generic type parameters
     * e.g. T item = new T(); // compile error
     * -No static fields can be of a type parameter type
     * e.g. public static T myVariable; // compile error
     * - No arrays of parameterised types
     * e.g. Pair <String, Integer> [] array = new Pair<>[5]
     * - No generic exceptions
     * - Restrictions on overloaded functions
     * e.g.
     * public int method1(List<String> list); // can't do it
     * public int method1(List<Float> list);
     *
     * https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
     */
    public void moreGenericInformation(){
    }
 }
