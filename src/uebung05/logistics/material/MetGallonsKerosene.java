package uebung05.logistics.material;

import uebung05.logistics.quantities.FloatUnit;

public class MetGallonsKerosene implements FloatUnit {

    public static final MetGallonsKerosene INSTANCE = new MetGallonsKerosene();

    private MetGallonsKerosene(){}

    @Override
    public String toString(){
        return "met gallons of kerosene";
    }

}