import java.util.ArrayList;

public class GenericsLargestElements {

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty.");
        }

        E maxElement = list.get(0); // Assume the first element is the maximum
        for (E element : list) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element; // Update maxElement if current element is larger
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(5);
        intList.add(30);
        intList.add(15);
        System.out.println("Maximum in intList: " + max(intList));

        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(3.4);
        doubleList.add(2.8);
        doubleList.add(9.1);
        System.out.println("Maximum in doubleList: " + max(doubleList));

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("date");
        System.out.println("Maximum in stringList: " + max(stringList));
    }
}
