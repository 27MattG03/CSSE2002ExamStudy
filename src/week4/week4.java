package week4;

import java.util.*;

public class week4 {
    String s1 = "Hello World!";
    String s2 = "Hello ";
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * Lists hold items in sequential order, much like an array
     *      -> Grow and shrink automatically
     *      -> No fixed size limit
     *      -> Walk along list
     *      -> Insert an item anywhere in the list
     *      -> Remove an item anywhere in the list
     *      -> Is item in the list?
     *
     * List is a type of interface, hence cannot be instantiated.
     * -> LinkedList is a type of list best for ops that involve adding/removing items from the middle of the list.
     * -> ArrayList is a type of list best for ops that involve random access to items in the list.
     * -> Vector is a type of list used mostly for protecting against concurrency issues.
     */
    public void listExample() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.get(2); // returns "!"
        list.remove(1); // removes "World"
        list.size(); // returns 2
        list.contains("Hello"); // returns true
        list.indexOf("Hello"); // returns 0
        list.set(0, "Goodbye"); // replaces "Hello" with "Goodbye"
        list.clear(); // removes all items from the list
    }

    /**
     * Iterators are a more flexible way to move through a collection than a for each loop.
     * An iterator refers to a position/item in a collection without needing to use an index number.
     * Modifying one iterator, and then trying to use an older iterator, fails fast.
     *
     * Iterator is a type of interface, hence cannot be instantiated.
     * -> ListIterator is a type of iterator that allows you to move in both directions through a list.
     * -> Collection objects create and return an iterator to access their items.
     */
    public void iteratorExample() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        //List iterators can also move backwards through a list.
        while (iterator.hasPrevious()) {
            String item = iterator.previous();
            System.out.println(item);
        }
    }

    /**
     * Sets hold items in an unordered collection.
     *     -> No duplicates
     *     -> No fixed size limit
     * You can:
     *    -> Add an item to the set
     *    -> Remove an item from the set
     *    -> Is item in the set?
     *    -> Iterate through the set (don't assume order)
     * Types of sets:
     *   -> HashSet<E> — E needs to have sensible hashCode() and equals()
     *   -> TreeSet<E> — E needs to implement Comparable<E>
     */
    public void setExample () {
        // HashSet
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("!");
        set.add("Hello"); // ignored
        set.remove("World");
        set.contains("Hello"); // returns true
        set.size(); // returns 2
        // TreeSet
        Set<String> set2 = new TreeSet<>();
        set2.add("Hello");
        set2.add("World");
        set2.add("!");
        set2.add("Hello"); // ignored
        set2.remove("World");
        set2.contains("Hello"); // returns true
        set2.size(); // returns 2
    }

    /**
     * Maps store key/value pairs
     * Need to specifiy the types of the key and value
     * e.g. Map<String, Integer>
     *
     * Difference between a HashMap and a TreeMap:
     * Both HashMap and TreeMap are implementations of the Map interface in Java, which allows us to store key-
     * value pairs. The main difference between HashMap and TreeMap is how they store and organize their elements.
     *
     * HashMap is implemented as a hash table, which means it uses hash codes to organize and retrieve elements.
     * When we put an element in a HashMap, Java calculates its hash code and uses it as a key to store the
     * element in an array-like structure. Retrieving an element from a HashMap is typically faster than from a TreeMap,
     * as it involves a simple lookup based on the hash code.
     *
     * On the other hand, TreeMap is implemented as a red-black tree,
     * which means it keeps its elements sorted in ascending order based on their keys.
     * Retrieving an element from a TreeMap involves traversing the tree structure, which takes longer than
     * a simple lookup in a HashMap. However, TreeMap offers additional functionality not available in HashMap,
     * such as iterating over the elements in sorted order and finding elements within a specific range of keys.
     *
     * In summary, the main difference between HashMap and TreeMap is their underlying data structures and their
     * performance characteristics for different operations. HashMap is generally faster for basic operations like
     * put, get, and remove, while TreeMap offers additional functionality like iteration in sorted order and range queries.
     */
    public void mapExample () {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Hello");
        map.put(2, "World");
        map.put(3, "!");
        map.put(1, "Goodbye"); // replaces "Hello"
        map.remove(2);
        map.containsKey(1); // returns true
        map.containsValue("Hello"); // returns false
        map.size(); // returns 2
        map.get(1); // returns "Goodbye"
        map.keySet(); // returns a Set of all the keys
        map.values(); // returns a Collection of all the values
        map.entrySet(); // returns a Set of all the key/value pairs
    }
   public String helloWorld() {
        return "Hello world!";
    }
    public int[] arrayExample() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        return array; // returns [1, 2, 0, 0, 0]
    }
    public String getS1() {
        return s1;
    }
    public String getS2() {
        return s2;
    }
    public void throwsException () throws Exception{
        throw new Exception("This is an exception");
    }



}

