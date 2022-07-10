package com.crdt.lww.entity;

import java.util.Random;

public abstract class JpaEntity implements JpaEntityInterface {
    private long id;

    public JpaEntity(){
        this.id = Math.abs(new Random().nextLong());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        JpaEntity other = (JpaEntity) o;
        return other.getId() == this.getId();
    }
}
