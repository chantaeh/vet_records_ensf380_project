package edu.ucalgary.oop;

/**
 * Animal class
 * @author Youssef
 * @version 1.0
 * @since 1.0
 */

public class Animal {
    String animalNickname;
    int numAnimals;

    /**
     * Constructor for Animal class
     * @param animalNickname
     * @param numAnimals
     * @throws IllegalArgumentException
     */

    public Animal(String animalNickname, int numAnimals) throws IllegalArgumentException {
        if (numAnimals < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (animalNickname == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        this.animalNickname = animalNickname;
        this.numAnimals = numAnimals;
    }

    /**
     * Getter for animalNickname
     * @return animalNickname
     */

    public String getAnimalNickname() {
        return animalNickname;
    }

    /**
     * Getter for numAnimals
     * @return numAnimals
     */

    public int getNumAnimals() {
        return numAnimals;
    }

    /**
     * Setter for animalNickname
     * @param animalNickname
     */
    public void setAnimalNickname(String animalNickname) {
        this.animalNickname = animalNickname;
    }

    /**
     * Setter for numAnimals
     * @param numAnimals
     */
    public void setNumAnimals(int numAnimals) {
        this.numAnimals = numAnimals;
    }
    
}
