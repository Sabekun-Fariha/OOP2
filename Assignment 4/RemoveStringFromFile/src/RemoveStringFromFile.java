import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RemoveStringFromFile {

    public static void main(String[] args) {
        String filename = args[0];
        String stringToBeRemoved = args[1];

        try{
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            String updateContent = content.replace(stringToBeRemoved, "");

            try (FileWriter writer = new FileWriter("fariha.txt")) {
                writer.write(updateContent);
            }
            System.out.println("All occurences of \""+ stringToBeRemoved + "\" have been removed from " + filename);

        } catch (IOException e) {
            System.out.println("Error processing the file: "+ e.getMessage());
        }
    }
}
