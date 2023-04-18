package persistance;

import model.HouseOfPets;
import model.Pet;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            HouseOfPets hp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyHOP() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyHOP.json");
        try {
            HouseOfPets hp = reader.read();
            assertEquals(0, hp.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralHOP() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralHOP.json");
        try {
            HouseOfPets hp = reader.read();
            List<Pet> pets = hp.getMyPets();
            assertEquals(1, pets.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}