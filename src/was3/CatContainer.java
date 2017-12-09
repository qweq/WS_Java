package was3;

import java.util.ArrayList;
import java.util.List;

public class CatContainer {
    private List<Cat> catList = new ArrayList<>();

    CatContainer() {}

    public void addCat(String name, int age, double weight) {
        if (name != null && age > 0 && weight > 0) {
            catList.add(new Cat(name, age, weight));
        }
        else {
            System.out.println("Niepoprawne dane.");
        }
    }

    public List<Cat> getCatList() {
        return catList;
    }

    private class Cat extends Animal {

        Cat() {
            super();
        }

        Cat(String name, int age, double weight) {
            super(name, age, weight);
        }

        @Override
        public void makeSound() {
            System.out.println(super.getName() + ": miau");
        }
    }
}
