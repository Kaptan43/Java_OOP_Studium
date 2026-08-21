package uebung07.quantities.generic;

public class Length extends Quantity<Length> {

    public Length(double value, LengthUnit unit){
        super(value, unit);
    }

    /*
    public Velocity div(Time t){
        return new Velocity(this.value(METER) / t.value(SECOND), METER_PER_SECOND);
    }

    public Time div(Velocity v){
        return new Time(this.value(METER) / v.value(METER_PER_SECOND), SECOND);
    }
    */

}
