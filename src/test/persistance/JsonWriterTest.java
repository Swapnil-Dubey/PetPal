package persistance;

import model.HouseOfPets;
import model.Pet;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Source: Modelled tests based on JsonReaderTest.java class of JsonSerializationDemo

class JsonWriterTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            HouseOfPets wr = new HouseOfPets();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyHOP() {
        try {
            HouseOfPets hp = new HouseOfPets();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyHOP.json");
            writer.open();
            writer.write(hp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyHOP.json");
            HouseOfPets hp1 = reader.read();
            assertEquals(0, hp1.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralHOP() {
        try {
            HouseOfPets hp = new HouseOfPets();
            Pet practicepet = new Pet("abc", 12.0, "dog", "labra", 12.0);
            hp.addPet(practicepet);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralHOP.json");
            writer.open();
            writer.write(hp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralHOP.json");
            HouseOfPets hp1 = reader.read();
            List<Pet> pets = hp.getMyPets();
            assertEquals(1, pets.size());
            assertEquals(practicepet, pets.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}