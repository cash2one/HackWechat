package com.tencent.mm.plugin.appbrand.p;

import android.support.v4.e.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class g<K, V> {
    private final Map<K, Set<V>> jRJ = new a();

    public final Set<V> bg(K k) {
        Set<V> set;
        synchronized (this.jRJ) {
            set = (Set) this.jRJ.get(k);
            if (set == null) {
                set = new HashSet();
                this.jRJ.put(k, set);
            }
        }
        return set;
    }

    public final Set<V> bh(K k) {
        if (k == null) {
            return null;
        }
        Set<V> set;
        synchronized (this.jRJ) {
            set = (Set) this.jRJ.remove(k);
        }
        return set;
    }
}
