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
        Connection dbConnect = scheduler.getDbConnect();

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
        JButton addButton = new JButton("ADD");
        JButton deleteButton = new JButton("DELETE");
        panel.add(addButton);
        panel.add(deleteButton);
        
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
            } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
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
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
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
            }
        });
        
        // show dialog box
        dialog.setSize(200, 100);
        dialog.setVisible(true);
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
