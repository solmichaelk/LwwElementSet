package com.crdt.lww;

import com.crdt.lww.entity.User;
import com.crdt.lww.set.JpaEntityLwwElementSet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class UserLwwElementSetTest {

    @Test
    public void testAddListSize() {
        User user1 = getUser("John");
        User user2 = getUser("Johnson");

        JpaEntityLwwElementSet set = new JpaEntityLwwElementSet<User>();
        set.add(user1);
        set.add(user2);

        assertEquals(2, set.getAddListSize());
    }

    @Test
    public void testAddListSize2() {
        User user1 = getUser("John");
        User user2 = getUser("Johnson");

        JpaEntityLwwElementSet set = new JpaEntityLwwElementSet<User>();
        set.add(user1);
        set.add(user2);
        set.add(user1);

        assertFalse(set.getAddListSize() == 3);
    }

    @Test
    public void testRemoveListSize() {
        User user1 = getUser("John");
        User user2 = getUser("Johnson");

        JpaEntityLwwElementSet set = new JpaEntityLwwElementSet<User>();
        set.remove(user1);
        set.remove(user2);

        assertEquals(2, set.getRemoveListSize());
    }

    @Test
    public void testRemoveListSize2() {
        User user1 = getUser("John");
        User user2 = getUser("Johnson");

        JpaEntityLwwElementSet set = new JpaEntityLwwElementSet<User>();
        set.remove(user1);
        set.remove(user2);
        set.remove(user1);

        assertFalse(set.getRemoveListSize() == 3);
    }

    @Test
    public void testExists() {
        User user1 = getUser("John");
        User user2 = getUser("Johnson");

        JpaEntityLwwElementSet set = new JpaEntityLwwElementSet<User>();
        set.add(user1);
        set.add(user2);

        set.remove(user1);

        assertFalse(set.exists(user1));
        assertTrue(set.exists(user2));
    }

    @Test
    public void testGet() {
        User user1 = getUser("John");
        User user2 = getUser("Johnson");
        User user3 = getUser("Johnny");

        JpaEntityLwwElementSet set = new JpaEntityLwwElementSet<User>();
        set.add(user1);
        set.add(user2);
        set.add(user3);

        set.remove(user1);

        List<User> result = set.get();

        assertEquals(2, result.size());
        assertTrue(result.get(0).getName().equals("Johnson"));
        assertTrue(result.get(1).getName().equals("Johnny"));
    }

    private User getUser(String name) {
        return new User(name);
    }
}
