package Lab_13_StudentDB;

import java.io.Serializable;

/**
 * Created by jcpatac on 11/3/2016.
 */
public class Student implements Serializable {

    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubj;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course faveSubj) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubj = faveSubj;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCrushName() {
        return crushName;
    }

    public Course getFaveSubj() {
        return faveSubj;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    public void setFaveSubj(Course faveSubj) {
        this.faveSubj = faveSubj;
    }

    @Override
    public String toString() {
        return studentNumber + ": " + firstName + " " + middleInitial + ". " + lastName + ", "
                + course + " " + yearLevel + "; " + crushName + "; " + faveSubj;
    }
}

