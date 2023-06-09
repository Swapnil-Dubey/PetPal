package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Represents a single pet and its performable actions
public class Pet implements Writable {
    String name;
    Double age;
    String breed;
    Double weight;
    String typeofpet;
    ArrayList<PetAction> petactions = new ArrayList<>();
    Date currentdate = new Date();
    SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss");

    // REQUIRES: name atleast 1 character, age > 0, breed atleast 1 character, weight > 0
    // EFFECTS: sets name, age, typeofpet. breed, weight of current pet
    public Pet(String petname, Double petage, String typeofpet, String petbreed, Double petweight) {
        this.age = petage;
        this.name = petname;
        this.breed = petbreed;
        this.weight = petweight;
        this.typeofpet = typeofpet;
    }

    // MODIFIES: this
    // EFFECTS: Records a playing action done with the pet
    public boolean playWith() {
        PetAction playingaction = new PetAction(name, "Playing", timeformat.format(currentdate));
        this.petactions.add(playingaction);
        EventLog.getInstance().logEvent(new Event("Played with Pet: " + this.getName()));
        return true;
    }

    // MODIFIES: this
    // EFFECTS: Records a giving water action done with the pet
    public boolean giveWater() {
        PetAction wateraction = new PetAction("", "", "");
        wateraction.setPetname(this.name);
        wateraction.setActionperformed("Giving Water");
        wateraction.setTimeofaction(timeformat.format(currentdate));
        this.petactions.add(wateraction);
        EventLog.getInstance().logEvent(new Event("Gave Water to Pet: " + this.getName()));

        return true;

    }

    // MODIFIES: this
    // EFFECTS: Records a giving food action done with the pet
    public boolean giveFood() {
        PetAction foodaction = new PetAction("", "", "");
        foodaction.setPetname(this.name);
        foodaction.setActionperformed("Giving Food");
        foodaction.setTimeofaction(timeformat.format(currentdate));
        this.petactions.add(foodaction);
        EventLog.getInstance().logEvent(new Event("Gave Food to Pet: " + this.getName()));

        return true;

    }

    // MODIFIES: this
    // EFFECTS: Records a giving treats action done with the pet
    public boolean giveTreats() {
        PetAction treataction = new PetAction("", "", "");
        treataction.setPetname(this.name);
        treataction.setActionperformed("Giving Treats");
        treataction.setTimeofaction(timeformat.format(currentdate));
        this.petactions.add(treataction);
        EventLog.getInstance().logEvent(new Event("Gave Treats to Pet: " + this.getName()));

        return true;

    }

    // MODIFIES: this
    // EFFECTS: Records a walking action done with the pet
    public boolean takeforaWalk() {
        PetAction walkingaction = new PetAction("", "", "");
        walkingaction.setPetname(this.name);
        walkingaction.setActionperformed("Walking");
        walkingaction.setTimeofaction(timeformat.format(currentdate));
        this.petactions.add(walkingaction);
        EventLog.getInstance().logEvent(new Event("Took Pet: " + this.getName() + " for a walk."));

        return true;

    }

    // MODIFIES: this
    // EFFECTS: Records a training action done with the pet
    public boolean train() {
        PetAction trainingaction = new PetAction("", "", "");
        trainingaction.setPetname(this.name);
        trainingaction.setActionperformed("Training");
        trainingaction.setTimeofaction(timeformat.format(currentdate));
        this.petactions.add(trainingaction);
        EventLog.getInstance().logEvent(new Event("Trained Pet: " + this.getName()));

        return true;

    }

    // MODIFIES: this
    // EFFECTS: Records a grooming action done with the pet
    public boolean groom() {
        PetAction groomingaction = new PetAction("", "", "");
        groomingaction.setPetname(this.name);
        groomingaction.setActionperformed("Grooming");
        groomingaction.setTimeofaction(timeformat.format(currentdate));
        this.petactions.add(groomingaction);
        EventLog.getInstance().logEvent(new Event("Groomed Pet: " + this.getName()));

        return true;

    }

    // MODIFIES: this
    // EFFECTS: parses PetActions from JSON object and adds them to this.petactions
    public void updateActionsJson(JSONArray j) {
        for (Object json : j) {
            JSONObject nextAction = (JSONObject) json;
            addAction(this, nextAction);
        }
    }

    // MODIFIES: this
    // EFFECTS: parses PetAction from JSON object and adds it to this.petactions
    private void addAction(Pet p, JSONObject jsonObject) {
        String name = jsonObject.getString("petname");
        String actionp = jsonObject.getString("actionPerformed");
        String timeofactionp = jsonObject.getString("timeOfAction");
        PetAction action = new PetAction(name, actionp, timeofactionp);
        p.petactions.add(action);
    }

    // Modifies: this
    // EFFECTS: adds all petactions from the given ArrayList into this.petactions
    public void updateActions(ArrayList<PetAction> pa) {
        this.petactions.addAll(pa);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<PetAction> getPetActions() {
        return this.petactions;
    }

    public String getTypeofpet() {
        return this.typeofpet;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("breed", breed);
        json.put("weight", weight);
        json.put("typeofpet", typeofpet);
        json.put("petactions", petactions);
        EventLog.getInstance().logEvent(new Event("Converted pet to JSON format for saving locally"));

        return json;
    }
}
