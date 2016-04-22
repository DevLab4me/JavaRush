package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student requestedStudent = new Student(null, 0, 0);
        for (Student student : students){
            if(student.getAverageGrade() == averageGrade){
                requestedStudent = student;
            }
        }
        return requestedStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getAverageGrade(), o1.getAverageGrade());
            }
        });
        return students.get(0);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
            }
        });
        return students.get(0);
    }

    public void expel(Student student){
        students.remove(student);
    }
}
