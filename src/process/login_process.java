/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class login_process extends processes {

    private String line, passwordL, emailL;

    public login_process(String emailL, String passwordL) {
        this.emailL = emailL;
        this.passwordL = passwordL;
    }

    public void loginStudent() throws IOException {
        login(getFilePath(1)); // File path for student
    }

    public void loginLecturer() throws IOException {
        login(getFilePath(2)); // File path for lecturer
    }

    private void login(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            boolean foundUser = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                setID(parts[0]);
                setEmail(parts[1]);
                setUserName(parts[2]);
                setPass(parts[3]);

                if (getEmail().equals(emailL)) {
                    foundUser = true;
                    if (getPassword().equals(passwordL)) {
                        setSuccess(1);  // Successful login
                    } else {
                        setSuccess(2);  // Incorrect password
                    }
                    break;
                }
            }
            if (!foundUser) {
                setSuccess(3);  // No user found
            }
        } catch (IOException e) {
            showError("File not found or could not be read.");
        }
    }

}
