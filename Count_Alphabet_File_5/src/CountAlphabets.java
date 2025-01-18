import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountAlphabets {


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Prompt user for file name
            System.out.print("Enter a filename: ");
            String fileName = input.nextLine();

            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            // Array to hold the frequency of each letter
            int[] letterCounts = new int[26]; // For A-Z

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    for (char c : line.toCharArray()) {
                        if (Character.isLetter(c)) {
                            c = Character.toUpperCase(c); // Convert to uppercase
                            letterCounts[c - 'A']++; // Increment the corresponding letter count
                        }
                    }
                }

                // Display the occurrences of each letter
                for (int i = 0; i < letterCounts.length; i++) {
                    char letter = (char) (i + 'A');
                    System.out.println("Number of " + letter + "'s: " + letterCounts[i]);
                }

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
            }
        }

}
