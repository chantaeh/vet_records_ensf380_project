package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;

import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 * Scheduler GUI class
 * @author chantaeh
 * @author andrewy94
 * @author Youssef
 * @author Tony
 * @version 1.3
 * @since 1.1
 */
public class SchedulerGUI extends JFrame implements ActionListener {
    private JButton generateBtn, printBtn, editTaskBtn;
    private JTextArea outputArea;
    private Schedule schedule;
    
    private Scheduler scheduler = new Scheduler();
    private Connection dbConnect = null;

    /**
     * Constructor for SchedulerGUI class
     */
    public SchedulerGUI() {
        super("EWR Scheduler");
        
        // creating connection to database
        scheduler.createConnection();
        try {
            // connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "oop", "password");
        } catch (Exception ex) {}

        setSize(600, 400);
        setupGUI();
        setVisible(true);

        if (dbConnect != null) {
            generateBtn.addActionListener(this);
            printBtn.addActionListener(this);
            editTaskBtn.addActionListener(this);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Sets up the main starting GUI
     */
    private void setupGUI() {
        JPanel panel = new JPanel();
        outputArea = new JTextArea(20, 20);

        if (dbConnect != null) {
            generateBtn = new JButton("Generate Schedule");
            printBtn = new JButton("Print to .txt File");
            editTaskBtn = new JButton("Edit Schedule");

            panel.add(generateBtn);
            panel.add(printBtn);
            panel.add(editTaskBtn);
        } else {
            outputArea.setText("Unable to connect to the EWR database. Please restart the program.");
        }
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    /**
     * GUI for editing the database. Opened by editTaskButton on the main GUI.
     * Includes five buttons for adding, deleting, and changing tasks and/or treatments in the database.
     * @param none
     * @return none
     */
    private void openEditDialog() {
        // create dialog box
        JDialog dialog = new JDialog(this, "Edit Tasks", false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 0));
    
        // create buttons
        JButton addTaskButton = new JButton("Add Task");
        JButton addTmtButton = new JButton("Add Treatment to Animal");
        JButton deleteTaskButton = new JButton("Delete Task");
        JButton deleteTmtButton = new JButton("Delete Treatment from Animal");
        JButton moveButton = new JButton("Move Treatment Start Hours");
        
        panel.add(addTaskButton);
        panel.add(addTmtButton);
        panel.add(deleteTaskButton);
        panel.add(deleteTmtButton);
        panel.add(moveButton);

        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        
        // set button action listeners
        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle add task button click event
                
                // create dialog box for adding task
                JDialog addDialog = new JDialog(dialog, "Add Task", true);
                JPanel addPanel = new JPanel(new GridLayout(0, 2));
                addDialog.add(addPanel);
                
                // add task description text area
                JTextArea descriptionTextArea = new JTextArea(5, 20);
                addPanel.add(new JLabel("Description: "));
                addPanel.add(descriptionTextArea);
                
                // add duration drop down list
                JComboBox<Integer> durationComboBox = new JComboBox<Integer>();
                for (int i = 5; i <= 60; i += 5) {
                    durationComboBox.addItem(i);
                }
                addPanel.add(new JLabel("Duration (minutes): "));
                addPanel.add(durationComboBox);
                
                // add max window drop down list
                JComboBox<Integer> windowComboBox = new JComboBox<Integer>();
                for (int i = 1; i <= 24; i++) {
                    windowComboBox.addItem(i);
                }
                addPanel.add(new JLabel("Max Window (hours): "));
                addPanel.add(windowComboBox);

            // add submit button
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    outputArea.setText("Task added to database.\nYou can assign this task to an animal by clicking the 'Add Treatment to Animal' button.");
                    // get values from input fields
                    String description = descriptionTextArea.getText();
                    int duration = (int) durationComboBox.getSelectedItem();
                    int window = (int) windowComboBox.getSelectedItem();
                    
                    // insert new task into database
                    try {
                        Statement stmt = dbConnect.createStatement();
                        String insertSql = String.format("INSERT INTO TASKS (Description, Duration, MaxWindow) VALUES ('%s', %d, %d)", description, duration, window);
                        stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
                        ResultSet rs = stmt.getGeneratedKeys();
                    } catch (Exception ex) {
                        System.out.println("Exception: " + ex.getMessage());
                    }
                    
                    // close dialog box
                    addDialog.dispose();
                }
            });
            addPanel.add(submitButton);
            
            // show dialog box
            addDialog.pack();
            addDialog.setLocationRelativeTo(dialog);
            addDialog.setVisible(true);
            }
        });

        // set button action listeners
        addTmtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle add treatment button click event

                // create dialog box for adding treatment
                JDialog addDialog = new JDialog(dialog, "Add Treatment", true);
                JPanel addPanel = new JPanel(new GridLayout(0, 2));
                addDialog.add(addPanel);
            
                // add animal drop down list
                ArrayList<String> animalNicknames = new ArrayList<String>();
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = dbConnect.createStatement();
                    String selectSql = "SELECT AnimalNickname FROM ANIMALS";
                    rs = stmt.executeQuery(selectSql);
        
                    // add animal nicknames to ArrayList
                    while (rs.next()) {
                        animalNicknames.add(rs.getString("AnimalNickname"));
                    }
                } catch (SQLException ex) {
                    System.out.println("Exception: " + ex.getMessage());
                } 

                // add task dropdown list
                ArrayList<String> taskList = new ArrayList<String>();
                stmt = null;
                rs = null;
                try {
                    stmt = dbConnect.createStatement();
                    String selectSql = "SELECT Description FROM TASKS";
                    rs = stmt.executeQuery(selectSql);
                    
                    // add tasks to ArrayList
                    while (rs.next()) {
                        taskList.add(rs.getString("Description"));
                    }
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (Exception ex) {
                        System.out.println("Exception: " + ex.getMessage());
                    }
                }

                JComboBox<String> taskComboBox = new JComboBox<String>(taskList.toArray(new String[taskList.size()]));
                addPanel.add(new JLabel("Task: "));
                addPanel.add(taskComboBox);
    
                JComboBox<String> animalComboBox = new JComboBox<String>(animalNicknames.toArray(new String[animalNicknames.size()]));
                addPanel.add(new JLabel("Animal: "));
                addPanel.add(animalComboBox);
                
                // add start hour drop down list
                JComboBox<Integer> startHourComboBox = new JComboBox<Integer>();
                for (int i = 0; i <= 23; i++) {
                    startHourComboBox.addItem(i);
                }
                addPanel.add(new JLabel("Start Hour: "));
                addPanel.add(startHourComboBox);
            
            // add submit button
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                
                    schedule = null;
                    outputArea.setText("Treatment added.\nPlease generate a schedule to see the new treatment.");

                    // get values from input fields
                    
                    int animalID = animalComboBox.getSelectedIndex() + 1;
                    int startHour = (int) startHourComboBox.getSelectedItem();

                    // get selected animal-task and task
                    String task = (String) taskComboBox.getSelectedItem();
                
                    // get task ID
                    int taskID = -1;
                    Statement stmt = null;
                    ResultSet rs = null;
                    try {
                        stmt = dbConnect.createStatement();
                        String selectSql = "SELECT TaskID FROM TASKS WHERE Description='" + task + "'";
                        rs = stmt.executeQuery(selectSql);
            
                        // get task ID
                        if (rs.next()) {
                            taskID = rs.getInt("TaskID");
                        }
                    } catch (Exception ex) {
                        System.out.println("Exception: " + ex.getMessage());
                    }
                    
                    // insert new task into database
                    try {
                        String insertTreatmentSql = String.format("INSERT INTO TREATMENTS (AnimalID, TaskID, StartHour) VALUES (%d, %d, %d)", animalID, taskID, startHour);
                        stmt.executeUpdate(insertTreatmentSql);
                    } catch (Exception ex) {
                        System.out.println("Exception: " + ex.getMessage());
                    }
                    
                    // close dialog box
                    addDialog.dispose();
                }
            });
            addPanel.add(submitButton);
            
            // show dialog box
            addDialog.pack();
            addDialog.setLocationRelativeTo(dialog);
            addDialog.setVisible(true);
            }
        });

        deleteTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle delete task button click event
                
                // create dialog box for deleting task
                JDialog deleteDialog = new JDialog(dialog, "Delete Task", true);
                JPanel deletePanel = new JPanel(new GridLayout(0, 2));
                deleteDialog.add(deletePanel);
                
                Statement stmt = null;
                ResultSet rs = null;
                
                // add task dropdown list
                ArrayList<String> taskList = new ArrayList<String>();
                stmt = null;
                rs = null;
                try {
                    stmt = dbConnect.createStatement();
                    String selectSql = "SELECT Description FROM TASKS";
                    rs = stmt.executeQuery(selectSql);
                    
                    // add tasks to ArrayList
                    while (rs.next()) {
                        taskList.add(rs.getString("Description"));
                    }
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (Exception ex) {
                        System.out.println("Exception: " + ex.getMessage());
                    }
                }
                
                JComboBox<String> taskComboBox = new JComboBox<String>(taskList.toArray(new String[taskList.size()]));
                deletePanel.add(new JLabel("Task: "));
                deletePanel.add(taskComboBox);
      
                // add submit button
                JButton submitButton = new JButton("Submit");
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        schedule = null;
                        outputArea.setText("Task deleted and all treatments associated with it.\nPlease generate a schedule to see the new treatment");
                        // handle submit button click event
                
                        // get selected animal-task and task
                        String task = (String) taskComboBox.getSelectedItem();
                
                        // get task ID
                        int taskID = -1;
                        Statement stmt = null;
                        ResultSet rs = null;
                        try {
                            stmt = dbConnect.createStatement();
                            String selectSql = "SELECT TaskID FROM TASKS WHERE Description='" + task + "'";
                            rs = stmt.executeQuery(selectSql);
                
                            // get task ID
                            if (rs.next()) {
                                taskID = rs.getInt("TaskID");

                                String deleteSql = "DELETE FROM TASKS WHERE TaskID=" + taskID;
                                int rowsAffected = stmt.executeUpdate(deleteSql);
                                
                                String deleteSql2 = "DELETE FROM TREATMENTS WHERE TaskID=" + taskID;
                                int rowsAffected2 = stmt.executeUpdate(deleteSql2);

                                // close dialog box
                                deleteDialog.dispose();
                            }
                        } catch (Exception ex) {
                            System.out.println("Exception: " + ex.getMessage());
                        } finally {
                            try {
                                if (rs != null) {
                                    rs.close();
                                }
                                if (stmt != null) {
                                    stmt.close();
                                }
                            } catch (Exception ex) {
                                System.out.println("Exception: " + ex.getMessage());
                            }
                        }
                    }
                });
                deletePanel.add(submitButton);

                 // show dialog box
                deleteDialog.pack();
                deleteDialog.setLocationRelativeTo(dialog);
                deleteDialog.setVisible(true);
        
            }  
        });

        deleteTmtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle delete treatment button click event

                schedule = null;
                outputArea.setText("Treatment deleted.");
                
                // create dialog box for deleting task
                JDialog deleteDialog = new JDialog(dialog, "Delete Treatment", true);
                JPanel deletePanel = new JPanel(new GridLayout(0, 2));
                deleteDialog.add(deletePanel);
                
                // add animal-task dropdown list
                ArrayList<String> animalTaskList = new ArrayList<String>();
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = dbConnect.createStatement();
                    String selectSql = "SELECT ANIMALS.AnimalNickname, TASKS.Description " +
                    "FROM TREATMENTS " +
                    "JOIN ANIMALS ON TREATMENTS.AnimalID=ANIMALS.AnimalID " +
                    "JOIN TASKS ON TREATMENTS.TaskID=TASKS.TaskID";
                    rs = stmt.executeQuery(selectSql);
                    
                    // add animal-task pairs to ArrayList
                    while (rs.next()) {
                        animalTaskList.add(rs.getString("AnimalNickname") + ": " + rs.getString("Description"));
                    }
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (Exception ex) {
                        System.out.println("Exception: " + ex.getMessage());
                    }
                }
                
                JComboBox<String> animalTaskComboBox = new JComboBox<String>(animalTaskList.toArray(new String[animalTaskList.size()]));
                deletePanel.add(new JLabel("Treatments: "));
                deletePanel.add(animalTaskComboBox);
      
                // add submit button
                JButton submitButton = new JButton("Submit");
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        schedule = null;
                        outputArea.setText("Treatment deleted. Please generate a schedule to see the new treatment");
                        // handle submit button click event
                
                        // get selected animal-task and task
                        String animalTask = (String) animalTaskComboBox.getSelectedItem();
                
                        // get task ID
                        // int taskID = -1;
                        Statement stmt = null;
                        ResultSet rs = null;
                
                        // get animal ID and treatment ID
                        int animalID = -1;
                        int treatmentID = -1;
                        String[] animalTaskArray = animalTask.split(": ");
                        String animalNickname = animalTaskArray[0];
                        String taskDescription = animalTaskArray[1];
                        stmt = null;
                        rs = null;
                        try {
                            stmt = dbConnect.createStatement();
                            String selectSql = "SELECT ANIMALS.AnimalID, TREATMENTS.TreatmentID " +
                            "FROM TREATMENTS " +
                            "JOIN ANIMALS ON TREATMENTS.AnimalID=ANIMALS.AnimalID " +
                            "JOIN TASKS ON TREATMENTS.TaskID=TASKS.TaskID " +
                            "WHERE ANIMALS.AnimalNickname='" + animalNickname + "' " +
                            "AND TASKS.Description='" + taskDescription + "'";
            
                            rs = stmt.executeQuery(selectSql);
                
                            // get animal ID and treatment ID
                            if (rs.next()) {
                                animalID = rs.getInt("AnimalID");
                                treatmentID = rs.getInt("TreatmentID");
                            }
                        } catch (Exception ex) {
                            System.out.println("Exception: " + ex.getMessage());
                        } finally {
                            try {
                                if (rs != null) {
                                    rs.close();
                                }
                                if (stmt != null) {
                                    stmt.close();
                                }
                            } catch (Exception ex) {
                                System.out.println("Exception: " + ex.getMessage());
                            }
                        }
                
                        // delete treatment
                        stmt = null;
                        try {
                            stmt = dbConnect.createStatement();
                            String deleteSql = "DELETE FROM TREATMENTS WHERE TreatmentID=" + treatmentID;
                            int rowsAffected = stmt.executeUpdate(deleteSql);
                
                            // close dialog box
                            deleteDialog.dispose();
                            
                        } catch (Exception ex) {
                            System.out.println("Exception: " + ex.getMessage());
                        } finally {
                            try {
                                if (stmt != null) {
                                    stmt.close();
                                }
                            } catch (Exception ex) {
                                System.out.println("Exception: " + ex.getMessage());
                            }
                        }
                    }
                });
                deletePanel.add(submitButton);

                 // show dialog box
                deleteDialog.pack();
                deleteDialog.setLocationRelativeTo(dialog);
                deleteDialog.setVisible(true);
        
            }  
        });

        moveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // create dialog box
                JDialog moveDialog = new JDialog(dialog, "Move Treatment Start Hours", true);
                JPanel movePanel = new JPanel(new GridLayout(0, 2));
                moveDialog.add(movePanel);
                
                // get all treatments from the database
                ArrayList<String> treatments = new ArrayList<String>();
                try {
                    Statement stmt = dbConnect.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT a.AnimalNickname, t.Description, tr.StartHour FROM ANIMALS a, TASKS t, TREATMENTS tr WHERE a.AnimalID = tr.AnimalID AND t.TaskID = tr.TaskID");
                    while (rs.next()) {
                        String animalNickname = rs.getString("AnimalNickname");
                        String taskDescription = rs.getString("Description");
                        int startHour = rs.getInt("StartHour");
                        treatments.add(animalNickname + "; " + taskDescription + " @ " + startHour + ":00");
                    }
                    rs.close();
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                // create dropdown list of treatments
                JComboBox<String> treatmentDropdown = new JComboBox<String>(treatments.toArray(new String[0]));
                movePanel.add(new JLabel("Treatments: "));
                movePanel.add(treatmentDropdown);
                
                // create dropdown list of start hours
                JComboBox<Integer> startHourDropDown = new JComboBox<Integer>();
                for (int i = 0; i <= 23; i++) {
                    startHourDropDown.addItem(i);
                }
                movePanel.add(new JLabel("Choose NEW Start Hour: "));
                movePanel.add(startHourDropDown);
                
                // create submit button
                JButton submitButton = new JButton("Submit");
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        schedule = null;
                        outputArea.setText("Treatment moved. Please generate a schedule to see the new treatment");
                        // get selected treatment and start hour
                        String selectedTreatment = (String) treatmentDropdown.getSelectedItem();
                        int selectedStartHour = (int) startHourDropDown.getSelectedItem();
                        String[] parts = selectedTreatment.split("; | @ ");
                        String animalNickname = parts[0];
                        String taskDescription = parts[1];
                        int startHour = Integer.parseInt(parts[2].split(":")[0]);
                        
                        // update start hour in the database
                        try {
                            PreparedStatement stmt = dbConnect.prepareStatement("UPDATE TREATMENTS SET StartHour = ? WHERE AnimalID = (SELECT AnimalID FROM ANIMALS WHERE AnimalNickname = ?) AND TaskID = (SELECT TaskID FROM TASKS WHERE Description = ?) AND StartHour = ?");
                            stmt.setInt(1, selectedStartHour);
                            stmt.setString(2, animalNickname);
                            stmt.setString(3, taskDescription);
                            stmt.setInt(4, startHour);
                            stmt.executeUpdate();
                            stmt.close();

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        
                        // close dialog box
                        moveDialog.dispose();
                    }
                });
                movePanel.add(submitButton);
                
                // show dialog box
                moveDialog.pack();
                moveDialog.setLocationRelativeTo(dialog);
                moveDialog.setVisible(true);
            }
        });
    }    

    /**
     * Performs corresponding actions according to the ActionEvent triggered by the user.
     * @param action
     * @return none
     */
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == generateBtn) {
             // generate schedule
            //if backup volunteers are needed, generate pop up prompt to remind user to confirm/call the backup volunteer
            generateSchedule();
        
        } else if (action.getSource() == printBtn) {
            if (schedule == null) {
                outputArea.setText("Please generate a schedule first!");
                return;
            }
            
            String formattedSchedule = Scheduler.getFormatted(schedule.getDailyTasks());
            scheduler.printFile(formattedSchedule);
            outputArea.setText("Schedule printed to file!");
        } else if (action.getSource() == editTaskBtn) {    
            openEditDialog();
        }
    }

    /**
     * Generates a Schedule object 
     */
    private void generateSchedule(){
        scheduler.setOverallTasks(new ArrayList<Task>());
        scheduler.treatmentTasks();
        scheduler.feedingTasks();
        scheduler.cleaningTasks();
        try{
            schedule = new Schedule(scheduler.getOverallTasks());
            String formattedSchedule = Scheduler.getFormatted(schedule.getDailyTasks());
            outputArea.setText(formattedSchedule);
        }
        catch (TaskOverflowException ex){
            outputArea.setText(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        catch (Exception ex){
            outputArea.setText(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if(scheduler.getNumBackupVolunteers() > 0){
            JOptionPane.showMessageDialog(null,scheduler.getNumBackupVolunteers() + " Backup volunteer(s) needed ");
        }
    }

    /**
     * main() method calls the SchedulerGUI constructor
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) {
        new SchedulerGUI();
    }

}
