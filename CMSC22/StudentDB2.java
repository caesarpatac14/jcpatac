package Lab_13_StudentDB;

/**
 * Created by jcpatac on 11/3/2016.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB2 {

    private static final File DATABASE = new File("C:\\Temp\\Database.txt");

    private ArrayList<Student> student = new ArrayList<>();

    public static void main(String[] args) {
        StudentDB2 register = new StudentDB2();
        register.menu();
    }

    public void addStudent() {
        Scanner sc1 = new Scanner(System.in);

        //student number
        System.out.println("Student Number: ");
        String studentNum = sc1.next();

        for (Student s : student) {
            if (studentNum.equals(s.getStudentNumber())) {
                System.out.println("Student already exist!");
                return;
            }else {
                continue;
            }
        }

        // first name
        System.out.println("First Name: ");
        String fName = sc1.next();

        // middle initial
        System.out.println("Middle Initial: ");
        String mi = sc1.next();
        char mInit = mi.charAt(0);

        //last name
        System.out.println("Last Name: ");
        String lName = sc1.next();

        // course
        System.out.println("Program: ");
        String course = sc1.next();

        // year level
        System.out.println("Year Level: ");
        int yrLvl = sc1.nextInt();

        //crush name
        System.out.println("Crush Name: ");
        String crushName = sc1.next();

        //favorite Subject
        System.out.println("Favorite Subject: ");
        System.out.println("Course Code: ");
        String courseCode = sc1.next();
        System.out.println("Course Description");
        String cd = sc1.next();
        Course favSubj = new Course(courseCode, cd);

        Student newStudent = new Student(studentNum, fName, mInit, lName, course, yrLvl, crushName, favSubj);

        student.add(newStudent);

        System.out.println("Processing...");

        processing();

        System.out.println("Successfully added!");

        /*
        for (Student s2 : student) {
            System.out.println(s2);
        }*/

    }

    public void saveStudent() {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            fos = new FileOutputStream(DATABASE);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(student);

            System.out.println("Saving...");
            processing();

            System.out.println("Successfully save data!");

            oos.close();

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                fos.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadStudent() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream(DATABASE);
            ois = new ObjectInputStream(fis);

            if (ois.read() != -1) {
                student = (ArrayList<Student>) ois.readObject();
            }else {
                System.out.println("Error! Database Empty!");
                return;
            }

            System.out.println("Loading...");

            processing();

            System.out.println("Successfully Loaded!");

            ois.close();

        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException ec) {
            ec.printStackTrace();
        }finally {

            try {
                fis.close();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteStudent() {

        if (student.size() == 0) {
            System.out.println("Database is Empty!");
            return;
        }

        Scanner sc4 = new Scanner(System.in);
        System.out.println("Remove Student Number: ");
        String sNumber = sc4.next();

        if (student.isEmpty()) {
            System.out.println("No Loaded Database!");
            return;
        }

        for (Student s : student) {
            if (sNumber.equals(s.getStudentNumber())) {
                System.out.println("Remove Student " + s.getFirstName() + "?" + " (y/n)");
                String remove = sc4.next();
                if (remove.equals("Y") || remove.equals("y")) {
                    student.remove(s);
                    System.out.println("Removing from database...");
                    processing();
                    System.out.println("Successfully removed!");
                    break;
                }else {
                    deleteStudent();
                }
            }
        }
    }

    public void searchStudent() {

        if (student.isEmpty()) {
            System.out.println("Database is Empty!");
            return;
        }

        System.out.println("Student Number: ");

        Scanner sc3 = new Scanner(System.in);
        String sNumber = sc3.next();

        boolean found = false;

        for (Student s : student) {
            if (sNumber.equals(s.getStudentNumber())) {
                System.out.println(s.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }


    public void processing() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void menu() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Menu: 1. Add Student    2. Save Data    3. Remove Student   4. Search Student   5. Load Database    6. Exit");
        System.out.println("Select Menu: ");
        int selection = sc2.nextInt();

        switch (selection) {
            case 1 :
                System.out.println("Add Student selected!");
                addStudent();
                break;
            case 2 :
                System.out.println("Save Option selected!");
                saveStudent();
                break;
            case 3 :
                System.out.println("Remove Student selected!");
                deleteStudent();
                break;
            case 4 :
                System.out.println("Search Student selected!");
                searchStudent();
                break;
            case 5 :
                System.out.println("Load Data selected!");
                loadStudent();
                break;
            case 6 :
                System.out.println("Exit? (y/n)");
                String yOn = sc2.next();

                if (yOn.equals("Y") || yOn.equals("y")) {
                    System.exit(0);
                }else {
                    break;
                }
        }
        menu();
    }
}

