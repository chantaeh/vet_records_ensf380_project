package edu.ucalgary.oop;

import java.sql.*;
import java.util.ArrayList;

public class Scheduler {
    private Connection dbConnect;

    public Scheduler() {
        
    }

    public void createConnection(){
                
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "username", "password");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public String selectTreatments() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();
            // results = myStmt.executeQuery("SELECT * FROM ANIMALS");
            // results = myStmt.executeQuery("SELECT * FROM TASKS");
            results = myStmt.executeQuery("SELECT * FROM TREATMENTS");
            
            while (results.next()){
                
                // System.out.print(results.getString("AnimalID") + " ");
                // System.out.print(results.getString("AnimalNickname") + " ");
                // System.out.print(results.getString("AnimalSpecies") + " ");
                // System.out.println("");

                // System.out.print(results.getString("TaskID") + " ");
                // System.out.print(results.getString("Description") + " ");
                // System.out.print(results.getString("Duration") + " ");
                // System.out.print(results.getString("MaxWindow") + " ");
                // System.out.println("");
                
                System.out.print(results.getString("TreatmentID") + " ");
                System.out.print(results.getString("AnimalID") + " ");
                System.out.print(results.getString("TaskID") + " ");
                System.out.print(results.getString("StartHour") + " ");
                System.out.println("");
                
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }    

    public static String getFormatted(ArrayList<ArrayList<Task>> overallTasks) {
        String outputString = "";
        return outputString;
    }

    public static void main(String[] args) {
        
        Scheduler scheduler = new Scheduler();

        scheduler.createConnection();

        String allTreatments = scheduler.selectTreatments();
        
    }


}