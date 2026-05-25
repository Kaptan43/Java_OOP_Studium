package uebung05.logistics;

import uebung05.logistics.material.Grease;
import uebung05.logistics.material.Oil;
import uebung05.logistics.quantities.NeedCollector;
import uebung05.logistics.storage.IntStorage;

public abstract class Vehicle {
    public String name;
    public IntStorage oil;
    public IntStorage grease;

    public Vehicle(String name, int oil, int grease){
        if(oil < 0 || grease < 0) throw new IllegalArgumentException("");
        this.name = name;
        this.oil = new IntStorage(0, Oil.INSTANCE, oil);
        this.grease = new IntStorage(0, Grease.INSTANCE, grease);
    }

    public abstract void reportNeeds(NeedCollector collector);

    public abstract void fillUpAll();

    public abstract void consumeAll(int intensity);

}
