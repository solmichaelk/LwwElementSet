package com.crdt.lww.set;

import com.crdt.lww.element.JpaEntityLwwElement;
import com.crdt.lww.entity.JpaEntity;

public class JpaEntityLwwElementSet<T extends JpaEntity> extends LwwElementSet<JpaEntityLwwElement<T>, T> {

    @Override
    protected JpaEntityLwwElement createNewElement(T entity){
        return new JpaEntityLwwElement(entity);
    }
}
