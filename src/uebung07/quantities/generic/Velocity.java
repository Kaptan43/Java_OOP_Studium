package uebung07.quantities.generic;

import static uebung07.quantities.generic.LengthUnit.METER;
import static uebung07.quantities.generic.TimeUnit.SECOND;
import static uebung07.quantities.generic.VelocityUnit.METER_PER_SECOND;

public class Velocity extends Quantity<Velocity> {

    public Velocity(double value, VelocityUnit unit){
        super(value, unit);
    }

    public Length mult(Time t){
        return new Length(this.value(METER_PER_SECOND)*t.value(SECOND), METER);
    }
    /*
    public Length mult(Time t){
        return t.mult(this);   //nutzt Time.mult(Velocity), das ich bereits in Time geschrieben habe!
    }
     */

}
