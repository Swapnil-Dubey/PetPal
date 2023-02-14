package ui;

import model.HouseOfPets;
import model.Pet;
import model.PetAction;

import java.util.ArrayList;
import java.util.Scanner;

// Pet-Care tracking application
// Source: took help from AccountNotRobust-TellerApp.java for creating this PetApp UI
public class PetApp {
    private final HouseOfPets myhouse = new HouseOfPets(10);
    private Scanner input;


    // EFFECTS: runs the Pet application
    public PetApp() {
        runPet();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPet() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            addPet();
        } else if (command.equals("r")) {
            removePet();
        } else if (command.equals("a")) {
            actionPet();
        } else if (command.equals("s")) {
            showPets();
        } else if (command.equals("h")) {
            history();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {

        Pet dogPet = new Pet("Max", 2.0, "Dog", "Bulldog", 23.0);
        Pet catPet = new Pet("October", 1.5, "Cat", "Ragdoll", 9.07);
        HouseOfPets hops = new HouseOfPets(10);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd -> add a pet to house");
        System.out.println("\tr -> remove a pet from house");
        System.out.println("\ta -> perform an action with the pet");
        System.out.println("\ts -> show names of all the pets currently stored in the house");
        System.out.println("\th -> show history of actions with a pet");
        System.out.println("\tq -> quit");
    }

    // REQUIRES: input age and weight should be > 0, type double and name, type, breed should have 1 character minimum.
    // MODIFIES: myhouse
    // EFFECTS: adds a Pet object to our house of pets.
    private void addPet() {
        System.out.println("\n Enter the name of the pet: ");
        String name = input.next();
        System.out.println("\n Enter the age of the pet: ");
        Double age = input.nextDouble();
        System.out.println("\n Enter the type of the pet: ");
        String type = input.next();
        System.out.println("\n Enter the breed of the pet: ");
        String breed = input.next();
        System.out.println("\n Enter the weight of the pet: ");
        Double weight = input.nextDouble();
        Pet mypet = new Pet(name, age, type, breed, weight);
        myhouse.getMyPets().add(mypet);
    }

    // MODIFIES: myhouse
    // EFFECTS: Removes a pet from the house, if present
    private void removePet() {
        Pet chosenpet = selectFromPets();
        if (!chosenpet.getName().equals("")) {
            String nameofremovingpet = chosenpet.getName();
            myhouse.removePet(chosenpet);
            System.out.println("\n" + nameofremovingpet + " removed.");
        } else {
            System.out.println("Valid pet not chosen");
        }

    }

    // REQUIRES: Atleast one pet in myhouse.pets
    // EFFECTS: Prints out the names of pets in myhouse
    private void showPets() {
        for (int i = 0; i < myhouse.getMyPets().size(); i++) {
            System.out.println("Pet: " + myhouse.getMyPets().get(i).getName());
        }
    }

    // EFFECTS: prompts the user to choose a pet and then interact with it
    private void actionPet() {
        Pet chosenpet = selectFromPets();
        if (!chosenpet.getName().equals("")) {
            performAction(chosenpet);
        } else {
            System.out.println("Valid pet not chosen.");
        }

    }

    // EFFECTS: makes sure the user has chosen a valid pet, then calls evaluateActions with chosen pet, otherwise false
    private void history() {
        Pet chosenpet = selectFromPets();
        if (!chosenpet.getName().equals("")) {
            evaluateActions(chosenpet.getPetActions());
        } else {
            System.out.println("Valid pet not chosen.");
        }

    }

    // EFFECTS: prompts the user for performing an action from the list of actions with the chosen pet
    private void performAction(Pet p) {
        String command;

        System.out.println("What action do you want to perform with " + p.getName() + ": ");
        System.out.println("\nSelect from:");
        System.out.println("\tp -> Play with " + p.getName());
        System.out.println("\twt -> Give Water to " + p.getName());
        System.out.println("\tf -> Give food to " + p.getName());
        System.out.println("\tt -> Give treats to " + p.getName());
        System.out.println("\tw -> Take " + p.getName() + " for a walk.");
        System.out.println("\ttr -> Train " + p.getName());
        System.out.println("\tg -> Groom " + p.getName());

        command = input.next();
        command = command.toLowerCase();
        processAction(command, p);

    }

    // REQUIRES: pa should not be empty
    // EFFECTS: Prints out history of actions performed with a pet
    private void evaluateActions(ArrayList<PetAction> pa) {
        for (PetAction a : pa) {
            System.out.println(a.getActionPerformed() + " at time: " + a.getTimeOfAction());
        }
    }


    // EFFECTS: returns the chosen pet according to the numbering of pets
    private Pet selectFromPets() {
        if (myhouse.getMyPets().size() != 0) {
            for (int i = 0; i < myhouse.getMyPets().size(); i++) {
                System.out.println("\n" + (i + 1) + "." + myhouse.getMyPets().get(i).getName());
            }
            System.out.println("\n Enter the number of the pet that you want to choose: ");
            int petnum = input.nextInt();
            if (petnum >= 1 && petnum <= myhouse.getMyPets().size()) {
                return myhouse.getMyPets().get(petnum - 1);
            } else {
                System.out.println("Please choose an appropriate number from the given list.");
            }
        } else {
            System.out.println("No pets in the house.");
        }
        return new Pet("", 1.0, "", "", 1.0);
    }

    // MODIFIES: p
    // EFFECTS: Performs the chosen action with the pet. Prints a reaction
    private void processAction(String command, Pet p) {
        if (command.equals("p")) {
            p.playWith();
        } else if (command.equals("wt")) {
            p.giveWater();
        } else if (command.equals("f")) {
            p.giveFood();
        } else if (command.equals("t")) {
            p.giveTreats();
        } else if (command.equals("w")) {
            p.takeforaWalk();
        } else if (command.equals("tr")) {
            p.train();
        } else if (command.equals("g")) {
            p.groom();
        } else {
            System.out.println("Please enter a valid response.");
            performAction(p);
        }
    }
}

