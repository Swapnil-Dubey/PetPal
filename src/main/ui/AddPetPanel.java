package ui;

import model.HouseOfPets;
import model.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents all functionality for adding pets in GUI form of PetPal.
public class AddPetPanel {
    JFrame popup;
    JPanel addPetPanel;
    JTextField nameField;
    JTextField ageField;
    JTextField typeField;
    JTextField breedField;
    JTextField weightField;
    JButton cancelButton;
    JButton addButton;

    // MODIFIES: hop
    // EFFECT: shows a popup window to add information of pet and adds the given pet to the HouseOfPets,
    public void addPet(HouseOfPets hop) {
        setups();
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popup.dispose(); // close popup window
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double age = Double.parseDouble(ageField.getText());
                String type = typeField.getText();
                String breed = breedField.getText();
                double weight = Double.parseDouble(weightField.getText());
                Pet newPet = new Pet(name, age, type, breed, weight);
                hop.addPet(newPet);
                popup.dispose();
            }
        });
        finishUp();
    }

    // EFFECTS: Sets up frames and panels, labels for the popup shown to add infromation for new pet.
    private void setups() {
        popup = new JFrame("Add a New Pet");
        addPetPanel = new JPanel(new GridLayout(0, 2));
        nameField = new JTextField(10);
        ageField = new JTextField(10);
        typeField = new JTextField(10);
        breedField = new JTextField(10);
        weightField = new JTextField(10);
        addPetPanel.add(new JLabel("Name:"));
        addPetPanel.add(nameField);
        addPetPanel.add(new JLabel("Age:"));
        addPetPanel.add(ageField);
        addPetPanel.add(new JLabel("Type:"));
        addPetPanel.add(typeField);
        addPetPanel.add(new JLabel("Breed:"));
        addPetPanel.add(breedField);
        addPetPanel.add(new JLabel("Weight:"));
        addPetPanel.add(weightField);
        cancelButton = new JButton("Cancel");
        addButton = new JButton("Add");
    }

    // EFFECTS: Sets up cancel, add buttons shown in the popup.
    private void finishUp() {
        addPetPanel.add(cancelButton);
        addPetPanel.add(addButton);
        popup.add(addPetPanel);
        popup.pack();
        popup.setVisible(true);
    }

}
