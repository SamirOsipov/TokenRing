import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Created by samirosipov on 21.12.16.
 */
public class CollectionUtils {

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List newArrayList() {
        List<? extends T> list = new ArrayList<>();
        return list;
    }

    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static<T> List limit(List<? extends T> source, int size) {
        if (size > source.size()) {
            return source;
        }
        else {
            List<T> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(source.get(i));
            }
            return list;
        }
    }

    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            removeFrom.remove(c2.get(i));
        }
    }

    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            if (c1.contains(c2.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static<T extends Comparable> List range(List<? extends T> list, Object min, Object max) {
        List<T> tList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(min) >= 0 && list.get(i).compareTo(max) <= 0) {
                tList.add(list.get(i));
            }
        }
        return tList;
    }

    public static<T> List range(List<? extends T> list, Object min,
                                Object max, Comparator comparator) {
        List<T> tList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(i), min) >= 0 &&
                    comparator.compare(list.get(i), max) <= 0) {
                tList.add(list.get(i));
            }
        }
        return tList;
    }

}
