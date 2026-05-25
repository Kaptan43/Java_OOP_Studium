package uebung05.logistics.material;

import uebung05.logistics.quantities.IntUnit;

public class RocketPods implements IntUnit {

    public static final RocketPods INSTANCE = new RocketPods();

    private RocketPods(){}

    @Override
    public String toString(){
        return "pods of 70mm rockets";
    }

}