public class GenericLinearSearch {

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {

            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] intArray = {10, 20, 30, 40, 50};
        int intIndex = linearSearch(intArray, 30);
        System.out.println("Index of 30 in intArray: " + intIndex);

        String[] strArray = {"apple", "banana", "cherry", "date"};
        int strIndex = linearSearch(strArray, "cherry");
        System.out.println("Index of 'cherry' in strArray: " + strIndex);

        int notFoundIndex = linearSearch(strArray, "grape");
        System.out.println("Index of 'grape' in strArray: " + notFoundIndex);
    }
}
