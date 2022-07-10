package com.crdt.lww.element;

public class StringLwwElement extends LwwElement<String> {

    public StringLwwElement(String data){
        super(data);
    }

    @Override
    public boolean equals(Object o) {
        StringLwwElement other = (StringLwwElement) o;
        return this.getData().equals(other.getData());
    }
}
