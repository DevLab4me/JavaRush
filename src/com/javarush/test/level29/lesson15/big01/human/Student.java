package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

    public void incAverageGrade(double delta)
    {
        this.setAverageGrade(this.getAverageGrade()+delta);
    }

    public void setCourse(int course){
         this.course = course;
    }

    public void setAverageGrade(double value){
         this.averageGrade = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getPosition(){
        return "Студент";
    }
}
