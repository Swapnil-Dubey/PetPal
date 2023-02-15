package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetActionTest {
    private PetAction pa;

    @BeforeEach
    public void setup() {
        pa = new PetAction("ABC", "Giving Water", "03:10:06");
    }

    @Test
    public void constructorTest() {
        assertEquals("Giving Water", pa.getActionPerformed());
        assertEquals("03:10:06", pa.getTimeOfAction());
        assertEquals("ABC", pa.getPetname());
    }


}
