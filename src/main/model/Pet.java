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
        System.out.println("Played with " + this.getName() + ". Woohoo So fun!");
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
        System.out.println("Slurp Slurp.");
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
        System.out.println("Chomp Chomp.");
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
        System.out.println("Chomp Chomp Yum!");
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
        System.out.println("Ah So tired now!");
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
        System.out.println("Trained!");
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
        System.out.println("Brush Brush");
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
    // EFFECTS: parses thingy from JSON object and adds it to workroom
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


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("breed", breed);
        json.put("weight", weight);
        json.put("typeofpet", typeofpet);
        json.put("petactions", petactions);
        return json;
    }
}
