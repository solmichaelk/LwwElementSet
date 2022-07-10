package com.crdt.lww.element;

public interface ElementInterface<T extends Object> {
    void setData(T data);
    T getData();

    void setTimestamp(long timestamp);
    long getTimestamp();
}
