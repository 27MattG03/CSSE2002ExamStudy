package week4;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Testing procedures:
 * -> Unit testing: testing individual methods
 * -> Integration testing: testing how components work together
 * -> System testing: testing the whole system
 * -> Acceptance testing: testing the system against the requirements
 *
 * Test framework:
 * -> xUnit  is a family of unit testing frameworks
 *
 * Black box testing:
 * -> Test the system without knowing how it works
 *
 * White box testing:
 * -> Testing designed with knowledge of how the system works
 * -> Means tests can pay special attention to cases where the implementation is complicated.
 * -> Code coverage can become important here.
 *
 * Test driven development:
 * -> Write tests before writing code
 *
 *
 * Note:
 * • Not the same as blindly hacking at code until the tests pass
 * • You still need to think
 * • Writing the tests is meant to make you think about how to design the code
 * • If you find a bug which your tests do not detect, add a test which does.
 * • Assumes you (or other programmers) are involved in writing tests. TDD does not mean outsourcing your thinking.
 *
 * Tests should cover:
 * • cover the input possibilities/features
 * • ideally help to identify problems
 * • not be orders of magnitude bigger than needed
 *
 * Common things to check:
 * • Boundary cases
 *       • 0 for numerical values
 *       • empty sets/lists/arrays
 *       • null values
 *       • NaN
 * • Negative numbers
 * • Very large numbers/values
 * • Inputs that cant be divided cleanly
 * • Names of non-existent resources
 * • Extant but non-permitted resources
 * • Anything you think will throw an exception
 * • Things that work
 *
 *
 *
 * Coverage:
 * • How much of the code is executed by the tests
 * • Of all the different ways your program could run, how many
 * are covered by your tests?
 * • Of course, we’d like to not do more testing than we need to
 *
 * Three levels of coverage:
 * • Statement coverage
 *      • Have all the statements been executed?
 * • Branch coverage
 *     • Have all the branches been executed?
 * • Path coverage
 *    • Have all the paths been executed?
 **/

public class week4Test {
    private week4 example;

    /**
     * The @Before tag indicates that this method should be run before each test.
     */
    @Before
    public void setUp() {
        example = new week4();
    }

    /**
     * This is a test method. It should test the behaviour of a method in your class.
     */
    @org.junit.Test
    public void testHelloWorld() {
        assertEquals("Hello world!", example.helloWorld());
        assertTrue(example.helloWorld().equals("Hello world!"));
    }

    /**
     * AssertNotSame checks that two objects are not the same object.
     */
    @org.junit.Test
    public void testS1S2 (){
        assertNotSame(example.getS1(),example.getS2());
    }
    /**
     * AssertArrayEquals checks that two arrays are equal.
     * It does not check that they are the same array.
     */
    @org.junit.Test
    public void testArrayExample(){
        assertArrayEquals(example.arrayExample(), new int[]{1, 2, 0, 0, 0});
    }

    @org.junit.Test (expected = Exception.class)
    public void testException() throws Exception {
        example.throwsException();
    }

    /**
     * The @After tag indicates that this method should be run after each test.
     */
    @After
    public void tearDown() {
        System.out.println("Test complete");
    }
}