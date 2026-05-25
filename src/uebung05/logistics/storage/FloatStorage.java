package uebung05.logistics.storage;

import uebung05.logistics.quantities.FloatUnit;
import uebung05.logistics.quantities.NeedCollector;

public class FloatStorage {
    private final float max;
    private float stored;
    private FloatUnit unit;

    /*
    public FloatStorage(float stored, FloatUnit unit, float max){
        if(stored < 0 || max < 0) throw new IllegalArgumentException("");
        if(stored <= max){
            this.stored = stored;
        }
        else if(stored > max){
            this.stored = max;
        }
        this.max = max;
        this.unit = unit;
    }
     */

    public FloatStorage(float stored, FloatUnit unit, float max){
        if(stored < 0 || max < 0) throw new IllegalArgumentException("");
        this.stored = Math.min(stored, max);
        this.max = max;
        this.unit = unit;
    }

    public float getMax(){
        return max;
    }

    public float getStored(){
        return stored;
    }

    public FloatUnit getUnit(){
        return unit;
    }

    @Override
    public String toString(){
        return "storage with " + stored + " of " + max + " " + unit.toString();
    }

    /*
    public float consume(float amount){
        if(amount < 0) throw new IllegalArgumentException("");
        float consumed = stored;
        if(amount <= stored){
            stored -= amount;
            consumed = amount;
        }
        else if(amount > stored){
            stored = 0;
        }
        return consumed;
    }
     */

    public float consume(float amount){
        if(amount < 0 ) throw new IllegalArgumentException("");
        float consumed = stored;   //--> Hier hätte man auch direkt ' float consumed = Math.min(stored, amount); ' schreiben können!
        stored = Math.max(stored-amount, 0);
        consumed = Math.min(consumed, amount);
        return consumed;
    }

    public void fill(float amount){
        if(amount < 0) throw new IllegalArgumentException("");
        stored = Math.min(stored+amount, max);
    }

    public void fillUp(){
        stored = max;
    }

    public void reportNeed(NeedCollector collector){
        collector.add(max-stored, unit);
    }

}