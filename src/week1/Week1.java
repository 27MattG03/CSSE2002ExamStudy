package week1;

public class Week1 {
    /**
     * Java is a General Purpose, Compiled, Object Oriented, Concurrent and Class Based Programming Language.
     *
     * Object-Oriented means that Java is based on Objects. Everything in Java is an Object.
     * General purpose means that Java is not limited to any specific domain.
     * Compiled means that Java is compiled to Bytecode which is then interpreted by the JVM.
     * Concurrent means that Java supports multiple threads of execution.
     * Class Based means that Java is based on Classes and Objects.
     *
     * @param args
     */
    public static void main(String[] args) {
       variableScope();
    }

    /**
     * Java is a strongly typed language. This means that every variable must be declared with a type.
     * There are 2 type of types in Java: Primitive Types and Reference Types.
     * Primitive Types are the basic types in Java. They are: byte, short, int, long, float, double, boolean and char.
     */
    public static void primitiveTypes() {
        int integer = 1;
        //floating point number
        float floatingPoint = -1.9f;
        //higher precision floating point
        double doubleFloatingPoint = -1.9e200;
        boolean bool = true;
        //long integer
        long longInteger = 1000000000000000000L;
        //single unicode character
        char character = 'a';
        //small whole number
        short shortInteger = 1;
    }

    /**
     * This code doesn't compile because the variable z is not in scope.
     * Scope is the region of the program where a variable is visible.
     * In this case, the variable z is only visible inside the if and else blocks.
     */
    public static void variableScope() {
        if (true) {
            int z = 3;
        } else {
            int z = 4;
        }
        System.out.println("Can't print z as not in scope.");
    }

    /**
     * A switch statement is a control flow statement that allows a variable to be tested for equality against a list of values.
     * @param input the input to be tested
     */
    public static void switchExample (int input) {
        switch (input) {
            case 1:
                System.out.println("Input is 1");
                break;
            case 2:
                System.out.println("Input is 2");
                break;
            default:
                System.out.println("Input is not 1 or 2");
        }
    }

    /**
     * A do-while loop test the condition at the end of the loop.
     * This means that the loop will always execute at least once.
     * A while loop tests the condition at the start of the loop.
     * This means that the loop may not execute at all.
     */
    public static void doWhileVsWhileExample () {
        do {
            System.out.println("This will be printed at least once");
        } while (false);


    }


}

