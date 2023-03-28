package edu.ucalgary.oop;

public class Task {
    private String description;
    private int duration;
    private int maxWindow;
    private int startHour;
    private Animal animal;

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

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public int getMaxWindow() {
        return maxWindow;
    }

    public int getStartHour() {
        return startHour;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setMaxWindow(int maxWindow) {
        this.maxWindow = maxWindow;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
