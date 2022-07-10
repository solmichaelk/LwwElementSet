package com.crdt.lww.set;

import com.crdt.lww.element.LwwElement;

import java.util.ArrayList;
import java.util.List;

public class LwwElementSet<T extends LwwElement> {
    private List<T> addList = new ArrayList<>();
    private List<T> removeList = new ArrayList<>();
}
