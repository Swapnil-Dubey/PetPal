package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {
    private Pet p;
    private Pet p1;

    private String name;
    private Double age;
    private String typeofpet;
    private String breed;
    private Double weight;

    @BeforeEach
    public void setup() {
        name = "pup";
        age = 1.0;
        typeofpet = "Dog";
        breed = "Labra";
        weight = 70.0;
        p = new Pet(name, age, typeofpet, breed, weight);
        p1 = new Pet("Kitty", 3.0, "Cat", "Ragdoll", 72.0);
    }

    @Test
    public void petTest() {
        assertEquals(name, p.name);
        assertEquals(age, p.age);
        assertEquals(typeofpet, p.typeofpet);
        assertEquals(breed, p.breed);
        assertEquals(weight, p.weight);
    }

    @Test
    public void playWithTest() {
        assertTrue(p.playWith());
        assertEquals(1, p.petactions.size());
    }

    @Test
    public void giveWaterTest() {
        assertTrue(p1.giveWater());
        assertEquals(1, p1.petactions.size());
    }

    @Test
    public void giveFoodTest() {
        assertTrue(p.giveFood());
        assertEquals(1, p.petactions.size());
    }

    @Test
    public void giveTreatsTest() {
        assertTrue(p1.giveTreats());
        assertEquals(1, p1.petactions.size());
    }

    @Test
    public void takeforaWalkTest() {
        assertTrue(p1.takeforaWalk());
        assertEquals(1, p1.petactions.size());
    }

    @Test
    public void trainTest() {
        assertTrue(p.train());
        assertEquals(1, p.petactions.size());
    }

    @Test
    public void groomTest() {
        assertTrue(p1.groom());
        assertEquals(1, p1.petactions.size());
    }

    @Test
    public void getPetActionsTest() {
        assertEquals(0, p.getPetActions().size());
    }

    @Test
    public void updateActionsSingleTest() {

        JsonReader reader = new JsonReader("./data/singlePerformedAction.json");
        try {
            HouseOfPets hp = reader.read();
            ArrayList<PetAction> expetactions = hp.getMyPets().get(0).petactions;
            p.updateActions(expetactions);
            assertEquals(1, p.petactions.size());
            p.updateActions(expetactions);
            assertEquals(2, p.petactions.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        assertEquals(2, p.petactions.size());
    }


    @Test
    public void updateActionsMultipleTest() {
        JsonReader reader = new JsonReader("./data/doublePerformedAction.json");
        try {
            HouseOfPets hp = reader.read();
            ArrayList<PetAction> expetactions = hp.getMyPets().get(0).petactions;
            p.updateActions(expetactions);
            assertEquals(2, p.petactions.size());
            p.updateActions(expetactions);
            assertEquals(4, p.petactions.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        assertEquals(4, p.petactions.size());
    }

    @Test
    public void getTypeofPetTest() {
        assertEquals("Dog", p.getTypeofpet());
    }


}