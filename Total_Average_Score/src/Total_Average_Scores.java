import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Total_Average_Scores {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Prompt user for file name
            System.out.print("Enter the file name: ");
            String fileName = input.nextLine();

            File file = new File(fileName);

            try (Scanner fileScanner = new Scanner(file)) {
                double total = 0;
                int count = 0;

                // Read scores from file
                while (fileScanner.hasNext()) {
                    if (fileScanner.hasNextDouble()) {
                        double score = fileScanner.nextDouble();
                        total += score;
                        count++;
                    } else {
                        fileScanner.next(); // Skip invalid input
                    }
                }

                // Calculate and display total and average
                System.out.println("Total: " + total);
                if (count > 0) {
                    System.out.println("Average: " + (total / count));
                } else {
                    System.out.println("No valid scores found in the file.");
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            } catch (Exception e) {
                System.out.println("An error occurred while processing the file.");
            }
        }

}
