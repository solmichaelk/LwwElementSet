package com.crdt.lww.set;

import com.crdt.lww.element.LwwElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class LwwElementSet<T extends LwwElement, T1 extends Object> {
    private List<T> addList = new ArrayList<>();
    private List<T> removeList = new ArrayList<>();

    public long add(T1 value) {
        T element = createNewElement(value);

        element.setTimestamp(getCurrentTimestamp());
        int index = addList.indexOf(element);

        if(index > -1) {
            addList.set(index, element);
        } else {
            addList.add(element);
        }

        return element.getTimestamp();
    }

    public long remove(T1 value) {
        T element = createNewElement(value);

        element.setTimestamp(getCurrentTimestamp());
        int index = removeList.indexOf(element);

        if(index > -1) {
            removeList.set(index, element);
        } else {
            removeList.add(element);
        }

        return element.getTimestamp();
    }

    public int getAddListSize() {
        return addList.size();
    }

    public int getRemoveListSize() {
        return removeList.size();
    }

    protected abstract T createNewElement(T1 value);

    private long getCurrentTimestamp(){
        return new Date().getTime();
    }

    @Override
    public String toString(){
        return "addList" + addList.toString() + " removeList" + removeList.toString() + "";
    }
}
