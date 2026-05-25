package uebung05.logistics;

import uebung05.logistics.material.BulletBelts;
import uebung05.logistics.material.Grease;
import uebung05.logistics.material.LiterDiesel;
import uebung05.logistics.material.Oil;
import uebung05.logistics.quantities.NeedCollector;
import uebung05.logistics.storage.FloatStorage;
import uebung05.logistics.storage.IntStorage;

public class Truck extends Vehicle{

    public IntStorage bullets;
    public FloatStorage tank;

    public Truck(String name, float diesel, int bulletBelts){
        super(name,3 ,3);
        tank = new FloatStorage(0, LiterDiesel.INSTANCE, diesel);
        bullets = new IntStorage(0, BulletBelts.INSTANCE, bulletBelts);
    }

    public Truck(String name){
        this(name, 180f, 3);
    }

    @Override
    public void reportNeeds(NeedCollector collector){
        bullets.reportNeed(collector);
        tank.reportNeed(collector);
        oil.reportNeed(collector);
        grease.reportNeed(collector);
    }

    @Override
    public void fillUpAll(){
        tank.fillUp();
        bullets.fillUp();
        oil.fillUp();
        grease.fillUp();
    }

    @Override
    public void consumeAll(int intensityRate){
        oil.consume(1);
        grease.consume(1);
        tank.consume(intensityRate*25);
        bullets.consume(intensityRate*2);
    }

}