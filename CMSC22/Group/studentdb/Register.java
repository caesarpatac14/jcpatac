package studentdb;

import java.util.*;
import java.io.*;

/**
 * Created by acer on 10/14/2016.
 */

public class Register {

    private ArrayList<Student> student = new ArrayList<>();

    public static void main(String[] args) {
        Register register = new Register();
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
                menu();
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

        Student newStudent = new Student(studentNum, fName, mInit, lName, course, yrLvl);

        student.add(newStudent);

        System.out.println("Processing...");

        processing();

        System.out.println("Successfully added!");

        /*
        for (Student s2 : student) {
            System.out.println(s2);
        }*/

        menu();
    }

    public void saveStudent() {

        try {

            File file = new File("Database.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writeData = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(writeData);
            String writeThis = student.toString().replace("[", "").replace("]", "").replaceAll(",", "");
            String[] words = writeThis.split(" ");

            int ctr = 0;

            for (String word : words) {
                ctr++;
                writer.write(word);
                writer.newLine();
                if (ctr % 6 == 0) {
                    writer.newLine();
                }
            }
            writer.close();

            System.out.println("Saving...");
            processing();

            System.out.println("Successfully save data!");

        }catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void deleteStudent() {
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Remove Student Number: ");
        String sNumber = sc4.next();

        if (student.isEmpty()) {
            System.out.println("No Loaded Database!");
            menu();
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
                }else {
                    deleteStudent();
                }
            }
        }
        menu();
    }

    public void searchStudent() {

        if (student.isEmpty()) {
            System.out.println("No Loaded Database!");
            menu();
        }

        System.out.println("Student Number: ");

        Scanner sc3 = new Scanner(System.in);
        String sNumber = sc3.next();

        for (Student s : student) {
            if (sNumber.equals(s.getStudentNumber())) {
                System.out.println(s.toString());
            }else {
                System.out.println("Student not found!");
            }
            menu();
        }
    }

    public void loadStudent() {

        Student isko;

        String sn = "";
        String fn = "";
        char mi = ' ';
        String ln = "";
        String prgrm = "";
        int yrlvl = 0;

        BufferedReader readData = null;

        try {

            String line;

            readData = new BufferedReader(new FileReader("Database.txt"));

            System.out.println("Loading...");
            processing();

            int counter = 0;

            while ((line = readData.readLine()) != null) {
                counter++;
                if (!(line.equals(" "))) {
                    if (counter == 1) {
                        sn = line;
                    }else if(counter == 2) {
                        fn = line;
                    }else if(counter == 3) {
                        String middle = line;
                        mi = middle.charAt(0);
                    }else if(counter == 4) {
                        ln = line;
                    }else if(counter == 5) {
                        prgrm = line;
                    }else if(counter == 6) {
                        counter = -1;
                        yrlvl = Integer.parseInt(line);
                        isko = new Student(sn, fn, mi, ln, prgrm, yrlvl);
                        student.add(isko);
                    }
                }

            }

            System.out.println("Successfully Loaded Data!");

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                if (readData != null) {
                    readData.close();
                }

            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        menu();
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
            case 2 :
                System.out.println("Save Option selected!");
                saveStudent();
            case 3 :
                System.out.println("Remove Student selected!");
                deleteStudent();
            case 4 :
                System.out.println("Search Student selected!");
                searchStudent();
            case 5 :
                System.out.println("Load Data selected!");
                loadStudent();
            case 6 :
                System.out.println("Exit? (y/n)");
                String yOn = sc2.next();

                if (yOn.equals("Y") || yOn.equals("y")) {
                    System.exit(0);
                }else {
                    menu();
                }
        }
    }
}
