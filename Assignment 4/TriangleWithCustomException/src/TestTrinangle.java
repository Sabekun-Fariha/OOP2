import java.util.Scanner;

public class TestTrinangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Prompt the user to enter the sides of the triangle
            System.out.println("Enter the first side: ");
            double side1 = sc.nextDouble();

            System.out.println("Enter the second side: ");
            double side2 = sc.nextDouble();

            System.out.println("Enter the third side: ");
            double side3 = sc.nextDouble();

            // Create a Triangle object
            Triangle triangle = new Triangle(side1, side2, side3);

            // Display the triangle details
            System.out.println(triangle);
            System.out.println("Perimeter: " + triangle.getPerimeter());
            System.out.println("Area: " + triangle.getArea());

        } catch (ILLegalTriangleException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            sc.close();
        }

    }
}
