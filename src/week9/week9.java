package week9;

public class week9 {

    public static void main (String[] args) {
        runCounterMVExample();
    }

    /**
     * Cohesion:
     * - How well do the parts of the class (states and methods) fit together?
     * - Do they all contribute to a single, clear purpose?
     *
     * e.g. Car class contains
     * Fuel <- Ok
     * Steering <- Ok
     * Speed <- Ok
     * Route planner <- Probable should not be here
     * Public holiday calculator <- Definitely should not be here
     *
     * High cohesion is preferable (low usually indicates a class should be split)
     *
     * Cohesion Spectrum
     *
     * Coincidental Logical Temporal Procedural Communicational Sequential Functional Object
     * <------------------------------------------------------------------------------>
     * Low                                                                             High
     * Scatter-Brained                                                                 Single-minded
     *
     * High Cohesion:
     * - Classes should be easier to understand
     *      -> Fewer extraneous ideas to think about
     * - Testing is easier
     * - Modification is easier
     *
     * Cohesion Types:
     *
     * 1. Coincidental
     *      -> Grouped (e.g. in class or method) arbitarily and do not have a clear relationship to each other
     * 2. Logical
     *      -> Grouped together because they do the same thing
     * 3. Temporal
     *      -> Grouped together because of when they are exectuted
     * 4. Procedural
     *      -> Grouped together because the operations are always done in the specified order
     * 5. Communicational
     *      -> Grouped together because they operate on the same data
     * 6. Sequential
     *      -> Grouped together because operations are performed in a specific order and operate on the same data.
     * 7. Functional
     *      -> Grouped together because they all contribute to a single well-defined objective or task.
     *
     * A rule of thumb:
     * Write a sentence describing the purpose of the class, it should be:
     * -> Short, clear and unambiguous description implies good cohesion
     * -> Compound sentence (i.e. contains a comma or more than on verb): probably represents more than one concept (bad)
     * -> Contains time related words - probably sequential or temporal cohesive
     * -> Words like intialise, clean-up etc. - imply temporal cohesion
     * -> Predicate doesn't contain a single specific object following the verb - probably logically cohesive *TODO GET EXPLANATION FROM LECTURE
     */
    public static void cohesion() {
        System.out.println("See documentation");
    }

    /**
     * Coupling:
     * - To what extent does this class depend on other classes?
     * - How many methods are called on how many other classes?
     * - How much internal data is passed as parameters?
     * - How much internal data is returned by getter methods?
     * - Are references to internal data returned from methods?
     * - Are references to internal datta returned from methods?
     * - Can another object influence the flow of control in this object?
     *
     * Low coupling is preferable
     *      -> Classes coupled to lots of other classes are harder to write and test in isolation
     *      -> High coupling may indicate that a class has been split when it shouldn't have been
     *
     * Coupling is concerned with how dependent other classes are on others
     * Single biggest influence of on system's understandability
     *
     * Spectrum:
     *
     * None  Object Data  Stamp   Control  External     Common     Content
     * <------------------------------------------------------------------->
     * Independent                                                     Needy
     *
     *
     *
     * Types:
     * 1. Data
     *      -> Sharing of data through means such as parameter passing in methods
     * 2. Stamp
     *      -> Sharing a data structure, but each class only needs to access a select part of it
     * 3. Control
     *      -> One class is controlling what happens in another class by passing it information/ instructions
     * 4. External
     *      -> Sharing something imposed by an external source e.g. data format
     * 5. Common:
     *      -> Sharing access to the same global data/ variable
     * 6. Content:
     *      -> One class directly manipulates data in another class (e.g. varriables
     *
     */
    public static void coupling() {
        System.out.println("See documentation");
    }

    /**
     * Target of a message (invoke methods) can only be one of the following objects
     *      -> The method's object (this)
     *      -> Object that was passed as a parameter
     *      -> Object referred to by an attribute of an object
     *          - Week form of law allows sending messages to objects within a collection
     *      -> Object created by the method
     *      -> Object referred to by a global variable
     *
     * Intent is to reduce coupling
     *      - An object should avoid invoking methods objects returned by another method
     *
     * In other words:
     *
     * A method can call other methods in its own class.
     * A method can call methods on its class data members
     *      - but not on the data member's, members
     * A method can call methods on its parameters
     * If a method creates an object, it can call methods on that object.
     *
     * Avoid chained messages
     */
    public static void lawOfDemeter(){

    }

    /**
     * A class should decide its own destiny
     *
     * It should restrict other classes from accessing its state:
     * - Data members should be private
     * - You should limit accessor methods
     *
     * A class with many accessor methods risk becoming mindless
     *
     * Mindless classes tend to have low cohesion and promote high coupling.
     */
    public class mindlessClasses {
        private int randomVariable1;
        private int randomVariable2;
        public mindlessClasses (int randomVariable1, int randomVariable2) {
            this.randomVariable1 = randomVariable1;
            this.randomVariable2 = randomVariable2;
        }

        public void setRandomVariable1(int randomVariable1) {
            this.randomVariable1 = randomVariable1;
        }

        public void setRandomVariable2(int randomVariable2) {
            this.randomVariable2 = randomVariable2;
        }
    }

    /**
     * God classes:
     *
     * Do everything within there context
     *
     * Highly coupled to other classes in their context
     *
     * Have low cohesion as they do many things
     *
     * @return The answer
     */
    public static String  getIsThisAGodClass () {
        return "This is definitely a God class as it does a whole bunch of random unconnected things";
    }

    /**
     * A class should only depend on the public interface of another class.
     *
     * Attributes and their related methods, should belong to one class.
     * - Frequency violated that have many public accessor methods (get, set)
     *
     * A class should represent a single logical concept
     * - Unrelated information should be factored out to another class e.g. when a subset of methods operates
     * on a proper subset of attributes
     *
     * System logic should be distributed as a uniformly as possible, classes share work as uniformly as possible.
     */
    public static void moreCohesionAndCoupling() {
        System.out.println("Refer to documentation");
    }

    /**
     * Does changing the super class affect its subclasses:
     * -> private - shouldn't
     * -> protected data - if used directly
     * -> public or protected methods - if specification changes
     *      - used in subclass
     *             - consider super() as well as direct method calls
     *      - overriden in subclass
     *      - concept super class represents changes
     *              - no longer suitable to be super class
     *
     * Another impact of coupling
     *
     */
    public static void fragileSuperClassExplainer() {
        System.out.println("Refer to documentation");
    }

    /**
     * Classes should be highly cohesive -> Single, easily understood concept
     *
     * Classes should have low dependency (coupling) on each other -> reduce system complexity
     *
     * Design is king -> If you don't design well, YOU WILL LOOK LIKE A GEEZER
     */
    public static void classDesign() {
        System.out.println("Refer to documentation");
    }

    /**
     * GUI Design Principles:
     * -> Each GUI class should be a cohesive concept
     * -> Should restrict coupling between the GUI and the program logic
     *
     * Model/ View Separation:
     *      Model:
     *      -> Represents an entity in the system
     *      -> Stores states
     *      -> Has invariants
     *      -> Has methods to enforce the invariants
     *      View:
     *      -> A presentation of the state and (usually a way ti interact with it)
     * Why?
     * -> Decompose the task
     * -> May want to be able to change the interface
     *      - Model only cares that a method is called not which objects are involved
     * -> You might want to support multiple interfaces
     *      - Text, vocal, remote network, multiple access panels, ...
     * -> Responsibility for enforcing invariants should be in one place, not many.
     *      - Minimise duplicate code
     *
     * How?
     * 1. View and the model need to be able to communicate
     *      - Interface needs to be able to find current state
     * 2. which means calling methods
     * 3. which means they no each others type?
     * 4. so no flexibility?
     *      - How do we get around this apparent limitation?
     *
     * User of the interface needs to get information and issue commands - which ultimately affect the model
     * Interface needs to be aware if model has changed
     *
     * One way access i.e.
     *
     * model.doSomething();
     * ...
     * int data = model.getData1()
     *
     * Pros: Does not require the model to know about the view
     * Cons: Be careful about large systems from  a trivial example
     *
     *
     * Suppose the model can change out of step with the interface.
     * -Changes take time?
     * - Multiple interfaces are connected to the model
     * - Model reads info from the enviroment.
     *
     * Possible strategies:
     *
     * Polling:
     * - Has it changed yet?
     * - Generally frowned upon
     *
     * Callback/ Observers
     * - Model calls a method to notify something
     *
     *
     */
    public static void GUIDesignPrinciples () {
    }

    /**
     * Callback/observers
     *
     * Similar to the way GUI events are handled
     *
     * Reduces coupling because although the model needs a reference to another object,
     * it doesn’t need to know anything about it other than the fact it has a particular method
     *
     * Interface could then ask for all the information from the model, or could have details of what changed in a parameter.
     *
     * - Details will couple the interface to the model
     *
     * We are still assuming the model is small
     *      - Large model would require detailed change instructions.
     */
    interface ThingThatCares {
        public void itHappened( );
    }
    public class UserInterface implements ThingThatCares {
        @Override
        public void itHappened() {

        }
    }
    public static void runCounterMVExample() {
        Model model = new Model();
        View view = new View(model);
    }
}
