package edu.ucalgary.oop;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Scheduler {
    private Connection dbConnect;

    // private ArrayList<Task> allTasks = new ArrayList<Task>();

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

    public void selectTasks() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();

            String table = "SELECT ANIMALS.AnimalNickname, ANIMALS.AnimalSpecies, TASKS.Description, TASKS.Duration, TASKS.MaxWindow, TREATMENTS.StartHour\n";
            table += "FROM TREATMENTS\n";
            table += "JOIN ANIMALS ON TREATMENTS.AnimalID = ANIMALS.AnimalID\n";
            table += "JOIN TASKS ON TREATMENTS.TaskID = TASKS.TaskID;";
    
            results = myStmt.executeQuery(table);
            
            while (results.next()){
                System.out.print(results.getString("AnimalNickname") + " ");
                System.out.print(results.getString("AnimalSpecies") + " ");
                System.out.print(results.getString("Description") + " ");
                System.out.print(results.getString("Duration") + " ");
                System.out.print(results.getString("MaxWindow") + " ");
                System.out.print(results.getString("StartHour") + " ");
                System.out.println("");

            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    

    public static void main(String[] args) {
        
        Scheduler scheduler = new Scheduler();
        scheduler.createConnection();

        scheduler.selectTasks();
        


    }


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