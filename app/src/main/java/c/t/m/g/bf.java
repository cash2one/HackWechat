package c.t.m.g;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class bf extends LinkedHashMap<String, String> {
    bf() {
        super(8, 1.0f, true);
    }

    protected final boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 8;
    }
}
