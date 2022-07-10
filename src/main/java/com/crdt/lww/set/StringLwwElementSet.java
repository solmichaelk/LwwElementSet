package com.crdt.lww.set;

import com.crdt.lww.element.StringLwwElement;

public class StringLwwElementSet extends LwwElementSet<StringLwwElement, String> {

    @Override
    protected StringLwwElement createNewElement(String value){
        return new StringLwwElement(value);
    }
}
