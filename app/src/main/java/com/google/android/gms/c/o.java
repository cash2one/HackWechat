package com.google.android.gms.c;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class o<K, V> {
    private final LinkedHashMap<K, V> aXC;
    private int aXD;
    private int aXE;
    private int aXF;
    private int aXG;
    private int aXH;
    private int size;

    private int k(K k, V v) {
        int ad = ad(v);
        if (ad >= 0) {
            return ad;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public int ad(V v) {
        return 1;
    }

    public final V get(K k) {
        synchronized (this) {
            V v = this.aXC.get(k);
            if (v != null) {
                this.aXG++;
                return v;
            }
            this.aXH++;
            return null;
        }
    }

    public final V put(K k, V v) {
        if (v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.aXE++;
            this.size += k(k, v);
            put = this.aXC.put(k, v);
            if (put != null) {
                this.size -= k(k, put);
            }
        }
        trimToSize(this.aXD);
        return put;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.aXG + this.aXH;
            if (i2 != 0) {
                i = (this.aXG * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.aXD), Integer.valueOf(this.aXG), Integer.valueOf(this.aXH), Integer.valueOf(i)});
        }
        return format;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size >= 0 && (!this.aXC.isEmpty() || this.size == 0)) {
                    if (this.size <= i || this.aXC.isEmpty()) {
                    } else {
                        Entry entry = (Entry) this.aXC.entrySet().iterator().next();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        this.aXC.remove(key);
                        this.size -= k(key, value);
                        this.aXF++;
                    }
                }
            }
        }
    }
}
