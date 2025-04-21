///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package process;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author User
// */
//public class backup_processes {
//    private void deleteConsultation() {
//        try (BufferedReader dcr = new BufferedReader(new FileReader(file))) {
//            try (BufferedWriter dcw = new BufferedWriter(new FileWriter(getFileTemp()))) {
//                while ((line = dcr.readLine()) != null) {
//                    String[] parts = line.split(",");
//
//                    System.out.println(lineNumber);
//                    System.out.println(getRow());
//
//                    if (lineNumber != getRow()) {
//                        conDel = new ArrayList<>();
//                        conDel.add(parts[0]);
//                        conDel.add(parts[1]);
//                        conDel.add(parts[2]);
//                        conDel.add(parts[3]);
//
////                        System.out.println(parts[0]);
////                        System.out.println(parts[1]);
////                        System.out.println(parts[2]);
////                        System.out.println(parts[3]);
//                        String newLine = String.join(",", conDel);
//
//                        System.out.println(newLine);
//
//                        dcw.write(newLine);
//                        dcw.newLine();
//
//                        lineNumber++;
//                    } else {
//                        lineNumber++;
//                    }
//
//                }
//                dcw.close();
//                dcr.close();
//
//                setSuccess(1);
//                File newFile = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\temp.txt");
//                File oldFile = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\JavaProjectAssignment\\src\\Data\\consultaion.txt");
//
//                if (oldFile.delete()) {
//                    newFile.renameTo(oldFile);
//                } else {
//                    System.out.println("Failed to delete the file.");
//                }
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Tempfile write issue.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "File read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//}



//change cosultation
//        try (BufferedReader r = new BufferedReader(new FileReader(inputFile))) {
//            try (BufferedWriter w = new BufferedWriter(new FileWriter(tempFile, true))) {
//                while ((line = r.readLine()) != null) {
//                    String[] parts = line.split(",");
//                    String id = parts[0].trim();
//                    if (id.equals(getID())) {
//                        update.add(getID());
//                        update.add(getEmail());
//                        update.add(getUserName());
//                        update.add(getPassword());
//                        update.add(getNumber());
//
//                        line = String.join(",", update);
//                    }
//                    w.write(line);
//                    w.newLine(); // Maintain proper file formatting
//                }
//
//                w.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Tempfile write issue.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            //Overwrite entire file
//            try (BufferedReader tempReader = new BufferedReader(new FileReader(tempFile))) {
//                try (BufferedWriter originalWriter = new BufferedWriter(new FileWriter(inputFile))) {
//                    while ((line = tempReader.readLine()) != null) {
//                        originalWriter.write(line);
//                        originalWriter.newLine();
//                    }
//                    tempReader.close();
//                    originalWriter.close();
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "File not found, probably. LPP", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Tempfile read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            r.close();
//            File tempFile = new File(getFilePath(4));
//            tempFile.delete();
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "File read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//        }



//write consultation
//try (BufferedWriter cbw = new BufferedWriter(new FileWriter(inputFile, true))) {
//
//            con.add(getEmail());
//            con.add(getNumber());
//            con.add(getTime());
//            con.add(getLocation());
//            con.add(getDate());
//
//            String joinedString = String.join(",", con);
//
//            cbw.write(joinedString + "\n");
//            cbw.close();
//
//            setSuccess(1);
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
//        }

//delete consultation
//        try (BufferedReader dcr = new BufferedReader(new FileReader(inputFile))) {
//            try (BufferedWriter dcw = new BufferedWriter(new FileWriter(tempFile))) {
//                while ((line = dcr.readLine()) != null) {
//                    String[] parts = line.split(",");
//
//                    System.out.println(lineNumber);
//                    System.out.println(getRow());
//
//                    if (lineNumber != row) {
//                        conDel = new ArrayList<>();
//                        conDel.add(parts[0]);
//                        conDel.add(parts[1]);
//                        conDel.add(parts[2]);
//                        conDel.add(parts[3]);
//                        conDel.add(parts[4]);
//
//                        String newLine = String.join(",", conDel);
//
//                        System.out.println(newLine);
//
//                        dcw.write(newLine);
//                        dcw.newLine();
//
//                        lineNumber++;
//                    } else {
//                        lineNumber++;
//                    }
//
//                }
//
//                dcw.close();
//
//                try (BufferedReader tempReader = new BufferedReader(new FileReader(tempFile))) {
//                    try (BufferedWriter originalWriter = new BufferedWriter(new FileWriter(inputFile))) {
//                        while ((line = tempReader.readLine()) != null) {
//                            originalWriter.write(line);
//                            originalWriter.newLine();
//                        }
//                        tempReader.close();
//                        originalWriter.close();
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, "File not found, probably. LPP", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "Tempfile read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                dcr.close();
//                File tFile = new File(tempFile);
//                tFile.delete();
//
//                setSuccess(1);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Tempfile write issue.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "File read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//        }

//change consultation
//        try (BufferedReader r = new BufferedReader(new FileReader(inputFile))) {
//            try (BufferedWriter w = new BufferedWriter(new FileWriter(tempFile, true))) {
//                while ((line = r.readLine()) != null) {
//                    String[] parts = line.split(",");
//
//                    if (lineNumber == row) {
//                        update.add(getEmail());
//                        update.add(getNumber());
//                        update.add(getTime());
//                        update.add(getLocation());
//                        update.add(getDate());
//
//                        line = String.join(",", update);
//                    }
//
//                    w.write(line);
//                    w.newLine(); // Maintain proper file formatting
//
//                    lineNumber++;
//                }
//                w.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Tempfile write issue.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            //Overwrite entire file
//            try (BufferedReader tempReader = new BufferedReader(new FileReader(tempFile))) {
//                try (BufferedWriter originalWriter = new BufferedWriter(new FileWriter(inputFile))) {
//                    while ((line = tempReader.readLine()) != null) {
//                        originalWriter.write(line);
//                        originalWriter.newLine();
//                    }
//                    tempReader.close();
//                    originalWriter.close();
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "File not found, probably. LPP", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Tempfile read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            r.close();
//            File tFile = new File(tempFile);
//            tFile.delete();
//
//            setSuccess(1);
//
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "File read issue LPP.", "Error", JOptionPane.ERROR_MESSAGE);
//        }


//login process
//  public void loginStudent() throws IOException {
//        try (BufferedReader readerL = new BufferedReader(new FileReader(getFilePath(1)))) {
//            while ((line = readerL.readLine()) != null) {
//                String[] parts = line.split(",");
//
//                setID(parts[0]);
//                setEmail(parts[1]);
//                setUserName(parts[2]);
//                setPass(parts[3]);
//                setNumber(parts[4].trim());
//
//                if (getEmail() == null) {
//                    setSuccess(3);
//                    break;
//                }
//
//                if (getEmail().equals(getEmailL())) {
//                    if (getPassword().equals(getPasswordL())) {
//                        setSuccess(1);  // Successful login
//                    } else {
//                        setSuccess(2);  // Incorrect password
//                    }
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        if (getSuccess() == 0) {
//            setSuccess(3);  // Could represent "No user found"
//        }
//    }
//
//    public void loginLecturer() throws IOException {
//        try (BufferedReader readerL = new BufferedReader(new FileReader(getFilePath(2)))) {
//            while ((line = readerL.readLine()) != null) {
//                String[] parts = line.split(",");
//
//                setID(parts[0]);
//                setEmail(parts[1]);
//                setUserName(parts[2]);
//                setPass(parts[3]);
//                setNumber(parts[4].trim());
//
//                if (getEmail() == null) {
//                    setSuccess(3);
//                    break;
//                }
//
//                if (getEmail().equals(getEmailL())) {
//                    if (getPassword().equals(getPasswordL())) {
//                        setSuccess(1);  // Successful login
//                    } else {
//                        setSuccess(2);  // Incorrect password
//                    }
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        if (getSuccess() == 0) {
//            setSuccess(3);  // Could represent "No user found"
//        }
//    }

//signup process
//private String line, I_D;
//    private int existingStudentsCount = 0, existingLecturersCount = 0, id;
//    private HashSet<String> emailSet = new HashSet<>();
//    private ArrayList<String> stringList = new ArrayList<>();
//    
//    public signup_process(String emailR, String full_nameR, String passwordR, String confirm_passR) {
//        super(emailR, full_nameR, passwordR, confirm_passR);
//    }
//
//    public void register_done_student() throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(1), true))) {
//            try (BufferedReader readerS = new BufferedReader(new FileReader(getFilePath(1)))) {
//                while ((line = readerS.readLine()) != null) {
//                    String[] parts = line.split(",");
//                    if (parts.length > 1) {
//                        existingStudentsCount++;
//                        String email = parts[1].trim();
//                        emailSet.add(email);
//                        // Check for duplicate email while reading
//                    }
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "File register student not found.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//
//            if (getPasswordR().equals(getConfirm_passR())) {
//                if (emailSet.contains(getEmailR())) {
//                    setSuccess(2);
//                } else {
//                    id = existingStudentsCount + 1;
//                    I_D = Integer.toString(id);
//                    stringList.add(I_D);
//                    stringList.add(getEmailR());
//                    stringList.add(getFull_nameR());
//                    stringList.add(getPasswordR());
//                    stringList.add(getNumber());
//
//                    String joinedString = String.join(",", stringList);
//
//                    writer.write(joinedString + "\n");
//                    writer.close();
//                    setSuccess(1);
//                }
//            } else {
//                setSuccess(0);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Student registration issue.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//
//    public void register_done_lecturer() throws IOException {
//        try (BufferedWriter w = new BufferedWriter(new FileWriter(getFilePath(2), true))) {
//            try (BufferedReader r = new BufferedReader(new FileReader(getFilePath(2)))) {
//                while ((line = r.readLine()) != null) {
//                    String[] parts = line.split(",");
//                    if (parts.length > 1) {
//                        String email = parts[1].trim();
//                        emailSet.add(email); // Check for duplicate email while reading
//                        existingStudentsCount++;
//                    }
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "File register lecturer not found.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//
////            System.out.println(getEmailR());
////            System.out.println(getFull_nameR());
////            System.out.println(getPasswordR());
////            System.out.println(getConfirm_passR());
//            if (getPasswordR().equals(getConfirm_passR())) {
//                if (emailSet.contains(getEmailR())) {
//                    setSuccess(2);
//                } else {
//                    id = existingStudentsCount + 1;
//                    I_D = Integer.toString(id);
//                    stringList.add(I_D);
//                    stringList.add(getEmailR());
//                    stringList.add(getFull_nameR());
//                    stringList.add(getPasswordR());
//                    stringList.add(getNumber());
//
//                    String joinedString = String.join(",", stringList);
//
//                    w.write(joinedString + "\n");
//                    w.close();
//                    setSuccess(1);
//                }
//            } else {
//                setSuccess(0);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lecturer registration issue.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
