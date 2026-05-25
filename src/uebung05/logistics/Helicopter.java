package uebung05.logistics;

import uebung05.logistics.material.BulletBelts;
import uebung05.logistics.material.MetGallonsKerosene;
import uebung05.logistics.material.RocketPods;
import uebung05.logistics.quantities.NeedCollector;
import uebung05.logistics.storage.FloatStorage;
import uebung05.logistics.storage.IntStorage;

public class Helicopter extends Vehicle{
    public IntStorage bullets;
    public IntStorage rockets;
    public FloatStorage tank;

    public Helicopter(String name, float kerosene, int bulletBelts, int rocketPods){
        super(name, 3, 3);
        tank = new FloatStorage(0, MetGallonsKerosene.INSTANCE, kerosene);
        bullets = new IntStorage(0, BulletBelts.INSTANCE, bulletBelts);
        rockets = new IntStorage(0, RocketPods.INSTANCE, rocketPods);
    }

    public Helicopter(String name){
        this(name, 500f, 2, 2);
    }

    @Override
    public void reportNeeds(NeedCollector collector){
        tank.reportNeed(collector);
        rockets.reportNeed(collector);
        bullets.reportNeed(collector);
        oil.reportNeed(collector);
        grease.reportNeed(collector);
    }

    @Override
    public void fillUpAll(){
        tank.fillUp();
        rockets.fillUp();
        bullets.fillUp();
        oil.fillUp();
        grease.fillUp();
    }

    @Override
    public void consumeAll(int intensityRate){
        oil.consume(1);
        grease.consume(1);
        tank.consume(intensityRate*200);
        rockets.consume(intensityRate);
        bullets.consume(intensityRate);
    }

}