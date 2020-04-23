package poly;

public class Bus implements Transport {

    @Override
    public void toDrive() {
        System.out.println(" go - g0 ");
    }

    @Override
    public void passenger(int number) {
        System.out.println("number of passenger " + number);
    }

    @Override
    public double toFuel(double fuel) {
        return fuel * 43.55;
    }
}
