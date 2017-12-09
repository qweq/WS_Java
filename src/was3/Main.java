package was3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Animal a = new Animal();
        //System.out.println(a);

        Dog d = new Dog("Fred", 4, 7.0, Breed.GOLDEN);
        System.out.println(d);

        d.makeSound();

        /*List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                animals.add(new Dog("pies"+i, i, (double)i, Breed.GOLDEN));
            }
            else {
                animals.add(new Cat("kot"+i,i,(double)i));
            }
        }*/



        System.out.println(Animal.getAnimalList().size());

        for (Animal a:Animal.getAnimalList()) {
            if (a instanceof Dog) {
                System.out.println("Jestem psem");
            }
        }

        CatContainer catContainer = new CatContainer();
        catContainer.addCat("Mruczek", 3, 5.4);

        for (int i = 0; i <= 30; i++) {
            if (i % 2 == 0) {
                catContainer.addCat("kot" + i, (int)(Math.random() * 11 - 3), (double)(Math.random() * 15 - 5));
            } else {
                Dog b = new Dog("pies" + i, i, (double)i, Breed.GOLDEN);
            }
        }

        //System.out.println(CatContainer.getCatList());
    }
}
