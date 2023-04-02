package edu.ucalgary.oop;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.jar.Attributes.Name;

/**
 * Class that creates tasks
 * @author Tony
 * @version 1.0
 * @since 1.0
 */

public class Scheduler {
    private Connection dbConnect;

    private ArrayList<Task> overallTasks = new ArrayList<Task>();

    public ArrayList<Task> getOverallTasks() {
        return overallTasks;
    }

    HashMap<String, ArrayList<Integer>> feedingTime = new HashMap<String, ArrayList<Integer>>() {{
        // [preparation, duration, startHour]
        put("fox", new ArrayList<Integer>(Arrays.asList(5, 5, 0)));
        put("raccoon", new ArrayList<Integer>(Arrays.asList(0, 5, 0)));
        put("beaver", new ArrayList<Integer>(Arrays.asList(0, 5, 8)));
        put("porcupine", new ArrayList<Integer>(Arrays.asList(0, 5, 19)));
        put("coyote", new ArrayList<Integer>(Arrays.asList(10, 5, 19)));
    }};

    HashMap<String, Integer> cleaningTime = new HashMap<String, Integer>() {{
        put("fox", 5);
        put("raccoon", 5);
        put("beaver", 5);
        put("porcupine", 10);
        put("coyote", 5);
    }};

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

    /**
     * Add treatment tasks to the overall tasks
     * @param none
     * @return none
     */
    public void treatmentTasks() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();

            String table = "SELECT ANIMALS.AnimalNickname, ANIMALS.AnimalSpecies, TASKS.Description, TASKS.Duration, TASKS.MaxWindow, TREATMENTS.StartHour\n";
            table += "FROM TREATMENTS\n";
            table += "JOIN ANIMALS ON TREATMENTS.AnimalID = ANIMALS.AnimalID\n";
            table += "JOIN TASKS ON TREATMENTS.TaskID = TASKS.TaskID;";
    
            results = myStmt.executeQuery(table);
            
            while (results.next()){
                // System.out.print(results.getString("AnimalNickname") + " ");
                // System.out.print(results.getString("AnimalSpecies") + " ");
                // System.out.print(results.getString("Description") + " ");
                // System.out.print(results.getString("Duration") + " ");
                // System.out.print(results.getString("MaxWindow") + " ");
                // System.out.print(results.getString("StartHour") + " ");
                // System.out.println("");
                
                Task singleTask = new Task(
                results.getString("Description"),
                Integer.parseInt(results.getString("Duration")),
                Integer.parseInt(results.getString("MaxWindow")),
                Integer.parseInt(results.getString("StartHour")),
                createAnimal(results.getString("AnimalSpecies"), results.getString("AnimalNickname"))
                );
            
                overallTasks.add(singleTask);
            
            }
            
            myStmt.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

        // for (Task task : overallTasks) {
        //     System.out.println(task.getAnimal().getAnimalNickname());
        // }
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
     * @param none
     * @return none
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
                // System.out.print(results.getString("AnimalNickname") + " ");
                // System.out.print(results.getString("AnimalSpecies") + " ");
                // System.out.println();

                if (animalGroups.containsKey(results.getString("AnimalSpecies"))) {
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
            catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }

    }

     /**
     * Add cleaning tasks to the overall tasks
     * @param none
     * @return none
     */
    public void cleaningTasks() {
        ResultSet results;

        try {                    
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM ANIMALS");
            
            while (results.next()){
                // System.out.print(results.getString("AnimalNickname") + " ");
                // System.out.print(results.getString("AnimalSpecies") + " ");
                // System.out.println("");

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
        catch (IllegalAccessException ex) {
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

        outputString = "Schedule for " + LocalDate.now().plusDays(1).toString() + "\n";

        for (ArrayList<Task> hourlyTasks : dailyTasks) {
            if (hourlyTasks.size() != 0) {
                if (Schedule.timeUsed(hourlyTasks) > 60) {
                    outputString += "\n" + String.valueOf(hourlyTasks.get(0).getStartHour()) + ":00 [+ backup volunteer]\n";
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

    public static void main(String[] args) {
        
        Scheduler scheduler = new Scheduler();
        scheduler.createConnection();

        // Create and add tasks to arraylist
        scheduler.treatmentTasks();
        scheduler.feedingTasks();
        scheduler.cleaningTasks();

        // for (Task task : scheduler.getOverallTasks()) {
        //     System.out.println(task.getDescription());
        // }
        
        Schedule schedule = new Schedule(scheduler.getOverallTasks());
        String formattedSchedule = getFormatted(schedule.getDailyTasks());
        System.out.println(formattedSchedule);
    }
}