import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DefaultDict<K, V> {

    private V defaultValue;
    private Map<K, V> map;

    public DefaultDict(V defaultValue) {
        this.defaultValue = defaultValue;
        map = new HashMap<>();
    }

    public String toString() {
        String str = "{  ";
        for (Map.Entry<K, V> entry: map.entrySet()) {
            str += (entry.getKey().toString() + ": " + entry.getValue().toString() + ", ");
        }
        return "[DefaultDict] " + str.substring(0, str.length() - 2) + "  }";
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            map.put(key, defaultValue);
            return defaultValue;
        }
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    // Check if key exists in the map
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    // Remove a key-value pair from the map
    public V remove(K key) {
        return map.remove(key);
    }

    // Get the size of the map
    public int size() {
        return map.size();
    }

}

public class GenericsTheoryDriver2 {
    public static void main(String[] args) {

        // This will not work
//        HashMap<String, Integer> map = new HashMap<>();
//        int value = map.get("foo");
//        System.out.println(value);

        DefaultDict<String, Integer> flexibleCounter = new DefaultDict<>(134);

        System.out.println(flexibleCounter);

        System.out.println(flexibleCounter.get("timer1"));
        System.out.println(flexibleCounter);

        System.out.println(flexibleCounter.get("timer2"));
        System.out.println(flexibleCounter);

        flexibleCounter.put("timer1", flexibleCounter.get("timer1") + 1);
        System.out.println(flexibleCounter);

        for (int i = 0; i < 100; i++) {
            int count = flexibleCounter.get("timer 3");
            flexibleCounter.put("timer 3", count + 1);
        }
        System.out.println(flexibleCounter);

    }
}
