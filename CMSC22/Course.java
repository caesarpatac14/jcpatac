package Lab_13_StudentDB;

import java.io.Serializable;

/**
 * Created by jcpatac on 11/3/2016.
 */
public class Course implements Serializable {

    private String courseCode;
    private String  courseDescription;

    public Course(String courseCode, String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    public String toString() {
        return courseCode + ": " + courseDescription;
    }
}
