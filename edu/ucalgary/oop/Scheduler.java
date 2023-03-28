package edu.ucalgary.oop;

import java.sql.*;
import java.time.LocalDate;
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

    public String selectAnimals() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM ANIMALS");
            
            while (results.next()) {
                System.out.print(results.getString("AnimalID") + " ");
                System.out.print(results.getString("AnimalNickname") + " ");
                System.out.print(results.getString("AnimalSpecies") + " ");
                System.out.println("");
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }    

    public String selectTasks() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();
        
            results = myStmt.executeQuery("SELECT * FROM TASKS");
            
            while (results.next()){
                System.out.print(results.getString("TaskID") + " ");
                System.out.print(results.getString("Description") + " ");
                System.out.print(results.getString("Duration") + " ");
                System.out.print(results.getString("MaxWindow") + " ");
                System.out.println("");
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }    

    public String selectTreatments() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();
    
            results = myStmt.executeQuery("SELECT * FROM TREATMENTS");
            
            while (results.next()){
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

    // public static String getFormatted(ArrayList<ArrayList<Task>> overallTasks) {
    //     String outputString = "";

    //     outputString = "Schedule for " + LocalDate.now().toString() + "\n";

    //     for (ArrayList<Task> hourlyTasks : overallTasks) {
    //         if (hourlyTasks != null) {
    //             outputString += String.valueof(hourlyTasks.get(0).getStartHour()) + ":00";

    //             for (Task task : hourlyTasks) {
    //                 if (task.getDescription() != "Feeding" && task.getDescription() != "Cage cleaning") {
    //                     outputString += "* " + task.getDescription(); 
    //                     outputString += "(" + task.getAnimal().getAnimalNickname() + ")";
    //                 }
    //                 else if (task.getDescription() == "Feeding") {
    //                     outputString += "* " + task.getDescription();
    //                     outputString += " - " + task.getclass().getName(); 
    //                     outputString += " (" + task.getAnimal().getAnimalNickname() + ")";
    //                 }
    //                 else {
    //                     outputString += "* " + task.getDescription();
    //                     outputString += " - " + task.getclass().getName(); 
    //                     outputString += " (" + task.getAnimal().getAnimalNickname() + ")";
    //                 }
    //             }
    //         }
    //     }
    //     return outputString;
    // }

    public static void main(String[] args) {
        
        Scheduler scheduler = new Scheduler();

        scheduler.createConnection();

        String allAnimals = scheduler.selectAnimals();
        String allTasks = scheduler.selectTasks();
        String allTreatments = scheduler.selectTreatments();
        

    }


}