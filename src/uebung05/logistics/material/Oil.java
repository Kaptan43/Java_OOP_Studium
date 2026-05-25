package uebung05.logistics.material;

import uebung05.logistics.quantities.IntUnit;

public class Oil implements IntUnit {

    public static final Oil INSTANCE = new Oil();

    private Oil(){}

    @Override
    public String toString(){
        return "units of oil";
    }

}