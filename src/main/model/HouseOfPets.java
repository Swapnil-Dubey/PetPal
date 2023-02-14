package model;
// Represents all the pets currently owned by the user, with no duplicates


import java.util.ArrayList;

public class HouseOfPets {
    private final ArrayList<Pet> pets;
    private final int maxcapacity;

    // REQUIRES: maxcap is > 0
    // EFFECTS: Sets capacity of the HouseOfPets to maxcap. Assign pets to a new ArrayList that can only have Pet.
    public HouseOfPets(int maxcap) {
        pets = new ArrayList<>();
        this.maxcapacity = maxcap;
    }

    // REQUIRES: at least 1 pet in this.pets
    // MODIFIES: this
    // EFFECTS: removes the pet with the given name from this.pets, if it's present
    public boolean removePet(Pet pt) {
        for (Pet p : this.pets) {
            if (p == pt) {
                this.pets.remove(pt);
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
        if (this.pets.size() < maxcapacity) {
            this.pets.add(p);
            return true;
        } else {
            return false;
        }

    }

    public int getsize() {
        return pets.size();
    }

    public int getMaxCapacity() {
        return this.maxcapacity;
    }

    public ArrayList<Pet> getMyPets() {
        return this.pets;
    }
}
