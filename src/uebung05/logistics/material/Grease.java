package uebung05.logistics.material;

import uebung05.logistics.quantities.IntUnit;

public class Grease implements IntUnit {

    public static final Grease INSTANCE = new Grease();

    private Grease(){}

    @Override
    public String toString(){
        return "units of grease";
    }

}