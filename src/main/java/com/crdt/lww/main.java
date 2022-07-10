package com.crdt.lww;

import com.crdt.lww.element.StringLwwElement;

public class main {
    public static void main(String[] args) {
        StringLwwElement element = new StringLwwElement("test");

        System.out.println(element.getData());
    }
}
