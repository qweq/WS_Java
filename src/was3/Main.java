package was3;

public class Main {
    public static void main(String[] args) {

        /*Punkt punkt = new Punkt(2);
        Punkt punkt1 = new Punkt(4, 6);

        System.out.println(punkt.getX() + "\t" + punkt.getY());
        System.out.println(punkt1.getX() + "\t" + punkt1.getY());*/

        Dog regis = new Dog("Regis", 3, Breed.GOLDEN);
        System.out.println(regis);
        regis.setName("Lama");
        System.out.println(regis);

        regis.Sit();
        regis.learnSit();
        regis.Sit();

        System.out.println(regis.Fetch());
        regis.learnFetch();
        System.out.println(regis.Fetch());

        Dog frugo = new Dog("Frugo", 1, Breed.GOLDEN);
        Dog mopsik = new Dog("Sliniak", 10, Breed.PUG);
        //System.out.println("Istnieje tyle psów: " + Dog.getDogsCounter());
        System.out.println("Istnieje tyle psów: " + Dog.getDogsCollection().size());

        for (Dog d : Dog.getDogsCollection()) {
            if (d.getBreed() == Breed.GOLDEN) System.out.println("Znaleziono goldena " + d.getName());
            if (d.getBreed() == Breed.PUG) System.out.println("Znaleziono mopsa " + d.getName());
            if (d.getBreed() == Breed.DACHSHUND) System.out.println("Znaleziono jamnika " + d.getName());
        }
    }
}
