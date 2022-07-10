package com.crdt.lww.set;

import com.crdt.lww.element.LwwElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class LwwElementSet<T extends LwwElement, T1 extends Object> implements ElementSetInterface<T, T1> {
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

    public boolean exists(T1 value) {
        T element = createNewElement(value);
        return exists(element);
    }

    public boolean exists(T element) {
        int indexAdd = addList.indexOf(element);
        int indexRemove = removeList.indexOf(element);

        if(indexAdd == -1) {
            return false;
        } else {
            if(indexRemove == -1) {
                return true;
            } else {
                T a = addList.get(indexAdd);
                T r = removeList.get(indexRemove);

                return a.getTimestamp() > r.getTimestamp();
            }
        }
    }

    public List<T1> get(){
        List<T1> result = new ArrayList<>();

        for(T a : addList) {
            int indexRemove = removeList.indexOf(a);

            if(indexRemove == -1) {
                result.add((T1) a.getData());
            } else {
                T r = removeList.get(indexRemove);

                if(a.getTimestamp() > r.getTimestamp()) {
                    result.add((T1) a.getData());
                }
            }
        }

        return result;
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
