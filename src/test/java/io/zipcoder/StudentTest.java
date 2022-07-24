package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test

    public void ConstructorTrueTest(){
        //given
        String firstName = "Nick";
        String lastName = "Choi";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };

        //when
        Student student = new Student(firstName, lastName, examScores);


        //Then
        Assert.assertTrue(student.getFirstName() != null);
        Assert.assertTrue(student.getLastName() != null);
        Assert.assertTrue(student.getExamScores() != null);

    }

    @Test

    public void ConstructorFalseTest(){
        //given
        String firstName = "hello";
        String lastName = "world";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };

        //when
        Student student = new Student(firstName, lastName, examScores);


        //Then
        Assert.assertFalse(student.getLastName() == null);
        Assert.assertFalse(student.getFirstName() == null);
        Assert.assertFalse(student.getExamScores() == null);

    }

    @Test
    public void getStudentNameTest(){
        //given
        String firstName = "Nick";
        String lastName = "Choi";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };

        //when
        Student student = new Student(firstName, lastName, examScores);


        //Then
        Assert.assertTrue(student.getFirstName() =="Nick");
        Assert.assertTrue(student.getLastName() =="Choi");

    }

    @Test
    public void examScoreTest(){
        //given
        String firstName = "Nick";
        String lastName = "Choi";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //when
        String actualTestScores= student.getExamScores();
        String expectedTestScores = "Exam 1 -> 100.0\n" +"Exam 2 -> 95.0\n" + "Exam 3 -> 123.0\n" + "Exam 4 -> 96.0\n";

        Assert.assertEquals(actualTestScores, expectedTestScores);
    }
    @Test
    public void addExamScoreTest(){
        //given
        String firstName = "Nick";
        String lastName = "Choi";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //when
        student.addExamScore(5.0);
        String actualTestScores= student.getExamScores();
        String expectedTestScores = "Exam 1 -> 100.0\n" +"Exam 2 -> 95.0\n" + "Exam 3 -> 123.0\n" + "Exam 4 -> 96.0\n" +"Exam 5 -> 5.0\n";

        Assert.assertEquals(actualTestScores, expectedTestScores);
    }
    @Test
    public void setExamScoreTest(){
        //given
        String firstName = "Nick";
        String lastName = "Choi";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //when
        student.setExamScore(1,25.0);
        String actualTestScores= student.getExamScores();
        String expectedTestScores = "Exam 1 -> 25.0\n" +"Exam 2 -> 95.0\n" + "Exam 3 -> 123.0\n" + "Exam 4 -> 96.0\n";

        Assert.assertEquals(actualTestScores, expectedTestScores);
    }
    @Test
    public void getAverageTestScores(){
        //given
        String firstName = null;
        String lastName = null;
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(null, null, examScores);

        //when

        double actualTestScores= student.getAverageExamScore();
        double expectedTestScores = 103.0;


        Assert.assertFalse(student.getAverageExamScore()==79);
        Assert.assertEquals(expectedTestScores,actualTestScores,0); //add the 0 delta bc checking double
    }


}