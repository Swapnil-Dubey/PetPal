package ui;

import model.HouseOfPets;
import model.Pet;

import javax.swing.*;
import java.awt.*;
import java.util.List;


// Represents all functionality for showing all pets in GUI form of PetPal.
public class ShowPetsPanel {
    // EFFECTS: Displays the names and images of all pets stored in hop.
    public void showPets(HouseOfPets hop) {
        JFrame petFrame = new JFrame("All Pets");
        JPanel petPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        petPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        List<String> petNames = hop.getPetNames();
        for (String petName : petNames) {
            JPanel petInfoPanel = new JPanel(new BorderLayout());
            petInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel petNameLabel = new JLabel(petName, SwingConstants.CENTER);
            petNameLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
            petInfoPanel.add(petNameLabel, BorderLayout.NORTH);

            ImageIcon petImageIcon;
            String petImageFileName;
            petImageFileName = getAppropriateImagePath(hop.getPetObject(petName));

            petImageIcon = new ImageIcon(petImageFileName);

            JLabel petImageLabel = new JLabel(petImageIcon);
            petImageLabel.setPreferredSize(new Dimension(petImageIcon.getIconWidth(), petImageIcon.getIconHeight()));
            petInfoPanel.add(petImageLabel, BorderLayout.CENTER);


            petPanel.add(petInfoPanel);

        }

        petFrame.add(petPanel);
        petFrame.pack();
        petFrame.setLocationRelativeTo(null);
        petFrame.setVisible(true);
    }

    // EFFECTS: Returns the appropriate image path for the given pet type.
    private String getAppropriateImagePath(Pet p) {
        if (p.getTypeofpet().equalsIgnoreCase("dog")) {
            return "src/main/images/dog.jpg";
        } else if (p.getTypeofpet().equalsIgnoreCase("cat")) {
            return "src/main/images/cat.jpg";
        } else {
            return "src/main/images/animals.jpg";
        }

    }
}
