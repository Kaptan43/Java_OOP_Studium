package uebung07.quantities.generic;

public abstract class Quantity<Q extends Quantity<Q>> {
    public final double value;
    public final Unit<Q> unit;

    protected Quantity(double value, Unit<Q> unit){
        this.value = value;
        this.unit = unit;
    }

    public double getBaseValue(){
        return value * unit.baseFactor;
    }

    public double value(Unit<Q> unit){
        return getBaseValue() / unit.baseFactor;
    }

    public Q plus(Q other){
        return unit.quantity(value + other.value(unit));
    }

    public Q minus(Q other){
        return unit.quantity(value - other.value(unit));
    }

    public Q mult(double f){
        return unit.quantity(value * f);
    }

    public Q div(double f){
        return unit.quantity(value / f);
    }

    public Q to(Unit<Q> unit){
        return unit.quantity(getBaseValue() / unit.baseFactor);
    }

    public double div(Q other){
        return getBaseValue() / other.getBaseValue();
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public String format(String fmt, Unit<Q> unit) {
        return String.format(fmt, value(unit), unit);
    }

}