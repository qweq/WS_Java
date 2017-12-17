package was_case;

import java.util.InputMismatchException;

public class Grade {
    private int grade;

    Grade(int grade) {
        //try {
            if (grade < 1 || grade > 6) throw new IllegalArgumentException("Ocena musi być z zakresu 1-6.");
            this.grade = grade;
        //} catch (InputMismatchException e) {
        //    System.out.println("Ocena musi być liczbą naturalną.");
        //}
    }

    public int getGrade() {
        return grade;
    }

    public String toString() {
        return String.valueOf(grade);
    }
}
