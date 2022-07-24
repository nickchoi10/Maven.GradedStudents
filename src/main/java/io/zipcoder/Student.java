package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {


//declaring the variables
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


//constructors whose parameters used to initialize the instance variables up top^^
    public Student(String firstName, String lastName, Double [] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
        //turning [] testScores parameter into an ArrayList into examScores declared above^^
    }


//getters
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

//    public ArrayList<Double> getExamScores(){return examScores;}
    public int getNumberOfExamsTaken(){return examScores.size();} //.size for array list!


//Setters
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setExamScores(ArrayList<Double> examScores) {this.examScores = examScores;}


//methods
    public String getExamScores(){
        String scores = "";
        int examCounter=1;
        for(int i=0; i < getNumberOfExamsTaken(); i++){
            scores += "Exam " +examCounter+ " -> " + examScores.get(i) + "\n";
            examCounter++;
        }
        return scores;
    }

    public void addExamScore(double examScore){     //needs to be void because you can't return boolean (used for collections...)
         examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double examScore){
        examScores.set(examNumber-1,examScore); //-1 because test1 is in index 0...
    }

    public int getAverageExamScore(){
        int sum =0;
        for(int i=0; i < getNumberOfExamsTaken(); i++){
            sum += examScores.get(i);
        }
        return sum/getNumberOfExamsTaken();
    }

    public String toString(){

        String student = "Student Name: " + firstName +"\n" + "> Average Score: " + getAverageExamScore()
                + "\n" + "> Exam Scores: " + getExamScores();
        return student;
    }
}