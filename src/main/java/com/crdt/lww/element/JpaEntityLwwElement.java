package com.crdt.lww.element;

import com.crdt.lww.entity.JpaEntity;

public class JpaEntityLwwElement<T extends JpaEntity> extends LwwElement<T> {

    public JpaEntityLwwElement(T entity){
        super(entity);
    }

    @Override
    public boolean equals(Object o) {
        JpaEntityLwwElement other = (JpaEntityLwwElement) o;
        return this.getData().equals(other.getData());
    }
}
