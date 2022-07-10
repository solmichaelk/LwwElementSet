package com.crdt.lww;

import com.crdt.lww.set.StringLwwElementSet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


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

    @Test
    public void testExists() {
        StringLwwElementSet set = new StringLwwElementSet();
        set.add("person1");
        set.add("person2");

        set.remove("person1");

        assertFalse(set.exists("person1"));
        assertTrue(set.exists("person2"));
    }

    @Test
    public void testGet() {
        StringLwwElementSet set = new StringLwwElementSet();
        set.add("person1");
        set.add("person2");
        set.add("person3");

        set.remove("person1");

        List<String> result = set.get();

        assertEquals(2, result.size());
        assertTrue(result.get(0).equals("person2"));
        assertTrue(result.get(1).equals("person3"));
    }
}
