package was3.hw4;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends User {
    private static List<Supervisor> supervisors = new ArrayList<>();
    private List<Student> assignedStudents = new ArrayList<>();
    private final int MAX_STUDENT_COUNT = 3;

    Supervisor(String name, String surname, long pesel) {
        super(name, surname, pesel);
        supervisors.add(this);
        System.out.println("W systemie pojawił się promotor " + this.getFullName()
                + " (PESEL: " + this.getPesel() + ").");
    }

    public static List<Supervisor> getSupervisors() {
        return supervisors;
    }

    public int getMAX_STUDENT_COUNT() {
        return MAX_STUDENT_COUNT;
    }

    public boolean addStudent(Student student) {
        // walidacja
        if (student.validate()) {
            assignedStudents.add(student);
            System.out.println("Promotorem studenta " + student.getFullName() + " stał się " + this.getName() + " " + this.getSurname() + ".");
            return true; // udało się zapisać
        } else {
            System.out.println("Niepoprawne dane studenta. Student " + student.getFullName() + " nie został zapisany do promotora.");
        }
        return false; // nie udało się zapisać
    }
    
    public void removeStudent(Student student) {
        for (int i = 0; i < assignedStudents.size(); i++) {
            if (assignedStudents.get(i) == student) {
                assignedStudents.remove(i);
                System.out.println("Student " + student.getFullName() + " został wypisany od promotora " + this.getFullName());
            }
        }
    }

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    @Override
    public String toString() {
        return "Promotor " + this.getFullName() + " (PESEL: " + this.getPesel() + ").";
    }
}
