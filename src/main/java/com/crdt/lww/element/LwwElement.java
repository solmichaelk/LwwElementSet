package com.crdt.lww.element;

public abstract class LwwElement<T extends Object> implements ElementInterface<T> {
    private T data;
    private long timestamp;

    public LwwElement(T data) {
        this.data = data;
    }

    @Override
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LwwElement[data=" + getData() + ", time=" + getTimestamp() + "]";
    }
}
