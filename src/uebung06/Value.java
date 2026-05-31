package uebung06;

public enum Value {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE;

    @Override
    public String toString(){
        return String.valueOf(ordinal() +1);
    }

    /*
    @Override
    public String toString(){
        switch (this){
            case ONE -> {return "1"; }
            ...
            default -> throw new IllegalArgumentException("");
        }
    }
     */

    public static Value of(int id){
        return values()[id - 1];
    }

    /*
    public static Value of(int id){
        if(id==1) return ONE;
        throw new IllegalArgumentException("-");
    }
     */

}
