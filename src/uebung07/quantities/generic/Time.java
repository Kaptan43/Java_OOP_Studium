package uebung07.quantities.generic;

import static uebung07.quantities.generic.LengthUnit.METER;
import static uebung07.quantities.generic.TimeUnit.SECOND;
import static uebung07.quantities.generic.VelocityUnit.METER_PER_SECOND;

public class Time extends Quantity<Time> {

    public Time(double value, TimeUnit unit) {
        super(value, unit);
    }

    public Length mult(Velocity v){
        return new Length(this.value(SECOND) * v.value(METER_PER_SECOND), METER);
    }
}