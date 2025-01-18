import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicates {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> uniqueElements = new HashSet<E>(list);
        return new ArrayList<E>(uniqueElements);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Original List: " + numbers);

        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List without duplicates: " + uniqueNumbers);
    }
}
