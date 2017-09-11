package array;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Object [] objects= new Object[4];
        objects[0] = 5;
        objects[1] = "asd";
        objects[2] = 2;
        objects[3] = "asd";
        Map<Object, Integer>map = countElements(objects);

        System.out.println(map.toString());

    }

    public static Map countElements(Object[] obj) {
        Map<Object, Integer> map = new HashMap<>();

        for (Object temp : obj) {
            if (!map.containsKey(temp))
                map.put(temp, 1);
            else
                map.put(temp, map.get(temp) + 1);
        }
        return map;
    }
}
