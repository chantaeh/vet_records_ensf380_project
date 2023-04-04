package edu.ucalgary.oop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.jar.Attributes.Name;

/**
 * Class that creates tasks
 * @author Tony
 * @version 1.1
 * @since 1.0
 */

public class Scheduler {
    private Connection dbConnect;
    private ArrayList<String> orphanedAnimals = new ArrayList<String>();  
    private static int numBackupVolunteers = 0;

    private ArrayList<Task> overallTasks = new ArrayList<Task>();

    private HashMap<String, ArrayList<Integer>> feedingTime = new HashMap<String, ArrayList<Integer>>() {{
        // [preparation, duration, startHour]
        put("fox", new ArrayList<Integer>(Arrays.asList(Fox.getFeedingPrepMins(), 
            Fox.getFeedMins(), Fox.getFeedStartHour())));
        put("raccoon", new ArrayList<Integer>(Arrays.asList(Raccoon.getFeedingPrepMins(), 
            Raccoon.getFeedMins(), Raccoon.getFeedStartHour())));
        put("beaver", new ArrayList<Integer>(Arrays.asList(Beaver.getFeedingPrepMins(), 
            Beaver.getFeedMins(), Beaver.getFeedStartHour())));
        put("porcupine", new ArrayList<Integer>(Arrays.asList(Porcupine.getFeedingPrepMins(), 
            Porcupine.getFeedMins(), Porcupine.getFeedStartHour())));
        put("coyote", new ArrayList<Integer>(Arrays.asList(Coyote.getFeedingPrepMins(), 
            Coyote.getFeedMins(), Coyote.getFeedStartHour())));
    }};

    private HashMap<String, Integer> cleaningTime = new HashMap<String, Integer>() {{
        put("fox", Fox.getCageCleanMins());
        put("raccoon", Raccoon.getCageCleanMins());
        put("beaver", Beaver.getCageCleanMins());
        put("porcupine", Porcupine.getCageCleanMins());
        put("coyote", Coyote.getCageCleanMins());
    }};

    /**
     * Default constructor
     */
    public Scheduler() {
    }

    /**
     * Creates a connection with the mysql database
     * 
     */
    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "oop", "password");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    /**
     * Gets the overallTasks
     * @return ArrayList of Tasks
     */
    public ArrayList<Task> getOverallTasks() {
        return overallTasks;
    }

    /**
     * Add treatment tasks to the overall tasks
     */
    public void treatmentTasks() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();

            String table = "SELECT ANIMALS.AnimalNickname, ANIMALS.AnimalSpecies, TASKS.Description, TASKS.Duration, TASKS.MaxWindow, TREATMENTS.StartHour, TASKS.TaskID\n";
            table += "FROM TREATMENTS\n";
            table += "JOIN ANIMALS ON TREATMENTS.AnimalID = ANIMALS.AnimalID\n";
            table += "JOIN TASKS ON TREATMENTS.TaskID = TASKS.TaskID;";
    
            results = myStmt.executeQuery(table);
            
            while (results.next()){
                Task singleTask = new Task(
                results.getString("Description"),
                Integer.parseInt(results.getString("Duration")),
                Integer.parseInt(results.getString("MaxWindow")),
                Integer.parseInt(results.getString("StartHour")),
                createAnimal(results.getString("AnimalSpecies"), results.getString("AnimalNickname"))
                );

                if (Integer.parseInt(results.getString("TaskID")) == 1 && !orphanedAnimals.contains(results.getString("AnimalNickname"))) {
                    orphanedAnimals.add(results.getString("AnimalNickname"));
                }
            
                overallTasks.add(singleTask);
            
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }    

    /**
     * Creates an animal object based on specified species
     * @param species the animal's species
     * @param name the animal's name
     * @return animal object
     */
    public Animal createAnimal(String species, String name) {
        if (species.equals("fox")) {
            return new Fox(name, 1);
        }
        else if (species.equals("raccoon")) {
            return new Raccoon(name, 1);
        }
        else if (species.equals("beaver")) {
            return new Beaver(name, 1);
        }
        else if (species.equals("porcupine")) {
            return new Porcupine(name, 1);   
        }
        else if (species.equals("coyote")) {
            return new Coyote(name, 1);
        }
        else {
            return null;
        }
    }

    /**
     * Add feeding tasks to the overall tasks
     */
    public void feedingTasks() {
        HashMap<String, ArrayList<String>> animalGroups = new HashMap<String, ArrayList<String>>() {{
            put("fox", new ArrayList<String>());
            put("raccoon", new ArrayList<String>());
            put("beaver", new ArrayList<String>());
            put("porcupine", new ArrayList<String>());
            put("coyote", new ArrayList<String>());
        }};

        ResultSet results; 

        try {                    
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM ANIMALS");
            

            while (results.next()){
                if (!orphanedAnimals.contains(results.getString("AnimalNickname"))) {
                    animalGroups.get(results.getString("AnimalSpecies")).add(results.getString("AnimalNickname"));
                }
            }   

            myStmt.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Create grouped tasks for feeding
        for (Map.Entry<String, ArrayList<String>> entry : animalGroups.entrySet()) {
            if (animalGroups.get(entry.getKey()).size() == 0) {
                continue;
            }

            String animalNames = String.valueOf(animalGroups.get(entry.getKey()).size()) + ": ";
            for (String name : entry.getValue()) {
                animalNames += name + ", "; 
            }
            animalNames = animalNames.substring(0, animalNames.length() - 2);

            try {
                Task singleTask = new Task(
                    "Feeding",
                    feedingTime.get(entry.getKey()).get(0) + feedingTime.get(entry.getKey()).get(1)*animalGroups.get(entry.getKey()).size(),
                    3,
                    feedingTime.get(entry.getKey()).get(2),
                    createAnimal(entry.getKey(), animalNames)
                );

                overallTasks.add(singleTask);
            }
            catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }

    }

     /**
     * Add cleaning tasks to the overall tasks
     */
    public void cleaningTasks() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM ANIMALS");
            
            while (results.next()){
                Task singleTask = new Task(
                    "Cage cleaning",
                    cleaningTime.get(results.getString("AnimalSpecies")),
                    24,
                    0,
                    createAnimal(results.getString("AnimalSpecies"), results.getString("AnimalNickname"))
                );

                overallTasks.add(singleTask);
            }   

            myStmt.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates a formatted schedule
     * @param dailyTasks the arraylist containing arraylist that represent tasks in each hour
     * @return output string of the formatted schedule
     */
    public static String getFormatted(ArrayList<ArrayList<Task>> dailyTasks) {
        String outputString = "";
        numBackupVolunteers = 0;

        outputString = "Schedule for " + LocalDate.now().plusDays(1).toString() + "\n";

        for (ArrayList<Task> hourlyTasks : dailyTasks) {
            if (hourlyTasks.size() != 0) {
                if (Schedule.timeUsed(hourlyTasks) > 60) {
                    outputString += "\n" + String.valueOf(hourlyTasks.get(0).getStartHour()) + ":00 [+ backup volunteer]\n";
                    numBackupVolunteers+=1;
                }
                else {
                    outputString += "\n" + String.valueOf(hourlyTasks.get(0).getStartHour()) + ":00\n";
                }

                for (Task task : hourlyTasks) {
                    if (!task.getDescription().equals("Feeding") && !task.getDescription().equals("Cage cleaning")) {
                        outputString += "* " + task.getDescription(); 
                        outputString += " (" + task.getAnimal().getAnimalNickname() + ")\n";
                    }
                    else if (task.getDescription().equals("Feeding")) {
                        outputString += "* " + task.getDescription();
                        outputString += " - " + task.getAnimal().getClass().getSimpleName().toLowerCase(); 
                        outputString += " (" + task.getAnimal().getAnimalNickname() + ")\n";
                    }
                    else {
                        outputString += "* " + task.getDescription();
                        outputString += " (" + task.getAnimal().getAnimalNickname() + ")\n";
                    }
                }
            }
        }
        return outputString;
    }

    /**
     * Writes the given string to a text file
     * @param scheduleStr
     * @return true if the schedule was successfully printed, false otherwise
     */
    public boolean printFile(String scheduleStr) {
        BufferedWriter out = null;

        try {
            // Open a BufferedReader and write schedule to file
            out = new BufferedWriter(new FileWriter("schedule.txt"));
            
            out.write(scheduleStr, 0, scheduleStr.length());
            return true;
        } catch (IOException ioe) {
            return false;
        } finally {
            if (out != null) {
                // Close BufferedReader object
                try {
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Couldn't close file schedule.txt");
                }
            }
        }
    }

    /**
     *  Clears the overall tasks arraylist
     */
    public void clear() {
        overallTasks.clear();
    }

    /**
     * gets the number of backup volunteers needed
     * @return the number of backup volunteers needed
     */
    public int getNumBackupVolunteers() {
        return numBackupVolunteers;
    }


}