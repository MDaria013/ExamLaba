package com.example.java;


public abstract class Fabric {
    public HumanGenerator hG;

    public Fabric(HumanGenerator hG) {
        this.hG = hG;
    }

    public abstract Object CreateData();
}
