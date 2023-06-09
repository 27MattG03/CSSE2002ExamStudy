package week7;

import java.io.Serializable;

public final class Dog implements Serializable {
    private String name;
    private  int age;

    public String breed;

    public Dog (String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
