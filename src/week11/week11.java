package week11;


import java.util.ArrayList;
import java.util.List;

public class week11 {
    public static void main(String[] args) {
        RandomClass regular = new RandomClass();
        RandomClass.InnerClass inside = regular.new InnerClass();
        RandomClass.StaticInnerClass staticExample = new RandomClass.StaticInnerClass();
    }
    public void anonymousClass() {
        RandomClass instance = new RandomClass() {
            @Override
            public String toString() {
                return "Hello World!";
            }
        };
        System.out.println(instance);

    }

    /**
     * Normal Interfaces
     *  - Cannot be used to create object
     *  - Does not have a body - the body is provided by "implemented" class
     *  - Must override all methods
     *  - Methods are by default abstract and public
     *  - An interface cannot contain a constructor (as it cannot be used to create objects)
     *
     * Can have a single method, called functional
     * Can be a marker - an interface without methods
     */
    public void AnonymousInterfaces () {
        interface Animal {
            void says();
        }
        Animal daDog = new Animal() {
            @Override
            public void says() {
                System.out.println("woof woof innit");
            }
        };
    }
    /**
     * Lambda expressions are anonymous methods
     *  - don't have a name
     *  - don't belong to a class
     *
     * Format:
     * parameter -> expression
     *
     * (parameter 1, parameter 2) -> expression
     *
     * (parameter 1, parameter 2) -> { code block }
     *
     * They can:
     * - Define inline implementation of a functional interface
     * - Reduce the need for anonymous classes
     *      -> many common uses in Java were implement functional interfaces
     *
     * Functional Interfaces:
     * - Interface defining a single abstract method
     * - May contain default and static methods or overridden methods from object
     *
     * Because there is only one abstract methods its name can be ommited when it's implemented
     *      - anonymous class expression
     *      - lambda expression
     * Allows functionality (method logic) to be passed as data to other methods
     *  -Functionality can be used in the method
     */
    public void lambdaExpressions() {
        interface rand {
            String hello();
        }

        rand hello = () -> "hello";

        List<String> animalNames = new ArrayList<>();

        animalNames.add("Boozle");
        animalNames.add("Tilda");
        animalNames.add("Teddy");
        animalNames.add("Liddle");

        animalNames.forEach(name -> System.out.println(name));
    }
    /**
     * Method Reference:
     * Used to refer to a method of a functional interface -> easy form of lambda expression
     *
     * Maybe a
     * - reference to a static method
     * - reference to an instance method
     * - reference to a constructor
     */
    public void methodReference() {
        class Random {
            public static void hello () {System.out.println("Hello World!");}

        }
        Runnable random = Random::hello;

    }
}
