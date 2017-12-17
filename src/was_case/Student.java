package was_case;

import was_case.enums.Subjects;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human {
    private List<Grade> gradesMaths = new ArrayList<>();
    private List<Grade> gradesPolish = new ArrayList<>();
    private List<Grade> gradesPhysics = new ArrayList<>();
    private List<Grade> gradesGeography = new ArrayList<>();
    private List<Teacher> assignedTeachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static int currentMaxID = 0;
    private int studentID;

    Student(String name, String surname) {
        super(name, surname);
        this.studentID = currentMaxID + 1;
        currentMaxID++;
        students.add(this);
    }

    Student(String name, String surname, Teacher... teacher) {
        this(name, surname);
        for (int i = 0; i < teacher.length; i++) assignTeacher(teacher[i]);
    }

    public void addGrade(Grade grade, Subjects subject) {
        switch (subject) {
            case MATHS:
                gradesMaths.add(grade);
                break;
            case POLISH:
                gradesPolish.add(grade);
                break;
            case PHYSICS:
                gradesPhysics.add(grade);
                break;
            case GEOGRAPHY:
                gradesGeography.add(grade);
                break;
        }
    }

    public void assignTeacher(Teacher teacher) {
        teacher.addStudent(this);
        assignedTeachers.add(teacher);
    }

    public double getMean() {
        List<Grade> bufferList;
        double sum = 0.0;
        int count = 0;

        for (int i = 0; i < Subjects.values().length; i++) {
            bufferList = getGradesBySubject(Subjects.values()[i]);
            if (bufferList != null) {
                for (int j = 0; j < bufferList.size(); j++) {
                    sum += (double) bufferList.get(j).getGrade();
                    count++;
                }
            }
        }

        if (count != 0) return sum/count;
        else return 0;
    }

    public double getMean(Subjects subject) {
        List<Grade> bufferList = getGradesBySubject(subject);
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < bufferList.size(); i++) {
            sum += (double)bufferList.get(i).getGrade();
            count++;
        }

        if (count != 0) return sum/count;
        else return 0;
    }

    public List<Grade> getGradesMaths() {
        return gradesMaths;
    }

    public List<Grade> getGradesPolish() {
        return gradesPolish;
    }

    public List<Grade> getGradesPhysics() {
        return gradesPhysics;
    }

    public List<Grade> getGradesGeography() {
        return gradesGeography;
    }

    public List<Grade> getGradesBySubject(Subjects subject) {
        switch (subject) {
            case MATHS:
                return this.gradesMaths;
            case POLISH:
                return this.gradesPolish;
            case PHYSICS:
                return this.gradesPhysics;
            case GEOGRAPHY:
                return this.gradesGeography;
        }
        return null;
    }

    public List<Teacher> getAssignedTeachers() {
        return assignedTeachers;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }
}
