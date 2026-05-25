package uebung05.logistics.storage;

import uebung05.logistics.quantities.IntUnit;
import uebung05.logistics.quantities.NeedCollector;

public class IntStorage {
    private int stored;
    private final int max;
    private IntUnit unit;

    public IntStorage(int stored, IntUnit unit, int max){
        if(stored < 0 || max < 0){
            throw new IllegalArgumentException("");
        }
        this.stored = Math.min(stored, max);
        this.max = max;
        this.unit = unit;
    }

    public int getStored(){
        return stored;
    }

    public int getMax(){
        return max;
    }

    public IntUnit getUnit(){
        return unit;
    }

    @Override
    public String toString(){
        return "storage with " + stored + " of " + max + " " + unit.toString(); //<-- man kann auch nur unit schreiben anstelle von unit.toString()
    }

    /*
    public int consume(int amount){
        if(amount<0){
            throw new IllegalArgumentException("");
        }
        if(stored<amount){
            int consumed = stored;
            stored = 0;
            return consumed;
        }
        else{
            stored -= amount;
            return amount;
        }
    }
    */

    public int consume(int amount){
        if(amount<0){
            throw new IllegalArgumentException("");
        }
        int consumed = Math.min(stored, amount);
        stored = Math.max(stored-amount, 0);
        return consumed;
    }

    /*
    public void fill(int amount){
        if(amount<0) throw new IllegalArgumentException("");
        else if(amount + stored <= max){
            stored += amount;
        }
        else{
            stored = max;
        }
    }
     */

    public void fill(int amount){
        if(amount<0) throw new IllegalArgumentException("");
        stored = Math.min(stored+amount, max);
    }

    public void fillUp(){
        stored = max;
    }

    public void reportNeed(NeedCollector collector){
        collector.add(max-stored, unit);
    }
}
