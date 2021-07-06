import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Roam {
    private static final Map<String, Integer> roman = new HashMap<>();
    private static final TreeMap<Integer, String> map = new TreeMap<>();
    // Многое гуглил для преобразований римских цифр по ходу пьесы и не до конца разобрался как это работает(в частности про TreeMap), но обязательно разберусь))
    static {
        roman.put("I", 1);
        roman.put("II", 2);
        roman.put("III", 3);
        roman.put("IV", 4);
        roman.put("V", 5);
        roman.put("VI", 6);
        roman.put("VII", 7);
        roman.put("VIII", 8);
        roman.put("IX", 9);
        roman.put("X", 10);
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static void Calculate(String st) {
        String a = st.split(" ")[0];
        String b = st.split(" ")[2];

        if (!roman.containsKey(a) || !roman.containsKey(b)) {
            try {
                throw new ArithmeticException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }

        switch (st.split(" ")[1]) {
            case ("+"):
                plus(a, b);
                break;
            case ("-"):
                minus(a, b);
                break;
            case ("*"):
                multiply(a, b);
                break;
            default:
                division(a, b);
                break;
        }
    }

    private static void plus(String a, String b) {
        int result = roman.get(a) + roman.get(b);
        System.out.println(toRoman(result));
    }

    private static void minus(String a, String b) {
        if (roman.get(a) <= roman.get(b)) {
            try {
                throw new Exception("Невозможный вывод");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        int result = roman.get(a) - roman.get(b);
        System.out.println(toRoman(result));
    }

    private static void multiply(String a, String b) {
        int result = roman.get(a) * roman.get(b);
        System.out.println(toRoman(result));
    }

    private static void division(String a, String b) {

        int result = roman.get(a) / roman.get(b);
        System.out.println(toRoman(result));
    }


    private static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }
}
