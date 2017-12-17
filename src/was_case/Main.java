package was_case;

import was_case.enums.Subjects;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // przykładowi studenci i nauczyciele
        Teacher t1 = new Teacher("Alicja", "Antonowska", Subjects.GEOGRAPHY);
        Teacher t2 = new Teacher("Barbara", "Bębenek", Subjects.POLISH);
        Teacher t3 = new Teacher("Czesław", "Constantowski", Subjects.MATHS);
        Teacher t4 = new Teacher("Danuta", "Dominatorska", Subjects.PHYSICS);

        Student s1 = new Student("Ela", "Elenonorowska", t1, t2, t3);
        Student s2 = new Student("Fabian", "Fabicki", t2, t3);
        Student s3 = new Student("Gaweł", "Grażyński", t1, t2, t3, t4);

        t1.gradeStudent(t1.getAssignedStudents().get(0), new Grade(4));
        t1.gradeStudent(t1.getAssignedStudents().get(0), new Grade(3));
        t1.gradeStudent(t1.getAssignedStudents().get(0), new Grade(5));
        t1.gradeStudent(t1.getAssignedStudents().get(0), new Grade(2));

        t2.gradeStudent(t2.getAssignedStudents().get(0), new Grade(3));
        t2.gradeStudent(t2.getAssignedStudents().get(1), new Grade(5));
        t2.gradeStudent(t2.getAssignedStudents().get(2), new Grade(6));
        t3.gradeStudent(t3.getAssignedStudents().get(0), new Grade(3));
        t3.gradeStudent(t3.getAssignedStudents().get(1), new Grade(1));
        t3.gradeStudent(t3.getAssignedStudents().get(2), new Grade(6));
        t4.gradeStudent(t4.getAssignedStudents().get(0), new Grade(2));

        JFrame mainFrame = new JFrame();
        MainForm mainForm = new MainForm();

        mainFrame.setContentPane(mainForm.getMainPanel());
        mainFrame.pack();
        mainForm.init();
        mainFrame.setVisible(true);

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
