package uebung07.quantities.plain;

import static uebung07.quantities.plain.LengthUnit.METER;
import static uebung07.quantities.plain.TimeUnit.SECOND;
import static uebung07.quantities.plain.VelocityUnit.METER_PER_SECOND;

public class Time extends Quantity {
    private final TimeUnit unit;

    public Time(double value, TimeUnit unit){
        super(value, unit);
        this.unit = unit;
    }

    public Time plus(Time other){
        return new Time(value + other.getBaseValue() / unit.baseFactor, unit);
    }

    public Time minus(Time other){
        return new Time(value - other.getBaseValue() / unit.baseFactor, unit);
    }

    public Time mult(double f){
        return new Time(value * f, unit);
    }

    public Time div(double f){
        return new Time(value / f, unit);
    }

    public Time to(TimeUnit unit){
        return new Time(getBaseValue() / unit.baseFactor, unit);
    }

    public double div(Time t){
        return getBaseValue() / t.getBaseValue();
    }

    public Length mult(Velocity v){
        return new Length(this.value(SECOND) * v.value(METER_PER_SECOND), METER);
    }

}
