import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayComparison {
    public static boolean allElementsPresent(String[] A, String[] B) {
        // Convert array A to a Set for faster lookups
        Set<String> setA = new HashSet<>(Arrays.asList(A));

        // Check if each element of B is in Set A
        for (String item : B) {
            if (!setA.contains(item)) {
                return false; // Found an element in B that's not in A
            }
        }
        return true; // All elements of B are in A
    }
}
