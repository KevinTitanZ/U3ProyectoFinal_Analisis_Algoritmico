package ClassToGraph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet<T>{
	private Map<T, T> parent;

    public DisjointSet() {
        parent = new HashMap<>();
    }

    public void makeSet(T item) {
        parent.put(item, item);
    }

    public T findSet(T item) {
        if (parent.get(item) == item) {
            return item;
        }
        return findSet(parent.get(item));
    }

    public void union(T x, T y) {
        T xRoot = findSet(x);
        T yRoot = findSet(y);
        parent.put(xRoot, yRoot);
    }
}
