// DynamicPerceptTest.java


import org.junit.Test;
import static org.junit.Assert.*;

public class DynamicPerceptTest {

    @Test
    public void testToString() {
        DynamicPercept p = new DynamicPercept("key1", "value1");
        assertEquals("Percept[key1=value1]", p.toString());

        p = new DynamicPercept("key1", "value1", "key2", "value2");
        assertEquals("Percept[key1=value1, key2=value2]", p.toString());
    }

    @Test
    public void testEquals() {
        DynamicPercept p1 = new DynamicPercept();
        DynamicPercept p2 = new DynamicPercept();
        assertEquals(p1, p2);

        p1 = new DynamicPercept("key1", "value1");
        assertNotSame(p1, p2);

        p2 = new DynamicPercept("key1", "value1");
        assertEquals(p1, p2);
    }
}