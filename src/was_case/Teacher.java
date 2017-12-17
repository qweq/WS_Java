package was_case;

import was_case.enums.Subjects;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human {
    private Subjects subject;
    private List<Student> assignedStudents = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static int currentMaxID = 0;
    private int teacherID;

    Teacher() {}

    Teacher(String name, String surname, Subjects subject) {
        super(name, surname);
        this.subject = subject;
        this.teacherID = currentMaxID + 1;
        currentMaxID++;
        teachers.add(this);
    }

    public void gradeStudent(Student student, Grade grade) {
        for (int i = 0; i < assignedStudents.size(); i++) {
            if (assignedStudents.get(i).getStudentID() == student.getStudentID()) {
                student.addGrade(grade, this.subject);
                break;
            }
        }
    }

    public double getMean() {
        List<Grade> bufferList;
        double sum = 0.0;
        int count = 0;

        for (int i = 0; i < assignedStudents.size(); i++) {
            bufferList = assignedStudents.get(i).getGradesBySubject(this.subject);
            for (int j = 0; j < bufferList.size(); j++) {
                sum += (double) bufferList.get(j).getGrade();
                count++;
            }
        }

        return sum/count;
    }

    public void addStudent(Student student) {
        assignedStudents.add(student);
    }

    public Subjects getSubject() {
        return subject;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }
}