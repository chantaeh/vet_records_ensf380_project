package edu.ucalgary.oop;

/* 
 * Task class
 *
 */
public class Task {
    private String description;
    private int duration;
    private int maxWindow;
    private int startHour;
    private Animal animal;

    /*
     * Constructor for Task class
     * @param description
     * @param duration
     * @param maxWindow
     * @param startHour
     * @param animal
     * @throws IllegalAccessException
     */

    public Task(String description, int duration, int maxWindow, int startHour, Animal animal) throws IllegalAccessException {
        
        if (duration < 0 || maxWindow < 0 || startHour < 0 || startHour > 23) {
            throw new IllegalAccessException("Invalid input");
        }

        this.description = description;
        this.duration = duration;
        this.maxWindow = maxWindow;
        this.startHour = startHour;
        this.animal = animal;
    }
    
    /*
     * Getter for description
     * @return description
     */
    public String getDescription() {
        return description;
    }
    
    /*
     * Getter for duration
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /*
     * Getter for maxWindow
     * @return maxWindow
     */
    public int getMaxWindow() {
        return maxWindow;
    }

    /*
     * Getter for startHour
     * @return startHour
     */
    public int getStartHour() {
        return startHour;
    }

    /*
     * Getter for animal
     * @return animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /*
     * Setter for description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * Setter for duration
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /*
     * Setter for maxWindow
     * @param maxWindow
     */
    public void setMaxWindow(int maxWindow) {
        this.maxWindow = maxWindow;
    }

    /*
     * Setter for startHour
     * @param startHour
     */
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    /*
     * Setter for animal
     * @param animal
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
