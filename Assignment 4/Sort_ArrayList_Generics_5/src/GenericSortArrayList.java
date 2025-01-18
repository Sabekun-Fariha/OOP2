import java.util.ArrayList;

public class GenericSortArrayList {

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        if (list == null || list.size() < 2) {
            return; // No need to sort if the list is null or has only one element
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j; // Find the minimum element in the remaining unsorted part
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            E temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(30);
        intList.add(10);
        intList.add(20);
        intList.add(50);
        intList.add(40);
        System.out.println("Before sorting: " + intList);
        sort(intList);
        System.out.println("After sorting: " + intList);

        // Example 2: String ArrayList
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("cherry");
        stringList.add("date");
        System.out.println("Before sorting: " + stringList);
        sort(stringList);
        System.out.println("After sorting: " + stringList);

        // Example 3: Double ArrayList
        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(3.5);
        doubleList.add(1.2);
        doubleList.add(4.8);
        doubleList.add(2.9);
        System.out.println("Before sorting: " + doubleList);
        sort(doubleList);
        System.out.println("After sorting: " + doubleList);
    }
}
