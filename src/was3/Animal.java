package was3;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private static List<Animal> animalList = new ArrayList<>();

    Animal() {
        this.name = "Max";
        this.age = 5;
        this.weight = 5.0;
        animalList.add(this);
    }

    Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        animalList.add(this);
        System.out.println("Narodził się " + this.name);
    }

    public void makeSound(){};

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static List<Animal> getAnimalList() {
        return animalList;
    }

    public String toString() {
        return this.name + " ma " + this.age + " lat";
    }
}
