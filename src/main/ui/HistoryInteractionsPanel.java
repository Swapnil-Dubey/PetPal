package ui;

import model.HouseOfPets;
import model.Pet;
import model.PetAction;

import javax.swing.*;
// Represents all functionality for showing history of interactions with pets in GUI form of PetPal.

public class HistoryInteractionsPanel {
    // EFFECTS: Shows the history of interactions with stored pets.
    public void historyInteractions(HouseOfPets hop) {
        StringBuilder message = new StringBuilder();
        for (Pet pet : hop.getMyPets()) {
            message.append(pet.getName()).append(": ");
            for (PetAction interaction : pet.getPetActions()) {
                message.append(interaction.getActionPerformed())
                        .append(" at ").append(interaction.getTimeOfAction()).append(", ");
            }
            message = new StringBuilder(message.substring(0, message.length() - 2));
            message.append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Interaction History", JOptionPane.INFORMATION_MESSAGE);
    }
}
