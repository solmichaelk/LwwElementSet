package com.crdt.lww.entity;

public class User extends JpaEntity {
    private String name;

    public User(String name){
        super();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User[id=" + getId() + ", name="+ getName() +"]";
    }
}
