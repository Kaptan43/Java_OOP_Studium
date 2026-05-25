package uebung05.logistics.material;

import uebung05.logistics.quantities.IntUnit;

public class BulletBelts implements IntUnit {

    public static final BulletBelts INSTANCE = new BulletBelts();

    private BulletBelts(){}

    @Override
    public String toString(){
        return "belts of 7.62 bullets";
    }

}
