package model;
// Represents a single pet and its performable actions

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pet {
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
        return true;

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<PetAction> getPetActions() {
        return this.petactions;
    }


}
