import java.util.Random;
import java.util.Scanner;

public class RandomArray {

    public static void main(String[] args) {

        int[] array = new int[100];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<array.length; i++){
            array[i] = rand.nextInt(1000);
        }

        try{
            System.out.println("Enter an index (between 0 and 99): ");
            int index = sc.nextInt();
            System.out.println("The value at index "+ index + " is " + array[index]);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error !! " + e.getMessage());
        } catch(Exception e){
            System.out.println("Error !! " + e.getMessage());
        }
    }
}
