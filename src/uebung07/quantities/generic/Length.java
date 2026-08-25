package uebung07.quantities.generic;

import static uebung07.quantities.generic.LengthUnit.METER;
import static uebung07.quantities.generic.TimeUnit.SECOND;
import static uebung07.quantities.generic.VelocityUnit.METER_PER_SECOND;

public class Length extends Quantity<Length> {

    public Length(double value, LengthUnit unit){
        super(value, unit);
    }


    public Velocity div(Time t){
        return new Velocity(this.value(METER) / t.value(SECOND), METER_PER_SECOND);
    }

    public Time div(Velocity v){
        return new Time(this.value(METER) / v.value(METER_PER_SECOND), SECOND);
    }

}
