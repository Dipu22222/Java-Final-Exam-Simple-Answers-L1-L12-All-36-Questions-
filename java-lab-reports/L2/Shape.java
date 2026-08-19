public class Shape {
    public double area() {
        return 0.0;
    }

    // Overloaded methods (early binding)
    public void describe(String name) {
        System.out.println("Describing: " + name);
    }

    public void describe(String name, int id) {
        System.out.println("Describing: " + name + " with ID " + id);
    }
}
