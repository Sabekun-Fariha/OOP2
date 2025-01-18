import java.io.*;
import java.util.Scanner;

public class FileStatistics {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java FileStatistics <filename>");
            return;
        }

        String filename = args[0];

        try (Scanner scanner = new Scanner(new File(filename))) {
            int characterCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;


                characterCount += line.length();


                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("File: " + filename);
            System.out.println("Number of characters: " + characterCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}

