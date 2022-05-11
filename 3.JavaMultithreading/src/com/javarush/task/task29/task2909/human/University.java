package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age =age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for (Student s : students) {
            if (s.getAverageGrade() == averageGrade) {
                result = s;
            };
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = students.get(0);
        double maxAverageGrade = students.get(0).getAverageGrade();
        for (Student s : students) {
            if (s.getAverageGrade() > maxAverageGrade){
                maxAverageGrade = s.getAverageGrade();
                result = s;
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student result = students.get(0);
        double minAverageGrade = students.get(0).getAverageGrade();
        for (Student s : students) {
            if (s.getAverageGrade() < minAverageGrade){
                minAverageGrade = s.getAverageGrade();
                result = s;
            }
        }
        return result;
    }

    public void expel(Student student){
        if (students.contains(student)){
            students.remove(student);
        }
    }

}