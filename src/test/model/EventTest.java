package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
/**
 * Unit tests for the Event class
 */
public class EventTest {
    private Event e;
    private Date d;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("Added Dog to HouseOfPets");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("Added Dog to HouseOfPets", e.getDescription());
        assertEquals(d.toString(), e.getDate().toString());
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Added Dog to HouseOfPets", e.toString());
    }

    @Test
    public void testEqualsisNull() {
        assertFalse(e.equals(null));
    }

    @Test
    public void testEqualsisDiffClasses() {
        assertFalse(e.equals(5));
    }

    @Test
    public void testHashCode() {
        int testHashCode = 13 * e.getDate().hashCode() + e.getDescription().hashCode();
        assertEquals(testHashCode, e.hashCode());
    }
}
