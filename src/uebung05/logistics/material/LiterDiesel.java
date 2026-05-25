package uebung05.logistics.material;

import uebung05.logistics.quantities.FloatUnit;

public class LiterDiesel implements FloatUnit {

    public static final LiterDiesel INSTANCE = new LiterDiesel();

    private LiterDiesel(){}

    @Override
    public String toString(){
        return "liters of diesel";
    }

}