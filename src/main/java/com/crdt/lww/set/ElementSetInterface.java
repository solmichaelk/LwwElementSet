package com.crdt.lww.set;

import com.crdt.lww.element.LwwElement;

import java.util.List;

public interface ElementSetInterface<T extends LwwElement, T1 extends Object> {
    long add(T1 value);
    long remove(T1 value);
    boolean exists(T1 value);
    boolean exists(T element);
    List<T1> get();
}
