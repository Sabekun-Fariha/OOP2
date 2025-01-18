import java.util.Scanner;

public class BinaryToDecimal {

    public static int bin2Dec(String binaryString) throws NumberFormatException {
        for(char ch : binaryString.toCharArray()) {
            if(ch != '0' && ch != '1'){
                throw new NumberFormatException("Not a valid binary number");
            }
        }

        int decimalValue = 0;
        for(int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(binaryString.length() - 1 - i);
            if(bit == '1'){
                decimalValue += Math.pow(2, i);
            }
        }
         return decimalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary number: ");
        String binaryString = sc.nextLine();

        try{
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal Value: " + decimalValue);
        } catch(NumberFormatException e){
            System.out.println("Not a valid binary number");
        } finally {
            sc.close();
        }
    }
}
