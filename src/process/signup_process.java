/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class signup_process extends processes {

    private String line, I_D, emailR, full_nameR, passwordR, confirm_passR;
    private int existingCount = 0;
    private HashSet<String> emailSet = new HashSet<>();

    public signup_process(String emailR, String full_nameR, String passwordR, String confirm_passR) {
        this.emailR = emailR;
        this.full_nameR = full_nameR;
        this.passwordR = passwordR;
        this.confirm_passR = confirm_passR;
    }

    public void register_done_student() {
        register(getFilePath(1));
    }

    public void register_done_lecturer() {
        register(getFilePath(2));
    }

    private void register(String filePath) {
        emailSet.clear(); // Clear the set before each registration to avoid errors
        existingCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    existingCount++;
                    String email = parts[1].trim();
                    emailSet.add(email); // Collect existing emails to check for duplicates
                }
            }
        } catch (IOException e) {
            showError("File not found.");
        }

        // Check if the passwords match
        if (!passwordR.equals(confirm_passR)) {
            setSuccess(0);
            return;
        }

        // Check if the email already exists
        if (emailSet.contains(emailR)) {
            setSuccess(2);
            return;
        }

        // If all validations pass, register the user
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            int newId = existingCount + 1;
            I_D = Integer.toString(newId);
            ArrayList<String> userDetails = new ArrayList<>();
            userDetails.add(I_D);
            userDetails.add(emailR);
            userDetails.add(full_nameR);
            userDetails.add(passwordR);

            String joinedString = String.join(",", userDetails);
            writer.write(joinedString + "\n");
            setSuccess(1); // Successful registration
        } catch (IOException e) {
            showError("Registration issue for file");
        }
    }

}
