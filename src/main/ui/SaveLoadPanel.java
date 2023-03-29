package ui;

import model.HouseOfPets;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents all functionality for saving, loading current state in GUI form of PetPal.
public class SaveLoadPanel {
    private static final String JSON_STORE = "./data/houseofpets.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: saves the HouseOfPets to file
    public void save(HouseOfPets hop) {
        jsonWriter = new JsonWriter(JSON_STORE);
        try {
            jsonWriter.open();
            jsonWriter.write(hop);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Saved House of Pets" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: hop
    // EFFECTS: loads HouseOfPets from file
    public HouseOfPets load(HouseOfPets hop) {
        jsonReader = new JsonReader(JSON_STORE);
        try {
            hop = jsonReader.read();
            JOptionPane.showMessageDialog(null, "Loaded House of Pets" + " from " + JSON_STORE);
            return hop;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
        }
        return null;
    }
}
