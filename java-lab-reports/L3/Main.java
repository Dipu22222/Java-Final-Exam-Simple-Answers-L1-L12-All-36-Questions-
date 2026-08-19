public class Main {
    public static void main(String[] args) {
        Car car = new Car(500000.0);
        car.startEngine();
        System.out.println("Fuel Type: " + car.fuelType());
        System.out.println("Insurance Premium: " + car.calculatePremium());
    }
}
