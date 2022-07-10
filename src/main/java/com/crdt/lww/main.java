package com.crdt.lww;

import com.crdt.lww.element.StringLwwElement;
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
    }
}
