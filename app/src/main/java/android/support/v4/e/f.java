package android.support.v4.e;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class f<K, V> {
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map = new LinkedHashMap(0, 0.75f, true);
    private int maxSize = 6;
    private int missCount;
    private int putCount;
    private int size;

    public f(int i) {
    }

    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.map.get(k);
            if (v != null) {
                this.hitCount++;
                return v;
            }
            this.missCount++;
            return null;
        }
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.putCount++;
            this.size++;
            put = this.map.put(k, v);
            if (put != null) {
                this.size--;
            }
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                    if (this.size <= i || this.map.isEmpty()) {
                    } else {
                        Entry entry = (Entry) this.map.entrySet().iterator().next();
                        Object key = entry.getKey();
                        entry.getValue();
                        this.map.remove(key);
                        this.size--;
                        this.evictionCount++;
                    }
                }
            }
        }
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.hitCount + this.missCount;
            if (i2 != 0) {
                i = (this.hitCount * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
        }
        return format;
    }
}
