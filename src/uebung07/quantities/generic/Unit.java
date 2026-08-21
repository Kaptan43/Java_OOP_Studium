package uebung07.quantities.generic;

public abstract class Unit<T extends Quantity<T>> {
    public final String name;
    public final double baseFactor;

    public Unit(String name, double baseFactor){
        this.name = name;
        this.baseFactor = baseFactor;
    }

    public abstract T quantity(double value);

}
