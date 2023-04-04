package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SchedulerGUI extends JFrame implements ActionListener {
    private JButton generateBtn, printBtn, editTaskBtn;
    private JTextArea outputArea;

    private Scheduler scheduler = new Scheduler();
    private Connection dbConnect = null;

    public SchedulerGUI() {
        super("EWR Scheduler");
        setSize(600, 400);
        setupGUI();
        setVisible(true);

        generateBtn.addActionListener(this);
        printBtn.addActionListener(this);
        editTaskBtn.addActionListener(this);
        // creating connection to database
        scheduler.createConnection();
        dbConnect = scheduler.getDbConnect();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void setupGUI() {
        generateBtn = new JButton("Generate Schedule");
        printBtn = new JButton("Print to .txt File");
        editTaskBtn = new JButton("Edit Tasks");
        outputArea = new JTextArea(20, 20);

        JPanel panel = new JPanel();
        panel.add(generateBtn);
        panel.add(printBtn);
        panel.add(editTaskBtn);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }
    
    // window that opens from the edit task button
    private void openEditDialog() {
        // create dialog box
        JDialog dialog = new JDialog(this, "Edit Tasks", true);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        dialog.add(panel);
        
        // create buttons
        JButton addButton = new JButton("Add Tasks or Treatments");
        JButton deleteButton = new JButton("delete Tasks or Treatments");
        JButton moveButton = new JButton("Move Treatment Start Hours");
        
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(moveButton);
        
        // set button action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle add button click event
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
            } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (Exception exe) {
                    System.out.println("Exception: " + exe.getMessage());
                }
            }
    
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
                    // get values from input fields
                    String description = descriptionTextArea.getText();
                    int duration = (int) durationComboBox.getSelectedItem();
                    int window = (int) windowComboBox.getSelectedItem();
                    int animalID = animalComboBox.getSelectedIndex() + 1;
                    int startHour = (int) startHourComboBox.getSelectedItem();
                    
                    // insert new task into database
                    try {
                        Statement stmt = dbConnect.createStatement();
                        String insertSql = String.format("INSERT INTO TASKS (Description, Duration, MaxWindow) VALUES ('%s', %d, %d)", description, duration, window);
                        stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
                        ResultSet rs = stmt.getGeneratedKeys();
                        int taskID = -1;
                        if (rs.next()) {
                            taskID = rs.getInt(1);
                        }
                        String insertTreatmentSql = String.format("INSERT INTO TREATMENTS (AnimalID, TaskID, StartHour) VALUES (%d, %d, %d)", animalID, taskID, startHour);
                        stmt.executeUpdate(insertTreatmentSql);
                    } catch (Exception exe) {
                        System.out.println("Exception: " + exe.getMessage());
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

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle delete button click event
                
                // create dialog box for deleting task
                JDialog deleteDialog = new JDialog(dialog, "Delete Task", true);
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
                deletePanel.add(new JLabel("Animal-Task: "));
                deletePanel.add(animalTaskComboBox);
                
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
                // handle submit button click event
        
                // get selected animal-task and task
                String animalTask = (String) animalTaskComboBox.getSelectedItem();
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
                } catch (Exception exeception) {
                    System.out.println("Exception: " + exeception.getMessage());
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (Exception exe) {
                        System.out.println("Exception: " + exe.getMessage());
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
                    
                } catch (Exception exeception) {
                    System.out.println("Exception: " + exeception.getMessage());
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (Exception exe) {
                        System.out.println("Exception: " + exe.getMessage());
                    }
                }
            }
        });
        deletePanel.add(submitButton);
        }
        
    });

        moveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // create dialog box
                JDialog dialog = new JDialog(dialog, "Move Treatment Start Hours", true);
                JPanel panel = new JPanel(new GridLayout(2, 1));
                dialog.add(panel);
                
                // get all treatments from the database
                ArrayList<String> treatments = new ArrayList<String>();
                try {
                    Statement stmt = dbConnect.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT a.AnimalNickname, t.Description, tr.StartHour FROM ANIMALS a, TASKS t, TREATMENTS tr WHERE a.AnimalID = tr.AnimalID AND t.TaskID = tr.TaskID");
                    while (rs.next()) {
                        String animalNickname = rs.getString("AnimalNickname");
                        String taskDescription = rs.getString("Description");
                        int startHour = rs.getInt("StartHour");
                        treatments.add(animalNickname + ", " + taskDescription + ", " + startHour + ":00");
                    }
                    rs.close();
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                // create dropdown list of treatments
                JComboBox<String> treatmentDropdown = new JComboBox<String>(treatments.toArray(new String[0]));
                panel.add(treatmentDropdown);
                
                // create dropdown list of start hours
                JComboBox<Integer> startHourDropDown = new JComboBox<Integer>();
                for (int i = 0; i <= 23; i++) {
                    startHourDropDown.addItem(i);
                }
                panel.add(new JLabel("Start Hour: "));
                panel.add(startHourDropDown);
                
                // create submit button
                JButton submitButton = new JButton("Submit");
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // get selected treatment and start hour
                        String selectedTreatment = (String) treatmentDropdown.getSelectedItem();
                        int selectedStartHour = (int) startHourDropDown.getSelectedItem();
                        String[] parts = selectedTreatment.split(", ");
                        String animalNickname = parts[0];
                        String taskDescription = parts[1];
                        int startHour = Integer.parseInt(parts[2].substring(0, 2));
                        
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
                        dialog.dispose();
                    }
                });
                panel.add(submitButton);
                
                // show dialog box
                dialog.pack();
                dialog.setVisible(true);
            }
        }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateBtn) {
             // generate schedule
            //if backup volunteers are needed, generate pop up prompt to remind user to confirm/call the backup volunteer
            scheduler.treatmentTasks();
            scheduler.feedingTasks();
            scheduler.cleaningTasks();
            
            Schedule schedule = new Schedule(scheduler.getOverallTasks());
            String formattedSchedule = Scheduler.getFormatted(schedule.getDailyTasks());
            outputArea.setText(formattedSchedule);
        } else if (e.getSource() == printBtn) {

            // print schedule to .txt file

            scheduler.treatmentTasks();
            scheduler.feedingTasks();
            scheduler.cleaningTasks();
            
            Schedule schedule = new Schedule(scheduler.getOverallTasks());
            String formattedSchedule = Scheduler.getFormatted(schedule.getDailyTasks());
            scheduler.printFile(formattedSchedule);
            outputArea.setText("Schedule printed to file!");
        } else if (e.getSource() == editTaskBtn) {

            openEditDialog();
            outputArea.setText("Tasks Edited!");
        }
    }

    public static void main(String[] args) {
        new SchedulerGUI();
    }
}
