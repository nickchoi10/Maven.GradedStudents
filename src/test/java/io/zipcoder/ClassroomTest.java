package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void ClassroomTest1(){
        Classroom classroom = new Classroom();

        int size = classroom.getStudents().length;

        Assert.assertEquals(30,size);

    }
    @Test
    public void ClassroomTest2(){
        Classroom classroom = new Classroom();

        int size = classroom.getStudents().length;

        Assert.assertFalse(33 == size);}

    @Test
    public void getExamAverage(){
        Student student = new Student(null,null,new Double[]{100.0});
        Student student1 = new Student(null,null,new Double[]{0.0});
        Student[] studentList = new Student[]{student,student1};
        Classroom classroom = new Classroom(studentList);

        Double actual = classroom.getAverageExamScore();
        Double expected =50.0;

        Assert.assertEquals(expected,actual, 0);

    }
    @Test
    public void addStudentTest() {
        Student student = new Student(null, null, new Double[]{100.0});
        Student student1 = new Student(null, null, new Double[]{0.0});
        Student[] studentList;
        Classroom classroom = new Classroom();

        int count = 0;
        classroom.addStudent(student);
        classroom.addStudent(student1);
        studentList = classroom.getStudents();
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                count++;
            }
        }
        Assert.assertEquals(2, count);
    }


    public void testGetStudentsByScore() {
    }

    public void testGetGradeBook() {


    }
}
