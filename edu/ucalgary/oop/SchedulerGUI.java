import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class schedulerGUI extends JFrame implements ActionListener {
    private JButton generateBtn, printBtn, addTaskBtn;
    private JTextArea outputArea;
    private Connection connectDB;

    public schedulerGUI() {
        super("EWR Scheduler");

        generateBtn = new JButton("Generate Schedule");
        printBtn = new JButton("Print to .txt File");
        editTaskBtn = new JButton("Edit Tasks");
        outputArea = new JTextArea(20, 50);

        JPanel panel = new JPanel();
        panel.add(generateBtn);
        panel.add(printBtn);
        panel.add(addTaskBtn);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        generateBtn.addActionListener(this);
        printBtn.addActionListener(this);
        addTaskBtn.addActionListener(this);

        try {
            // connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectDB = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "root", "password");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateBtn) {
            // generate schedule
            //if backup volunteers are need, generate pop up prompt to remind user to confirm/call the backup volunteer
            outputArea.setText("Schedule generated!");
        } else if (e.getSource() == printBtn) {
            // print schedule to .txt file
            outputArea.setText("Schedule printed to file!");
        } else if (e.getSource() == addTaskBtn) {
            // add/delete/move task in SQL database
            outputArea.setText("Tasks Edited!");
        }
    }

    public static void main(String[] args) {
        new schedulerGUI();
    }
}