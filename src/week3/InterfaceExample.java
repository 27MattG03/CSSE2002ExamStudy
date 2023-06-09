package week3;

/**
 * An interface is a type of class that only contains abstract methods.
 *
 * A class implementing an interface is responsible for supplying method bodies for everything declared in the interface.
 *
 * Why would you want to use an interface?
 * - Could be used to advertise that your class has additional useful capabilities.
 * - Could be used to indicate that your class belongs to multiple groups
 * - interfaces fill a role taken by abstract1 classes in other languages.
 */
public interface InterfaceExample {

    public void doSomething();

    /**
     * An interface can also contain default methods.
     */
    private void doSomethingElse() {
        System.out.println("Hello world!");
    }

}
