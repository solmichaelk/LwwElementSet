package com.crdt.lww;

import com.crdt.lww.set.StringLwwElementSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class StringLwwElementSetTest {

    @Test
    public void testAddListSize() {
        StringLwwElementSet set = new StringLwwElementSet();
        set.add("person1");
        set.add("person2");

        assertEquals(2, set.getAddListSize());
    }

    @Test
    public void testAddListSize2() {
        StringLwwElementSet set = new StringLwwElementSet();
        set.add("person1");
        set.add("person2");
        set.add("person1");

        assertFalse(set.getAddListSize() == 3);
    }

    @Test
    public void testRemoveListSize() {
        StringLwwElementSet set = new StringLwwElementSet();
        set.remove("person1");
        set.remove("person2");

        assertEquals(2, set.getRemoveListSize());
    }

    @Test
    public void testRemoveListSize2() {
        StringLwwElementSet set = new StringLwwElementSet();
        set.remove("person1");
        set.remove("person2");
        set.remove("person1");

        assertFalse(set.getRemoveListSize() == 3);
    }
}
