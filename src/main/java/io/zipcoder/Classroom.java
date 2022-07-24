package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Classroom {
    //instance variable
    private Student[] students;

    //Constructor
    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] student) {
        students = student;
    }

    public Classroom() {
        this(30);
    }

//methods

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) { //when there is no student in the classroom, add the student...
                students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i].getFirstName() == firstName && students[i].getLastName() == lastName) ; //removing student
            students[i] = null;
        }
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i] == null) {                  //reordering the array when removed is given null value.
                students[i] = students[i + 1];
            }
        }
    }

    public Student[] getStudentsByScore() {
        Student[] sort = Arrays.copyOf(students, students.length);
        Arrays.sort(sort); //sorts, need to reverse the list.

        //classroom could have null seats + we need to reverse the order since it returns an ascending list.
        int filled = 0;
        for (Student s : students) {
            if (s != null) {
                filled++;
            }
        }
        int iterateHalfway = filled / 2;
        for (int i = 0; i < iterateHalfway; i++) {
            Student temp = sort[i];
            sort[i] = sort[iterateHalfway - i];
            sort[iterateHalfway - i] = temp;
        }
        return sort;
    }

    public HashMap<Student, String> getGradeBook() {
        HashMap<Student, String> gradeBook = new HashMap<>();
        Student[] sorted = this.getStudentsByScore();
        int count = getStudentsByScore().length;
        for (int i = 0; i < count; i++) {
            Double percentile = ((count - i - 1.0) / count) * 100;
            if (percentile >= 90) {
                gradeBook.put(sorted[i], "A");
            } else if (percentile <= 89 && percentile >= 71) {
                gradeBook.put(sorted[i], "B");
            } else if (percentile <= 70 && percentile >= 50) {
                gradeBook.put(sorted[i], "C");
            } else if (percentile <= 49 && percentile >= 11) {
                gradeBook.put(sorted[i], "D");
            } else {
                gradeBook.put(sorted[i], "F");

            }
        }
        return gradeBook;
    }
}