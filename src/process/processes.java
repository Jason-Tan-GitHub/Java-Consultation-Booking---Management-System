package process;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class processes {

    private String emailL, passwordL, I_D;
    private String mail, mailSecond, pass, name, nameSecond;
    private String time, location, date, pending = "Pending", done = "Done" , reschedule = "None";

    private int closeWindow = 0, row;

    private String newString;
//    HashSet<String> emailSet = new HashSet<>();

    private String tempPath = "C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\temp.txt";
    private String filename_student = "C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\student_signup.txt";
    private String filename_lecturer = "C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\lecturer_signup.txt";
    private String filename_consultation = "C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\consultation.txt";
    private String filename_appointment = "C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\appointment.txt";

    public processes() {

    }

    public processes(String I_D, String mail, String name, String pass) {
        this.I_D = I_D;
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }

    public processes(String email, String name, String time, String location, String date) {
        this.mail = email;
        this.name = name;
        this.time = time;
        this.location = location;
        this.date = date;
    }

    public processes(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }
    
     public processes(String I_D, String mail, String name) {
         this.I_D = I_D;
        this.mail = mail;
        this.name = name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setID(String I_D) {
        this.I_D = I_D;
    }

    public String getFilePath(int fileType) {
        switch (fileType) {
            case 1 -> {
                return filename_student;
            }
            case 2 -> {
                return filename_lecturer;
            }
            case 3 -> {
                return filename_consultation;
            }
            case 4 -> {
                return tempPath;
            }
            case 5 -> {
                return filename_appointment;
            }
            default -> {
                throw new IllegalArgumentException("Invalid file type");
            }
        }
    }

    //Successful Login / Signup
    public void setSuccess(int closeWindow) {
        this.closeWindow = closeWindow;
    }

    public int getSuccess() {
        return closeWindow;
    }

    //Get (Login)
    public String getUserName() {
        return name;
    }

    public String getEmail() {
        return mail;
    }

    public String getPassword() {
        return pass;
    }

    public String getID() {
        return I_D;
    }

    //Consultation      
    public int getRow() {
        return row;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
    
    public String getStatus(int status) {
        switch (status) {
            case 1 -> {
                return pending;
            }
            case 2 -> {
                return done;
            }
            default -> {
                throw new IllegalArgumentException("Invalid file type");
            }
        }
    }
    
     public String getReschedule() {
        return reschedule;
    }
    

    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
