package edu.ucalgary.oop;

public abstract class Animal {
    String animalNickname;
    int numAnimals;

    public Animal(String animalNickname, int numAnimals) throws IllegalArgumentException {
        if (numAnimals < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        this.animalNickname = animalNickname;
        this.numAnimals = numAnimals;
    }

    public String getAnimalNickname() {
        return animalNickname;
    }

    public int getNumAnimals() {
        return numAnimals;
    }

    public void setAnimalNickname(String animalNickname) {
        this.animalNickname = animalNickname;
    }

    public void setNumAnimals(int numAnimals) {
        this.numAnimals = numAnimals;
    }
    
    
}
