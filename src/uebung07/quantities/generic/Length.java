/*
package uebung07.quantities.generic;

import uebung07.quantities.plain.LengthUnit;
import uebung07.quantities.plain.Quantity;
import uebung07.quantities.plain.Time;
import uebung07.quantities.plain.Velocity;

import static uebung07.quantities.plain.LengthUnit.METER;
import static uebung07.quantities.plain.TimeUnit.SECOND;
import static uebung07.quantities.plain.VelocityUnit.METER_PER_SECOND;

public class Length extends Quantity<Length> {
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        super(value, unit);
        this.unit = unit;
    }

    public Length plus(Length other) {
        return new Length(value + other.getBaseValue() / unit.baseFactor, unit);
    }

    public Length minus(Length other) {
        return new Length(value - other.getBaseValue() / unit.baseFactor, unit);
    }

    public Length mult(double f) {
        return new Length(value * f, unit);
    }

    public Length div(double f) {
        return new Length(value / f, unit);
    }

    public Length to(LengthUnit unit) {
        return new Length(getBaseValue() / unit.baseFactor, unit);
    }

    public double div(Length other) {
        return getBaseValue() / other.getBaseValue();
    }

    public Velocity div(Time t) {
        return new Velocity(this.value(METER) / t.value(SECOND), METER_PER_SECOND);
    }

    public Time div(Velocity v) {
        return new Time(this.value(METER) / v.value(METER_PER_SECOND), SECOND);
    }
}

 */
