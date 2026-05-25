package uebung05.logistics;

import uebung05.logistics.material.BulletBelts;
import uebung05.logistics.material.LiterDiesel;
import uebung05.logistics.material.ShellBatches;
import uebung05.logistics.quantities.NeedCollector;
import uebung05.logistics.storage.FloatStorage;
import uebung05.logistics.storage.IntStorage;

public class Tank extends Vehicle{
    public IntStorage bullets;
    public IntStorage shells;
    public FloatStorage tank;

    public Tank(String name, float diesel, int bulletBelts, int shellBatches){
        super(name, 3, 3);
        tank = new FloatStorage(0, LiterDiesel.INSTANCE, diesel);
        shells = new IntStorage(0, ShellBatches.INSTANCE, shellBatches);
        bullets = new IntStorage(0, BulletBelts.INSTANCE, bulletBelts);
    }

    public Tank(String name){
        this(name, 1200f, 10, 10);
    }

    @Override
    public void reportNeeds(NeedCollector collector){
        tank.reportNeed(collector);
        shells.reportNeed(collector);
        bullets.reportNeed(collector);
        oil.reportNeed(collector);
        grease.reportNeed(collector);
    }

    @Override
    public void fillUpAll(){
        tank.fillUp();
        shells.fillUp();
        bullets.fillUp();
        oil.fillUp();
        grease.fillUp();
    }

    @Override
    public void consumeAll(int intensityRate){
        oil.consume(1);
        grease.consume(1);
        tank.consume(intensityRate*180);
        shells.consume(intensityRate*2);
        bullets.consume(intensityRate*2);
    }

}