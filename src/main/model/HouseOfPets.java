package model;
// Represents all the pets currently owned by the user, with no duplicates


import java.util.ArrayList;

public class HouseOfPets {
    private ArrayList<Pet> pets;

    // EFFECTS: Assign pets to a new ArrayList that can only have Pet.
    public HouseOfPets() {
        pets = new ArrayList<>();
    }

    // REQUIRES: at least 1 pet in this.pets
    // MODIFIES: this
    // EFFECTS: removes the pet with the given name from this.pets, if it's present
    public boolean removePet(Pet cp) {
        for (Pet p : this.pets) {
            if (p == cp) {
                this.pets.remove(p);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: same pet not already in pets
    // MODIFIES: this
    // EFFECTS: adds a given Pet p to this.pets, only if current count of pets < maxcapacity
    // and the same pet is not already in the list
    public boolean addPet(Pet p) {
        this.pets.add(p);
        return true;
    }

    public int getsize() {
        return this.pets.size();
    }


    public ArrayList<Pet> getMyPets() {
        return this.pets;
    }
}
