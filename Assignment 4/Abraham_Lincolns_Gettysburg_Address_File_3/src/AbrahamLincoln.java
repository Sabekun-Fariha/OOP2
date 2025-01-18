import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AbrahamLincoln {

    public static void main(String[] args) {
        String addressUrl = "http://cs.armstrong.edu/liang/data/Lincoln.txt";

        try{
            URL url = new URL(addressUrl);
            Scanner sc = new Scanner(url.openStream());
            int wordCount = 0;

            while(sc.hasNext()){
                String word = sc.next();
                wordCount++;
            }
            sc.close();

            System.out.println("Number of words in the Gettysburg Address: " + wordCount);
        } catch (MalformedURLException e) {
            System.out.println("Malform URL Exception " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception " + e.getMessage());
        }
    }
}
