public class Car extends Vehicle implements Insurable {
    private double vehicleValue;

    public Car(double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    @Override
    public String fuelType() {
        return "Petrol";
    }

    @Override
    public double calculatePremium() {
        return vehicleValue * 0.03; // 3% of vehicle value
    }
}
