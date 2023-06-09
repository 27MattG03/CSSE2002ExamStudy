package week5;

public class week5 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * EXAMPLE JAVA DOC
     * -----------------
     * Do a thing - in this case, add two numbers together.
     * @param a An input number
     * @param b Another input number
     * @return The sum of the two input numbers
     * @throws IllegalArgumentException If either input number is negative
     */
    public static int add2Numbers(int a, int b)  throws IllegalArgumentException{
        return a + b;
    }

    /**
     * Procedural abstraction makes programs easier to
     * read and maintain by keeping the size and complexity of methods small.
     * Guidelines:
     * 1. Methods should be decomposed according to functionality, not lines of code.
     * 2. Each method should perform one task (can be an aggregate task).
     *       -> Delegate tasks to private helper methods.
     * 3. Be suspicious of:
     *     - Methods that are hard to name
     *     - repeated code
     *     - Overly long methods
     *     - Conditional statements on types of method arguments
     */
    public static void proceduralAbstraction(){

    }

    /**
     * Ideally specifications:
     * - Allow the implementation of a method to be read or written
     * without needing to examine the implementations of any other methods.
     * - Allow the implementation of a method to be changed without needing to
     * change the implementations of any other methods.
     *
     *
     * Should:
     * - Rule out all implementations that are unacceptable (i.e. be sufficiently restrictive).
     * - Not preclude acceptable implementations (i.e. be su ciently general).
     * - Be easy to understand.
     * - Draw attention to possible consequences of implementation decisions
     *
     * Levels of formalism:
     * - informal (e.g. comments)
     * - semi-formal -> structured english documentation (e.g. Javadoc)
     * - formal -> mathematical notation (e.g. pre/post conditions)
     *
     */
    public static void specification () {

    }

    /**
     * WITHDRAWAL EXAMPLE
     * ------------------
     * Informal:
     * Withdraw an amount from this account and return how much is left.
     */
    public static int withdrawal(int amount) {
        return 0;
    }

    /**
     * Semiformal:
     * Withdraw an amount from this account .
     * @param amount The amount to withdraw
     * @return Balance of the account after withdrawal
     */
    public static int semiFormalWithdrawal(int amount) {
        return 0;
    }

    /**
     * Formal:
     * Withdraw an amount from this account.
     * @require amount >= 0 && amount <= getBalance()
     * @ensure getBalance() == \old(getBalance()) - amount && \result == getBalance()
     *
     * If the code calling the method satisfies the precondition, then the method guarantees
     * to satisfy the post condition.
     *
     * If the code calling the method does not satisfy the precondition,
     * then the method guarantees nothing (any behaviour is allowed).
     *
     *
     * Java syntax for boolean expressions:
     *      \result -> the return value of the method
     *      \old(x) -> the value of x before the method was called
     *      \forall C c -> for all objects c of type C
     *      \exists C c -> there exists an object c of type C
     *      a => b -> a implies b
     *      a <==> b -> a if and only if b
     *
     * Specifications using the above constructs are supported by compile
     * and runtime checking tools for JML (Java Modelling Language)
     *
     * Assertions can be used to check the pre and post conditions.
     *
     * NEVER USE ASSERTIONS AS A REPLACEMENT FOR IF STATEMENTS
     *
     * Assertions should be used to check assumptions about the state of the program
     * that should always be true.
     *
     * Assertions should not be used to check for errors that can occur in normal operation.
     *
     * Used to aid in debugging and testing.
     */
    public static int formalWithdrawal(int amount) {
        assert amount >= 0 && amount <= getBalance();
        return 0;
    }

    private static int getBalance() {
        return (int) Math.random();
    }
    /**
     * Liskov Substitution Principle:
     * If S is a subtype of T, then objects of type T may be replaced with objects of type S
     *
     * Result:
     * - The behaviour of the program should not change
     * - If we Override some method in S, the specification of the method in T should still hold
     *       \
     *        -> The Preconditions of the method in S can only be weaker than the preconditions of the method in T
     *        \
     *         -> The Post-conditions of the method in S can only be stronger than the post-conditions of the method in T
     *
     * Stronger pre/post - conditions -> more restrictive
     * Weaker pre/post - conditions -> less restrictive
     *
     *
     */

}
