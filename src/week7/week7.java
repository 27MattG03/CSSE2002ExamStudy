package week7;



import java.io.*;
import java.util.Scanner;

public class week7 {

    public static void main(String[] args) {
       week7 w = new week7();

       System.out.println("Hello world!");
       System.out.println(w.importDog());
    }

    /**
     * Characters are represented by numbers outside of when they are displayed.
     *
     * Encoding is the mapping between characters and numbers.
     *
     * ASCII was the dominant encoding scheme for a long time.
     *      -> 7 bits, 128 characters
     *
     * Unicode was created to support more characters.
     * Java uses Unicode.
     * No automatic way to translate between bytes and characters.
     */
    public void characterEncodingExample() {
        char c = 'a';
        int i = c;
        System.out.println(i);
        // 97
    }
    /**
     * Encoding data:
     * If data/objects are to be sent somewhere else (to a file, across a network, . . . ) they need to be encoded
     * 1. Binary
     *     -> Values expressed as bytes
     *     -> Often more compact than text
     *     -> Sensitive to system differences (e.g. endianness)
     *     -> Not human readable
     * 2. Text
     *    -> Values expressed as characters
     *        \
     *         -> Each character is ultimately encoded into binary in whatever medium it is stored/transported
     *    -> Human readable
     *    -> Parsing is more complex (need delimiters/escaping)
     *
     */
    public void encodingExample() {
        //Binary
        byte[] bytes = new byte[10];
        bytes[0] = 1;
        bytes[1] = 2;
        //Text
        String s = "Hello world!";
        //Text is encoded as binary
        byte[] bytes2 = s.getBytes();
        //Binary is decoded as text
        String s2 = new String(bytes2);
    }
    /**
     * Streams:
     * Useful abstractions for input:
     * -> Externally
     *      -> Origin? (e.g. file, network, keyboard, . . . )
     *      -> Chunking? Does it arrive one byte at a time (keyboard) , or in larger chunks (files) ?
     * -> Internally - Once we've set up an input source we dont want to code differently when using it
     *
     * An input stream is an abstract source of input that can be read without caring about the source.
     *
     * InputStream and its subclasses represent a stream of bytes. Subclasses draw bytes from different sources.
     *     -> FileInputStream - get bytes from a file
     *     -> ByteArrayInputStream - get bytes from a byte array
     *
     * All input streams need to consider EOF (end of file) - how do we know when we've reached the end of the stream?
     *    -> read() returns -1 when there is no more data to read
     *
     * BufferedInputStream - wraps another input stream and buffers the data
     *
     */
    public void inputStreamExample() {
        //Read from a file
        try {
            java.io.FileInputStream f = new java.io.FileInputStream("file.txt");
            int b = f.read();
            while (b != -1) {
                System.out.println(b);
                b = f.read();
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found");
        } catch (java.io.IOException e) {
            System.out.println("IO Exception");
        }
    }
    /**
     * Readers:
     * InputStreams are useful for reading bytes, but what if we want to read characters?
     *
     * Readers is a base class for getting characters from a stream.
     *
     * Readers is an abstract class, usefull subclasses:
     *    -> FileReader - get characters from a file
     *    -> InputStreamReader - get characters from an input stream
     *    -> BufferedReader - wraps another reader and buffers the data
     * Streams and readers need to be closed when we are done with them.
     * This is done by calling the close() method.
     *       -> this is because systems have limits on the number of open files/streams
     * Buffered readers wraps another reader adding read line along with buffering.
     */
    public void readerExample(Reader r1, Reader r2) throws IOException {
        BufferedReader br = new BufferedReader(r1);
        try {
            br.readLine();
        } catch (Exception e) {
            throw e;
        } finally {
            br.close(); // This can throw an IO Exception
        }
        // This is a better way to do it
        try (BufferedReader br2 = new BufferedReader(r2)) {
            br2.readLine();
        } catch (IOException e) {
            throw e;
        } // br2 is automatically closed here

        //Closing a stream/reader also closes the underlying stream/reader
        // Once constructed, we don't need to worry about their source

        FileReader fr = new FileReader("file.txt");
        //is equivalent to
        InputStreamReader isr = new InputStreamReader(new FileInputStream("file.txt"));
    }

    /**
     * Read Ints example from lecture
     */
    public class ReadInts {

        public static void fromScanner(InputStream is) {
            Scanner scan = new Scanner(is);
            /* We can just search for all the integers in the file one after
             * another */
            while (scan.hasNextInt()) {
                int i = scan.nextInt();
                System.out.println(i);
            }
        }

        public static void fromStrings(FileReader fr) {
            BufferedReader br = new BufferedReader(fr);
            /* We need to read the file line by line. The numbers in each
             * line have to be extracted */
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    /* extract the numbers from the line into an array. The space
                     * character is used as the delimiter */
                    String[] toks = line.split(" ");
                    for (String t : toks) {
                        try {
                            int i = Integer.parseInt(t); // convert string to int
                            System.out.println(i);
                        } catch (NumberFormatException nfe) {
                            System.out.println("That's not an integer");
                        }
                    }
                }
            } catch (IOException ioe) {
                System.out.println("Something went wrong");
            }
        }

        /* Read integers from a text file using two different methods */
        public static void main(String[] args) {

            System.out.println("Read integers using a Scanner:");
            try (FileInputStream fis = new FileInputStream("data/nums.txt")) {
                fromScanner(fis);
            } catch (FileNotFoundException fnf) {
                System.err.println("Couldn't find file");
            } catch (IOException ioe) {
                System.err.println("Something went wrong, probably while closing file");
            }


            System.out.println("\nRead integers by parsing strings read from file:");
            try (FileReader fr = new FileReader("data/nums.txt")) {
                fromStrings(fr);
            } catch (FileNotFoundException fnf) {
                System.err.println("Couldn't find file");
            } catch (IOException ioe) {
                System.err.println("Something went wrong, probably while closing file");
            }


        }
    }

    /**
     * Output Streams are for sending bytes.
     *
     * Output Streams are an abstract class, useful subclasses:
     *   -> FileOutputStream - send bytes to a file
     *   -> BufferedOutputStream - wraps another output stream and buffers the data
     *
     * Writers are for sending characters.
     * Writers is an abstract class, useful subclasses:
     *  -> FileWriter - send characters to a file
     *  -> BufferedWriter - wraps another writer and buffers the data
     */
    public static void out() {

        //System.out is an output stream of the type PrintStream providing the print methods.
        //Better option is print writer
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Hello world!");

        // If an OutputStream/Writer is buffered, output might not be sent immediately
        // We can force the buffer to be flushed using the flush() method
        // close() also flushes the buffer
        pw.flush(); //flush the buffer
        pw.close(); //close the stream

        // System.err is like System.out but for error messages or other output that doesn't go to the normal output
        // even though they often end up in the same place you can redirect them separately
        PrintWriter pw2 = new PrintWriter(System.err);
        pw2.println("This is an error message");
        pw2.close();
    }
    /**
     * ObjectInputStream and ObjectOutputStream allow I/O with java objects
     *   -> the objects must be serializable
     *   -> Any objects referenced by the object must also be serializable
     */
    public static void upload () {
        Dog d = new Dog("Teddy", 13, "Golden Retriever");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.txt"))) {
            oos.writeObject(d);
        } catch (IOException ioe) {
            System.out.println("Something went wrong");
        }
    }
    public static  String importDog() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("dog.txt"))) {
            Dog dog = (Dog) in.readObject();
            return dog.getName();
        } catch (IOException ioe) {
            System.out.println("Something went wrong");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Something went wrong");
        }
        return null;
    }


    /**
     * Parsing Text files
     *  -> Often want to convert from text format into java objects
     *  -> Text data comes into our program in the form of strings.
     *  -> We often need to:
     *        - Find delimiters (markers used as boundaries between fields)
     *        - Split strings across delimiters
     *        - Convert strings to other primitive types
     *        - Construct new objects based on paramaters read from the file
     * Some useful methods:
     * -> String.split(String regex) - splits a string into an array of strings
     * -> String.substring(int start, int end) - returns a substring of the string
     * -> String.indexOf(String str) - returns the index of the first occurrence of str in the string
     *
     * Regular expressions:
     * -> Powerful tool to search within a string
     * -> Patterns are defined that describe the search term
     *              -Sequence of charactes describing what to look for
     * -> Not covered in this course
     *
     * Converting strings to other types:
     * -> Integer.parseInt(String s) - converts a string to an int
     * -> Double.parseDouble(String s) - converts a string to a double
     * -> Boolean.parseBoolean(String s) - converts a string to a boolean
     * -> Float.parseFloat(String s) - converts a string to a float
     *
     * Number conversions throw a NumberFormatException if the string doesn't contain a valid number
     * Boolean conversion returns false if the string is not "true" (ignoring case)
     *
     * From text data to objects:
     * Different access can be used for constructing objects from I/O
     * 1. Constructor takes filename/reader as a parameter
     *        Good: Easy to use, Constructor has access to private members
     *        Bad: Class now has to deal with I/O exceptions
     * 2. Static method in the same class
     *       -> Same as above, except can also return null if something goes wrong
     * 3. static method in a different class
     *        Good: Provides "loose" coupling of class with I/O classes
     *              New classes/methods can be used to add formats
     *        Bad: No access to private members
     *             Needs access to constructors
     */
    public static void  textFileInfo() {
        System.out.println("Refer to documentation for more info");
    }

    /**
     * File  Operations:
     * Files - Not in the sense of their contents, but in the sense of the file system
     *    -What is a path separator? - The character used to separate directories in a path
     *    -How do I create a temporary file? - Use the createTempFile() method
     *    -Does a file with a given name exist? - Use the exists() method
     *    -What are the names of files in a directory? - Use the list() method
     * In java 1.7, a new file system API was introduced
     * java.nio.file.Path - Can do URIs other than just "file:///"
     * java.nio.file.Files - Can do more than just read/write files
     *
     *
     * java.nio.file.Files has only static members:
     * Some common methods:
     * -> boolean Files.exists(Path path) - returns true if the file exists
     * -> Path Files.createFile(Path path) - creates a new file
     * -> Path Files.createDirectory(Path path) - creates a new directory
     * -> Path Files.copy(Path source, Path target) - copies a file
     * -> Path Files.move(Path source, Path target) - moves a file
     * -> DirectoryStream<Path> Files.newDirectoryStream(Path dir) - returns a stream of paths in the directory
     */
    public static void fileOperations() {
        System.out.println("Refer to documentation for more info");
    }

    /**
     * Sometimes we need to exit a program early
     * We can return from main but a program has a return status (an integer) that can be used by a calling program.
     * The status is zero by default, if we need to set a status we can use the System.exit(int status) method
     */
    public void exit(){
        System.exit(1);
    }
}
