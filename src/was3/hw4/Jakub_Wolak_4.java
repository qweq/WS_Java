package was3.hw4;

public class Jakub_Wolak_4 {
    public static void main(String[] args) {
        Student st1 = new Student("Arkadiusz", "Aksiński", 81062201459L, Major.AIR);
        Student st2 = new Student("Barbara", "Basińska", 95122812505L, Major.LIK);
        Student st3 = new Student("Cecylia", "Cwir", 98090617800L);
        Student st4 = new Student("Dariusz", "Dąbrowski", 94080602230L);
        Student st5 = new Student("Euzebiusz", "Eksowski", 83071014556L);
        Student st6 = new Student("Felicjan", "Fabiański", 82012510157L);
        Student st7 = new Student("Grażyna", "German", 87040201185L);
        Student st8 = new Student("Halyna", "Hajto", 98070918527L);
        Student st9 = new Student("Ion", "Tudorescu", 92010812113L);
        Student st10 = new Student("Jan", "Jankowski", 93122618855L);

        Student st11 = new Student("Zenek", "Złośliwy", 123L);
        Student st12 = new Student(null, null, 0);
        Student st13 = new Student("Henryk", "Huncwot", 94080602230L); // ten sam pesel co u Dariusza Dąbrowskiego

        Supervisor sv1 = new Supervisor("Janusz", "Narkiewicz", 56070616135L);
        Supervisor sv2 = new Supervisor("Jacek", "Rokicki", 70081409779L);
        Supervisor sv3 = new Supervisor("Jacek", "Szumbarski", 54012205452L);
        System.out.println("");

        // zapisywanie na kierunek
        System.out.println("zapisywanie na kierunek");
        st4.setMajor(Major.LIK);
        System.out.println("");

        // toString
        System.out.println("toString");
        System.out.println(st3);
        System.out.println(sv2);
        System.out.println("");

        // test walidacji
        System.out.println("test walidacji");
        st11.setSupervisor(sv3);    // zły pesel
        st12.setSupervisor();       // null-e w imieniu i nazwisku, zły pesel
        st13.setSupervisor(sv1, sv2);   // nieunikalny pesel
        System.out.println("");

        // zapisywanie do pojedynczego promotora
        System.out.println("zapisywanie do pojedynczego promotora");
        st1.setSupervisor(sv1);
        st2.setSupervisor(sv1);
        st3.setSupervisor(sv1);
        st4.setSupervisor(sv1); // ta osoba nie zostanie już zapisana - max 3
        System.out.println("");

        // zapisywanie do promotora pierwszego lub drugiego wyboru
        System.out.println("zapisywanie do promotora pierwszego lub drugiego wyboru");
        st4.setSupervisor(sv1, sv2); // Dariusz Dąbrowski ma ten sam pesel co Henryk Huncwot
        st5.setSupervisor(sv2);
        st6.setSupervisor(sv2);
        st7.setSupervisor(sv2);
        st7.setSupervisor(sv1, sv3);
        System.out.println("");

        // pokazywanie niezapisanych studentów i studentów zapisanych do konkretnego promotora
        System.out.println("pokazywanie niezapisanych studentów i studentów zapisanych do konkretnego promotora");
        Student.getUnassignedStudents();
        System.out.println("");
        Student.getStudentsAssignedTo(sv1);
        Student.getStudentsAssignedTo(sv2);
        System.out.println("");

        // zapisywanie do wolnego promotora
        System.out.println("zapisywanie do wolnego promotora");
        st1.setSupervisor(); // jeśli student jest już zapisany do promotora to metoda zwraca stosowny komunikat i nie zapisuje do żadnego innego
        st8.setSupervisor();
        System.out.println("");

        // masowe zapisywanie studentów
        System.out.println("masowe zapisywanie studentów");
        Student.assignAllStudents();
        System.out.println("");

        // wypisywanie studentów zapisanych do konkretnego promotora - raz jeszcze ale inaczej
        System.out.println("wypisywanie studentów zapisanych do konkretnego promotora - raz jeszcze ale inaczej");
        System.out.println(sv1.getAssignedStudents()); // metoda klasy Supervisor
        System.out.println(sv2.getAssignedStudents());
        System.out.println(sv3.getAssignedStudents());
    }
}
