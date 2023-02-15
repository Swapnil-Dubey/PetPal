package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseOfPetsTest {
    private HouseOfPets mypets;
    private Pet p;
    private Pet p1;


    @BeforeEach
    public void setup() {
        Pet p = new Pet("Tommy", 1.0, "Dog", "Labra", 70.0);
        Pet p1 = new Pet("Kitty", 3.0, "Cat", "Ragdoll", 72.0);

        mypets = new HouseOfPets();

    }

    @Test
    public void houseOfPetsTest() {
        assertEquals(0, mypets.getsize());
    }

    @Test
    public void removePetTest() {
        assertTrue(mypets.addPet(p));
        assertTrue(mypets.removePet(p));
        assertEquals(0, mypets.getsize());
    }

    @Test
    public void removePetMultipleTest() {
        assertTrue(mypets.addPet(p));
        assertTrue(mypets.addPet(p1));
        assertTrue(mypets.removePet(p));
        assertEquals(1, mypets.getsize());
        assertEquals(p1, mypets.getMyPets().get(0));
    }

    @Test
    public void removePetNotThereTest() {
        Pet mypet = new Pet("", 12.0, "", "", 10.0);
        assertTrue(mypets.addPet(p));
        assertFalse(mypets.removePet(mypet));

    }

    @Test
    public void removePetNoPetTest() {
        Pet mypet = new Pet("", 12.0, "", "", 10.0);
        assertFalse(mypets.removePet(mypet));
    }

    @Test
    public void addPetTest() {
        assertTrue(mypets.addPet(p));
        assertEquals(1, mypets.getsize());

    }

    @Test
    public void addPetMultipleTimesTest() {
        assertTrue(mypets.addPet(p));
        assertEquals(1, mypets.getsize());
        assertTrue(mypets.addPet(p1));
        assertEquals(2, mypets.getsize());
    }

    @Test
    public void getMyPetsTest() {
        assertEquals(0, mypets.getsize());
        assertTrue(mypets.addPet(p));
        assertEquals(1, mypets.getsize());
    }


}
