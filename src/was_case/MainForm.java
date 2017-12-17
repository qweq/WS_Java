package was_case;

import was_case.enums.Subjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MainForm {
    private JPanel mainPanel;
    private JTabbedPane mainTabbedPane;
    private JPanel studentsPanel;
    private JPanel teachersPanel;
    private JPanel editPanel;
    private JComboBox studentNameCB;
    private JList studentGradesList;
    private JComboBox studentSubjectCB;
    private JButton studentShowMeanButton;
    private JLabel studentMeanLabel;
    private JComboBox teacherNameCB;
    private JTextField teacherSubjectTF;
    private JComboBox teacherStudentNameCB;
    private JLabel teacherStudentAvgLabel;
    private JLabel teacherAllAvgLabel;
    private JRadioButton studentRB;
    private JRadioButton teacherRB;
    private JTextField addNameTF;
    private JTextField teacherGradeTF;
    private JButton teacherGradeButton;
    private JComboBox addTeacherCB;
    private JButton addHumanButton;
    private JTextField addSurnameTF;
    private JComboBox addSubjectCB;
    private JScrollPane studentGradesScrollPane;
    private JTable addTeacherTable;

    public void init() {
        // populacja hard-code'owanych wartości
        for (int i = 0; i < Subjects.values().length; i++) {
            studentSubjectCB.addItem(Subjects.values()[i]);
            addSubjectCB.addItem(Subjects.values()[i]);
        }
        for (int i = 0; i < Student.getStudents().size(); i++) studentNameCB.addItem(Student.getStudents().get(i));
        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
            teacherNameCB.addItem(Teacher.getTeachers().get(i));
            addTeacherCB.addItem(Teacher.getTeachers().get(i));
        }

        studentNameCB.addActionListener(new studentNameCBActionListener());
        studentSubjectCB.addActionListener(new studentSubjectCBActionListener());
        studentShowMeanButton.addActionListener(new setStudentShowMeanButtonActionListener());
        addHumanButton.addActionListener(new addHumanButtonActionListener());
        studentRB.addActionListener(new studentRBActionListener());
        teacherRB.addActionListener(new teacherRBActionListener());
        teacherNameCB.addActionListener(new teacherNameCBActionListener());
        teacherGradeButton.addActionListener(new teacherGradeButtonActionListener());
        teacherStudentNameCB.addActionListener(new teacherStudentNameCBActionListener());

        ButtonGroup studentTeacher = new ButtonGroup();
        studentTeacher.add(studentRB);
        studentTeacher.add(teacherRB);
    }

    private class addHumanButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = addNameTF.getText();
            String surname = addSurnameTF.getText();

            if (studentRB.isSelected()) {
                Teacher teacher = new Teacher();
                for (int i = 0; i < Teacher.getTeachers().size(); i++) {
                    teacher = (Teacher) addTeacherCB.getSelectedItem();
                    if (Teacher.getTeachers().get(i).getTeacherID() == teacher.getTeacherID()) {
                        teacher = Teacher.getTeachers().get(i);
                    }
                }
                Student student = new Student(name, surname);
                student.assignTeacher(teacher);
                studentNameCB.addItem(student.getFullName());
            } else if (teacherRB.isSelected()) {
                Subjects subject = (Subjects)addSubjectCB.getSelectedItem();
                Teacher teacher = new Teacher(name, surname, subject);
                teacherNameCB.addItem(teacher);
                addTeacherCB.addItem(teacher);
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Wybierz, czy chcesz dodać ucznia, czy nauczyciela", "Błąd", JOptionPane.WARNING_MESSAGE);
            }

            addNameTF.setText("");
            addSurnameTF.setText("");
        }
    }

    private class studentRBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addNameTF.setEnabled(true);
            addSurnameTF.setEnabled(true);
            addTeacherCB.setEnabled(true);
            addSubjectCB.setEnabled(false);
        }
    }

    private class teacherRBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addNameTF.setEnabled(true);
            addSurnameTF.setEnabled(true);
            addSubjectCB.setEnabled(true);
            addTeacherCB.setEnabled(false);
        }
    }

    private class teacherNameCBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Teacher selectedTeacher = (Teacher)teacherNameCB.getSelectedItem();
            teacherSubjectTF.setText(selectedTeacher.getSubject().name());
            teacherStudentNameCB.removeAllItems();
            for (int i = 0; i < selectedTeacher.getAssignedStudents().size(); i++) {
                teacherStudentNameCB.addItem(selectedTeacher.getAssignedStudents().get(i));
            }
            updateMean(teacherAllAvgLabel, selectedTeacher);
            teacherAllAvgLabel.setVisible(true);
            teacherGradeButton.setEnabled(true);
        }
    }

    private class teacherGradeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Student student = (Student)teacherStudentNameCB.getSelectedItem();
                Teacher teacher = (Teacher)teacherNameCB.getSelectedItem();
                Grade grade = new Grade(Integer.parseInt(teacherGradeTF.getText()));
                teacher.gradeStudent(student, grade);
                updateMean(teacherAllAvgLabel, teacher);
            } catch (IllegalArgumentException ae) {
                JOptionPane.showMessageDialog(mainPanel, "Ocena musi być liczbą naturalną z zakresu 1-6", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
            teacherGradeTF.setText("");
        }
    }

    private class teacherStudentNameCBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = (Student)teacherStudentNameCB.getSelectedItem();
            try {
                updateMean(teacherStudentAvgLabel, student);
                teacherStudentAvgLabel.setVisible(true);
            } catch (NullPointerException ne) {
                teacherStudentAvgLabel.setText("0");
                teacherStudentAvgLabel.setVisible(true);
            }
        }
    }

    private void updateMean(JLabel targetLabel, Human targetHuman) {
        targetLabel.setText(String.format("%.3g%n", targetHuman.getMean()));
    }

    private void updateMean(JLabel targetLabel, Student student, Subjects subject) {
        targetLabel.setText(String.format("%.3g%n", student.getMean(subject)));
    }

    private class studentNameCBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Subjects selectedSubject = (Subjects)studentSubjectCB.getSelectedItem();
            Student selectedStudent = (Student)studentNameCB.getSelectedItem();
            populateGradesList(selectedStudent, selectedSubject);
        }
    }

    private class studentSubjectCBActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Subjects selectedSubject = (Subjects)studentSubjectCB.getSelectedItem();
            Student selectedStudent = (Student)studentNameCB.getSelectedItem();
            populateGradesList(selectedStudent, selectedSubject);
        }
    }

    private void populateGradesList(Student student, Subjects subject) {
        List<Grade> bufferList = student.getGradesBySubject(subject);
        DefaultListModel listModel = new DefaultListModel<>();
        studentGradesList.removeAll();

        for (int i = 0; i < bufferList.size(); i++) {
            listModel.addElement(bufferList.get(i));
        }

        if (listModel.isEmpty()) studentShowMeanButton.setEnabled(false);
        else studentShowMeanButton.setEnabled(true);

        studentGradesList.setModel(listModel);
    }

    private class setStudentShowMeanButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateMean(studentMeanLabel, (Student)studentNameCB.getSelectedItem(), (Subjects)studentSubjectCB.getSelectedItem());
            studentMeanLabel.setVisible(true);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
