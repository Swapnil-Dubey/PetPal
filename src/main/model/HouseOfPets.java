package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents all the pets currently owned by the user, with no duplicates
public class HouseOfPets implements Writable {
    private ArrayList<Pet> pets;
    private ArrayList<String> petNames;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

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
                EventLog.getInstance().logEvent(new Event("Removed Pet: " + p.getName()));
                return true;
            }
        }
        return false;
    }

    // REQUIRES: same pet not already in pets
    // MODIFIES: this
    // EFFECTS: adds a given Pet p to this.pets
    public boolean addPet(Pet p) {
        this.pets.add(p);
        EventLog eventLog = EventLog.getInstance();
        eventLog.logEvent(new Event("Added Pet: " + p.getName()));
        return true;
    }

    public int getSize() {
        return this.pets.size();
    }


    public ArrayList<Pet> getMyPets() {
        return this.pets;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("pets", petsToJson());
        EventLog eventLog = EventLog.getInstance();
        eventLog.logEvent(new Event("Put the jsonArray of pets into JSON object"
                + " for saving locally"));

        return json;
    }

    // EFFECTS: returns pets in this HouseOfPets as a JSON array
    private JSONArray petsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Pet p : pets) {
            jsonArray.put(p.toJson());
        }
        EventLog eventLog = EventLog.getInstance();
        eventLog.logEvent(new Event("Created a JSON array of all pets in HouseOfPets "
                + "for saving locally"));

        return jsonArray;
    }


    // MODIFIES: this
    // EFFECTS: Creates a list of names of all the pets stored in current HouseOfPets.
    public List<String> getPetNames() {
        petNames = new ArrayList<>();
        for (Pet p: getMyPets()) {
            petNames.add(p.getName());
        }
        EventLog eventLog = EventLog.getInstance();
        eventLog.logEvent(new Event("Created a list of Pet Names to be shown on screen"));
        return petNames;
    }
    // REQUIRES: The Pet with given name should be present in house of pets
    // EFFECTS: Creates a list of names of all the pets stored in current HouseOfPets.

    public Pet getPetObject(String petName) {
        for (Pet p:this.getMyPets()) {
            if (p.getName().equals(petName)) {
                return p;
            }
        }
        return null;
    }
}
