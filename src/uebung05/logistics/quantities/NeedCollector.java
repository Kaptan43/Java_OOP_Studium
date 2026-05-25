package uebung05.logistics.quantities;

import java.util.HashMap;
import java.util.Map;

public class NeedCollector {
    private Map<IntUnit, Integer> intNeeded = new HashMap<>();
    private Map<FloatUnit, Float> floatNeeded = new HashMap<>();

    public void add(int amount, IntUnit unit){
        intNeeded.put(unit, intNeeded.getOrDefault(unit, 0) + amount);
    }

    public void add(float amount, FloatUnit unit){
        floatNeeded.put(unit, floatNeeded.getOrDefault(unit, 0f) + amount);
    }

    public int getNeed(IntUnit unit){
        return intNeeded.getOrDefault(unit, 0);
    }

    public float getNeed(FloatUnit unit){
        return floatNeeded.getOrDefault(unit, 0f);
    }

    public void show(){
        for(Map.Entry<IntUnit, Integer> entry : intNeeded.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for(Map.Entry<FloatUnit, Float> entry : floatNeeded.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}