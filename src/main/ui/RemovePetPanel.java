package ui;

import model.HouseOfPets;
import model.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Represents all functionality for removing a pet in GUI form of PetPal.

public class RemovePetPanel {
    GridBagConstraints constraints;
    JPanel removePetPanel;
    JButton removeButton;
    JComboBox<String> petCombo;
    JFrame popup;

    // EFFECTS: Sets the positioning of options to select the pet user wants to remove.
    public void removePet(HouseOfPets hop) {
        popup = new JFrame("Remove a Pet");
        removePetPanel = new JPanel(new GridBagLayout());
        ArrayList<String> petNames = new ArrayList<>();
        for (Pet pet : hop.getMyPets()) {
            petNames.add(pet.getName());
        }
        petCombo = new JComboBox<>(petNames.toArray(new String[0]));
        setPositions(hop);
        popup.add(removePetPanel);
        popup.pack();
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);
    }

    // MODIFIES: hop
    // EFFECTS: Gives the user an option to select the pets they want to remove and removes it from hop.
    private JButton createRemoveButton(JFrame popup, JComboBox<String> petCombo, HouseOfPets hop) {
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
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
                    hop.removePet(selectedPet);
                    JOptionPane.showMessageDialog(popup, "Pet " + selectedPetName + " removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(popup, "Pet not found.");
                }
                popup.dispose();
            }
        });
        return removeButton;
    }

    // MODIFIES: removePetPanel
    // EFFECTS: sets positioning of label ad remove button in the popup shown for removing pets.
    private void setPositions(HouseOfPets hop) {
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        removePetPanel.add(new JLabel("Select a pet to remove:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        removePetPanel.add(petCombo, constraints);
        removeButton = createRemoveButton(popup, petCombo, hop);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 10, 10, 10);
        removePetPanel.add(removeButton, constraints);
    }
}
