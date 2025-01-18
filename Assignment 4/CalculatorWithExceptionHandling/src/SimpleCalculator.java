import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter the first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.println("Enter the second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            System.out.println("Enter the operator: ");
            char operator = sc.nextLine().charAt(0);

            double result = 0;

            switch(operator){
                case '+':
                    result = num1 + num2;
                    System.out.println("The result is: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("The result is: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("The result is: " + result);
                    break;
                case '/':
                    if(num2 == 0){
                        throw new ArithmeticException("Division by Zero is not allowed.");
                    }
                    result = num1 / num2;
                    System.out.println("The result is: " + result);
                    break;
                default:
                    System.out.println("Invalid operator. Please use +, -, *, / ");
                    break;
            }

        } catch(NumberFormatException e){
            System.out.println("Invalid number. Please enter a valid number.");
        } catch(ArithmeticException e){
            System.out.println("Error!! " + e.getMessage());
        } catch(Exception e){
            System.out.println("An unexpected error occured " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
