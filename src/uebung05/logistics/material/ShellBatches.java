package uebung05.logistics.material;

import uebung05.logistics.quantities.IntUnit;

public class ShellBatches implements IntUnit {

    public static final ShellBatches INSTANCE = new ShellBatches();

    private ShellBatches(){}

    @Override
    public String toString(){
        return "batches of 120mm shells";
    }

}