public class GenericMaxElement {

    public static <E extends Comparable<E>> E max(E[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        E maxElement = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(maxElement) > 0) {
                maxElement = list[i];
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {

        Integer[] intArray = {1, 3, 7, 2, 9, 4};
        System.out.println("Maximum in intArray: " + max(intArray));

        Double[] doubleArray = {3.4, 2.1, 9.8, 7.6};
        System.out.println("Maximum in doubleArray: " + max(doubleArray));

        String[] strArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Maximum in strArray: " + max(strArray));
    }

}
