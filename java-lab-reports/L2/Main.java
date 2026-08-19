public class Main {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.describe("MyShape");           // early binding
        s.describe("MyShape", 1);        // early binding

        Shape circle = new Circle(5.0);       // late binding
        Shape rectangle = new Rectangle(6.0, 4.0);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
    }
}
