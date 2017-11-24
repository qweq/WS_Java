package was3;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    private String name;
    private int age;
    private Breed breed;
    private boolean canSit;
    private boolean canFetch;
    private static int dogsCounter = 0; // "static" - tyczy się całej klasy Dog.java a nie konkretnego obiektu
    private static List<Dog> dogsCollection = new ArrayList<>();

    Dog(String name, int age, Breed breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.canSit = false;
        this.canFetch = false;
        System.out.println("Narodził się " + this.name + ".");
        dogsCounter++;
        dogsCollection.add(this);
    }

    public void Sit() {
        if (canSit) {
            System.out.println(this.name + " usiadł.");
        } else {
            System.out.println(this.name + " nie potrafi siadać.");
        }
    }

    public String Fetch() {
        if (canFetch) {
           return this.name + " zaaportował.";
        }
        return this.name + " nie potrafi aportować.";
    }

    public void learnSit() {
        this.canSit = true;
        System.out.println("Pies nauczył się siadać.");
    }

    public void learnFetch() {
        this.canFetch = true;
        System.out.println("Pies nauczył się aportować.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public static int getDogsCounter() {
        return dogsCounter;
    }

    public static List<Dog> getDogsCollection() {
        return dogsCollection;
    }

    public String toString() {
        return this.breed + " imieniem " + this.name + " ma " + this.age + " lat.";
    }
}
