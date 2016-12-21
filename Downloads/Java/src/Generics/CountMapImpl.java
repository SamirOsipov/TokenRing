import java.util.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samirosipov on 21.12.16.
 */
public class CountMapImpl {

    private HashMap<T, Integer> map;

    public CountMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        Integer count;
        count = map.get(o);
        if (count == null) {
            map.put(o, 1);
        }
        else {
            map.put(o, count + 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.get(o) != null ? map.get(o) : -1;
    }

    @Override
    public int remove(T o) {
        Integer count = map.get(o);
        map.remove(o);
        return count != null ? count : -1;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap source) {
        for (Object object : source.toMap().entrySet()) {
            Map.Entry<T, Integer> entry = (Map.Entry<T, Integer>) object;
            Integer count = this.map.get(entry.getKey());
            this.map.put(entry.getKey(), count == null ? entry.getValue() : entry.getValue() + count);
        }
    }

    @Override
    public Map toMap() {
        return this.map;
    }

    @Override
    public void toMap(Map destination) {
        for (Map.Entry<T, Integer> entry : this.map.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }
}
