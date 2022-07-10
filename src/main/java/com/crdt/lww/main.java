package com.crdt.lww;

import com.crdt.lww.element.StringLwwElement;
import com.crdt.lww.entity.User;
import com.crdt.lww.set.JpaEntityLwwElementSet;
import com.crdt.lww.set.StringLwwElementSet;

public class main {
    public static void main(String[] args) {
        StringLwwElement element = new StringLwwElement("test11");
        System.out.println(element.getData());

        StringLwwElementSet set = new StringLwwElementSet();
        set.add("test");
        set.add("test2");
        set.add("test3");

        set.add("test");
        set.remove("test3");

        System.out.println(set.toString());
        System.out.println(set.exists("test"));
        System.out.println(set.exists("test3"));
        System.out.println(set.get());

        JpaEntityLwwElementSet set1 = new JpaEntityLwwElementSet();
        User user = new User("John");
        User user1 = new User("Johnson");
        set1.add(user);
        set1.add(user1);

        set1.remove(user1);

        System.out.println(set1.toString());
        System.out.println(set1.exists(user));
        System.out.println(set1.exists(user1));
        System.out.println(set1.get());
    }
}
