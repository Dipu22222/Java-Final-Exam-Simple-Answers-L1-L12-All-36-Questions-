class InvalidRadiusException extends Exception {
    public InvalidRadiusException(String message) {
        super(message);
    }
}

class CircleShape {
    private double radius;

    public CircleShape(double radius) throws InvalidRadiusException {
        if (radius < 0) {
            throw new InvalidRadiusException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            CircleShape invalid = new CircleShape(-2.0);
        } catch (InvalidRadiusException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            CircleShape valid = new CircleShape(5.0);
            System.out.println("Area: " + valid.area());
        } catch (InvalidRadiusException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
