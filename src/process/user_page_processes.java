/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class user_page_processes extends processes {

    private String line, data, inputFile, tempFile, consultFile, I_D, currentLine, dummy, ID;
    private int role, lineNumber = 0, id, row, idCount = 0;
    private ArrayList<String> update = new ArrayList<>();
    private ArrayList<String> con = new ArrayList<>();
    private HashSet<String> conSet = new HashSet<>();
    private ArrayList<String> conDel;
    processes pr = new processes();
    StringBuilder fileContent = new StringBuilder();
    
    public user_page_processes(){
        
    }
    
    public user_page_processes(String ID){
        setID(ID);
    }

    public user_page_processes(String ID, String email, String name, String pass) {
        super(ID, email, name, pass);
    }

    public user_page_processes(String email, String nameLecture, String contactLecture, String location, String date, int row) {
        super(email, nameLecture, contactLecture, location, date);
        this.row = row;
    }

    public user_page_processes(String email, String nameLecture, String contactLecture, String location, String date) {
        super(email, nameLecture, contactLecture, location, date);
    }

    public user_page_processes(String emailS, String nameStudent, String contactStudent) {
        super(emailS, nameStudent, contactStudent);
    }

    public user_page_processes(String email, String name, int row) {
        super(email, name);
        this.row = row;
    }

    public void setDetailsLS(int role) throws IOException {
        this.role = role;

        switch (role) {
            case 1 -> {
                inputFile = getFilePath(2);
                tempFile = getFilePath(4);
                changeDetails();
            }
            case 2 -> {
                inputFile = getFilePath(1);
                tempFile = getFilePath(4);
                changeDetails();
            }
            case 3 -> {
                inputFile = getFilePath(3);
                writeConsultation();
            }
            case 4 -> {
                inputFile = getFilePath(3);
                tempFile = getFilePath(4);
                deleteConsultation();
            }
            case 5 -> {
                tempFile = getFilePath(4);
                inputFile = getFilePath(3);
                changeConsultationLecture();
            }
            case 6 -> {
                consultFile = getFilePath(3);
                inputFile = getFilePath(5);
                bookConsultation();
            }
            case 7 -> {
                inputFile = getFilePath(5);
                tempFile = getFilePath(4);
                completeConsultation();
            }
        }
    }

    //Lecture side
    private void changeDetails() throws IOException {
        List<String> lines = readFile(inputFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(getID())) {
                    line = String.join(",", getID(), getEmail(), getUserName(), getPassword());
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            showError("File write issue");
        }
        overwriteFile(tempFile, inputFile);
    }

    private void writeConsultation() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile, true))) {
            writer.write(String.join(",", getEmail(), getUserName(), getTime(), getLocation(), getDate()));
            writer.newLine();
            setSuccess(1);
        } catch (IOException e) {
            showError("File write issue");
        }
    }

    private void deleteConsultation() {
        List<String> lines = readFile(inputFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < lines.size(); i++) {
                if (i != row) {
                    writer.write(lines.get(i));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            showError("Temp file write issue");
        }
        overwriteFile(tempFile, inputFile);
        setSuccess(1);
    }

    private void changeConsultationLecture() {
        List<String> lines = readFile(inputFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (i == row) {
                    line = String.join(",", getEmail(), getUserName(), getTime(), getLocation(), getDate());
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            showError("Temp file write issue");
        }
        overwriteFile(tempFile, inputFile);
        setSuccess(1);
    }

    private void bookConsultation() {
        fileContent.delete(0, fileContent.length());
        List<String> lines = readFile(consultFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = reader.readLine()) != null) {
                idCount++;
            }
        } catch (IOException e) {
            showError("File read issue while generating ID.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile, true))) {
            for (int i = 0; i < lines.size(); i++) {
                if (i == row) {
                    line = lines.get(i);
                    fileContent.append(line);
                }
            }

            int id_consult = idCount + 1;
            String idconsult = Integer.toString(id_consult);

            writer.write(String.join(",", idconsult, getEmail(), getUserName(), fileContent.toString(), getStatus(1), getReschedule()));
            writer.newLine();

            setDetailsLS(4);
            setSuccess(1);
        } catch (IOException e) {
            showError("File write issue");
        }
    }

    private void completeConsultation() {
        fileContent.delete(0, fileContent.length());
        List<String> lines = readFile(inputFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[0].equals(getID())) {
                    if (parts.length > 9) {
                        String newStatus = getStatus(2);
                        line = String.join(",",parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], getStatus(2), parts[9]);
                    } else {
                        System.out.println("Not enough parts to modify the line.");
                    }
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            showError("Temp file write issue");
        }
        overwriteFile(tempFile, inputFile);
        setSuccess(1);
    }

    private List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            showError("File read issue");
        }
        return lines;
    }

    private void overwriteFile(String sourceFile, String destinationFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            showError("File overwrite issue");
        }
        new File(sourceFile).delete();  // Clean up temporary file
    }

}
