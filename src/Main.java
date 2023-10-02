import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        int a = 5555;
        int[] arr = new int[]{0, 8, -7, -7, 1, 1, 5, 5, 5, 0, 3, 8};
        int n = getFirstUnique(arr);
        System.out.println("Первый уникальный элемент: " + n);
    }

    private static int getFirstUnique(int[] arr) {

        Map<Integer, Boolean> values = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (values.isEmpty()) {
                values.put(arr[i], false);
            }
            if (values.containsKey(arr[i])) {
                values.put(arr[i], true);
            } else {
                values.put(arr[i], false);
            }

            for (Map.Entry<Integer, Boolean> entry : values.entrySet()) {
                if (!entry.getValue()) {
                    return entry.getKey();

                }
            }
            Optional<Integer> optionalInteger = Stream.of(values).filter(integerBooleanMap -> integerBooleanMap.containsValue(false)).findFirst().get().keySet().stream().findFirst();
            return optionalInteger.orElseGet(() -> Stream.of(values).filter(integerBooleanMap -> integerBooleanMap.containsValue(false)).findFirst().get().keySet().stream().findFirst().get());
        }
        return 0;
    }
}