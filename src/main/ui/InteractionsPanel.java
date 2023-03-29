package ui;

import model.HouseOfPets;
import model.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Represents all functionality for interacting with pets in GUI form of PetPal.

public class InteractionsPanel {
    private HouseOfPets hop;
    JFrame popup3;
    JComboBox<String> petCombo3;
    JPanel interactionsPanel3;
    GridBagConstraints constraints;
    JComboBox<String> petCombo;
    JFrame popup;
    JPanel interactPetPanel;

    // MODIFIES: p
    // EFFECTS: Gives the user options to interact with any stored pet in any stored form of action.
    public void performInteraction(HouseOfPets hop1) {
        hop = hop1;
        popup = new JFrame("Choose a pet");
        interactPetPanel = new JPanel(new GridBagLayout());

        ArrayList<String> petNames = new ArrayList<>();
        for (Pet pet : hop.getMyPets()) {
            petNames.add(pet.getName());
        }
        petCombo = new JComboBox<>(petNames.toArray(new String[0]));

        setPositioning();
        popup.add(interactPetPanel);
        popup.pack();
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);

    }

    // MODIFIES: interactPetPanel
    // EFFECTS: Sets positions of headings, interact button in the popup shown for interactions to choose the pet to
    //          interact with.
    public void setPositioning() {
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        interactPetPanel.add(new JLabel("Select a pet to interact with:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        interactPetPanel.add(petCombo, constraints);


        JButton interactButton = createInteractButton(popup, petCombo, hop);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 10, 10, 10);
        interactPetPanel.add(interactButton, constraints);
    }

    // EFFECTS: Chooses a pet to interact with.
    private JButton createInteractButton(JFrame popup, JComboBox<String> petCombo, HouseOfPets hop) {
        JButton chooseButton = new JButton("Choose");
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPetName = (String) petCombo.getSelectedItem();
                Pet selectedPet = null;
                for (Pet pet : hop.getMyPets()) {
                    if (pet.getName().equals(selectedPetName)) {
                        selectedPet = pet;
                        break;
                    }
                }
                if (selectedPet != null) {
                    showPossibleInteractions(selectedPet);
                } else {
                    JOptionPane.showMessageDialog(popup, "Pet not found.");
                }
                popup.dispose();
            }
        });
        return chooseButton;
    }

    // EFFECTS: Setting up the buttons, dropdown for user to select actions.
    public void showPossibleInteractions(Pet p) {
        popup3 = new JFrame("Choose an action");
        interactionsPanel3 = new JPanel(new GridBagLayout());

        ArrayList<String> petActions3 = new ArrayList<>();
        petActions3.add("Play");
        petActions3.add("Give Water");
        petActions3.add("Give Food");
        petActions3.add("Give Treats");
        petActions3.add("Walk");
        petActions3.add("Train");
        petActions3.add("Groom");
        petCombo3 = new JComboBox<>(petActions3.toArray(new String[0]));
        setupPositions(p);

        popup3.add(interactionsPanel3);
        popup3.pack();
        popup3.setLocationRelativeTo(null);
        popup3.setVisible(true);

    }

    // EFFECTS: Sets up positioning of labels and buttons on the interaction panel popup
    private void setupPositions(Pet p) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        interactionsPanel3.add(new JLabel("Select an action:"), c);

        c.gridx = 1;
        c.gridy = 0;
        interactionsPanel3.add(petCombo3, c);

        JButton interactButton = createActionsButton(popup3, petCombo3, p);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 10, 10, 10);
        interactionsPanel3.add(interactButton, c);
    }

    // EFFECTS: Chooses an action to be performed with the selected pet.
    private JButton createActionsButton(JFrame popup, JComboBox<String> petCombo, Pet p) {
        JButton chooseButton = new JButton("Choose");
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAction = (String) petCombo.getSelectedItem();
                showPossibleInteractions(p);
                JOptionPane.showMessageDialog(popup, "Action: " + selectedAction + " performed successfully!");
                popup.dispose();
                performCorrespondingAction(selectedAction, p);
            }
        });
        return chooseButton;
    }

    // MODIFIES: p
    // EFFECTS: Performs the selected action on the selected pet.
    private void performCorrespondingAction(String selectedAction, Pet p) {
        if (selectedAction.equals("Play")) {
            p.playWith();
        } else if (selectedAction.equals("Give Water")) {
            p.giveWater();
        } else if (selectedAction.equals("Give Food")) {
            p.giveFood();
        } else if (selectedAction.equals("Give Treats")) {
            p.giveTreats();
        } else if (selectedAction.equals("Walk")) {
            p.takeforaWalk();
        } else if (selectedAction.equals("Train")) {
            p.train();
        } else if (selectedAction.equals("Groom")) {
            p.groom();
        } else {
            System.out.println("Please enter a valid response.");
        }
    }
}
