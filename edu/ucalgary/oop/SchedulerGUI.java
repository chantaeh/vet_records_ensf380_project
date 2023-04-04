package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SchedulerGUI extends JFrame implements ActionListener {
    private JButton generateBtn, printBtn, editTaskBtn;
    private JTextArea outputArea;
    private Connection connectDB;

    
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
        /* commented out to test gui itself for now
        try {
            // connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectDB = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "root", "password");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        */

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

            // add/delete/move task in SQL database
            outputArea.setText("Tasks Edited!");
        }
    }

    public static void main(String[] args) {
        new SchedulerGUI();
    }
}
