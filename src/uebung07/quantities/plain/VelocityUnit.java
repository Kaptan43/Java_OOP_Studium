package uebung07.quantities.plain;

public class VelocityUnit extends Unit {
    public VelocityUnit(String name, double baseFactor) { super(name, baseFactor); }

    public static final VelocityUnit KMH = new VelocityUnit("km/h", 1000/3600d);
    public static final VelocityUnit MPH = new VelocityUnit("mi/h", 1609.344/3600d);
    public static final VelocityUnit METER_PER_SECOND = new VelocityUnit("m/s", 1);
}
