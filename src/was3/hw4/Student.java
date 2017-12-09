package was3.hw4;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private static List<Student> students = new ArrayList<>();
    private Major major;
    private Supervisor supervisor;

    Student(String name, String surname, long pesel, Major major, Supervisor supervisor) {
        super(name, surname, pesel);
        this.major = major;
        this.supervisor = supervisor;
        students.add(this);
        System.out.println("W systemie pojawił się student " + this.getFullName()
                + " (PESEL: " + this.getPesel() + ").");
    }

    Student(String name, String surname, long pesel, Major major) {
        this(name, surname, pesel, major, null);
    }

    Student(String name, String surname, long pesel) {
        this(name, surname, pesel, null);
    }

    public boolean isPeselUnique() {
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (this.getPesel() == students.get(i).getPesel()) count++;
        }
        if (count == 1) return true;
        return false;
    }

    public boolean validate() {
        if (this.getName() == null ||
            this.getSurname() == null ||
            this.getPesel() < 10000000000L ||
            this.getPesel() > 100000000000L ||
            this.isPeselUnique() == false) return false;
        return true;
    }

    public static void getUnassignedStudents() {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).supervisor == null) {
                System.out.println("Student " + students.get(i).getName() + " " + students.get(i).getSurname()
                        + " nie ma jeszcze przypisanego promotora.");
            }
        }
    }

    public static void getStudentsAssignedTo(Supervisor s) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).supervisor == s) {
                System.out.println("Student " + students.get(i).getName() + " " + students.get(i).getSurname()
                        + " jest zapisany do promotora " + s.getName() + " " + s.getSurname() + ".");
            }
        }
    }

    // zapis do konkretnego promotora
    public void setSupervisor(Supervisor supervisor) {
        if (this.supervisor == null) { // jeśli jeszcze żaden promotor nie jest przypisany
            if (supervisor.getAssignedStudents().size() < supervisor.getMAX_STUDENT_COUNT()) { // jeśli u promotora jest mniej studentów niż wynosi limit
                if (supervisor.addStudent(this)) this.supervisor = supervisor;  // jeśli addStudent zwróci "true" => student przejdzie walidację
                                                                                // to dopiero wtedy ustaw promotora
            } else {
                System.out.println("U tego promotora nie ma już wolnych miejsc - wybierz innego.");
            }
        } else { // jakby się zdarzyło że złośliwy użytkownik próbuje drugi raz przypisać promotora, bądź po prostu go zmienić
            this.supervisor.removeStudent(this); // żeby nie było zdublowanych wpisów
            this.supervisor = null;
            setSupervisor(supervisor); // powtórz procedurę
        }
    }

    // zapis do promotora z alternatywą
    public void setSupervisor(Supervisor svFirst, Supervisor svSecond) {
        if (this.supervisor == null) { // jeśli nic nie jest przypisane
            if (svFirst.getAssignedStudents().size() < svFirst.getMAX_STUDENT_COUNT()) {
                setSupervisor(svFirst);
            } else if (svSecond.getAssignedStudents().size() < svSecond.getMAX_STUDENT_COUNT()) {
                setSupervisor(svSecond);
            } else {
                System.out.println("U podanych promotorów nie ma już wolnych miejsc.");
            }
        } else {
            this.supervisor.removeStudent(this);
            this.supervisor = null;
            setSupervisor(svFirst, svSecond);
        }
    }

    // zapis do pierwszego wolnego promotora
    public void setSupervisor() {
        Supervisor s;

        if (this.supervisor == null) {
            // iteruj po wszystkich promotorach
            for (int i = 0; i < Supervisor.getSupervisors().size(); i++) {
                s = Supervisor.getSupervisors().get(i);
                if (s.getAssignedStudents().size() < s.getMAX_STUDENT_COUNT()) {
                    setSupervisor(s);
                    break; // wyjdź z ifa jeśli znajdziesz wolnego promotora
                }
            }
        } else {
            System.out.println("Student " + getFullName() + " jest już zapisany do promotora!");
            // wychodzę z założenia że jeśli ktoś już jest zapisany do promotora, to chciałby zmienić na konkretnego
            // a nie "pierwszego wolnego", stąd inne zachowanie tej metody w stosunku do poprzednich
            // w przeciwnym razie metoda ta wypisuje od promotora, po czym przypisuje do tego samego, bo są już u niego wolne miejsca
        }

        // jeśli po tym wszystkim wciąż nie ma promotora
        if (this.supervisor == null) {
            System.out.println("Nie udało się zapisać studenta " + this.getFullName() + " do żadnego promotora.");
        }
    }

    public static void assignAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSupervisor() == null) {
                students.get(i).setSupervisor();
            }
        }
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
        System.out.println("Student " + this.getFullName() + " zapisał się na kierunek " + this.major);
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Student " + this.getFullName() + " (PESEL: " + this.getPesel() + ")";
    }
}