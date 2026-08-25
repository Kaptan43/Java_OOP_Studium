package uebung07.quantities.generic;

public class TimeUnit extends Unit<Time> {
    public TimeUnit(String name, double baseFactor) { super(name, baseFactor); }

    public static final TimeUnit SECOND = new TimeUnit("s", 1);
    public static final TimeUnit MINUTE = new TimeUnit("min", 60);
    public static final TimeUnit HOUR = new TimeUnit("h", 3600);

    @Override
    public Time quantity(double value){
        return new Time(value, this);
    }
}