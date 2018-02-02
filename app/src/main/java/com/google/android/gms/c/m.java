package com.google.android.gms.c;

import com.google.android.gms.c.p.c;
import com.google.android.gms.c.p.e;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V> extends q<K, V> implements Map<K, V> {
    p<K, V> aXA;

    private p<K, V> pF() {
        if (this.aXA == null) {
            this.aXA = new 1(this);
        }
        return this.aXA;
    }

    public Set<Entry<K, V>> entrySet() {
        p pF = pF();
        if (pF.aXI == null) {
            pF.aXI = new p$b(pF);
        }
        return pF.aXI;
    }

    public Set<K> keySet() {
        p pF = pF();
        if (pF.aXJ == null) {
            pF.aXJ = new c(pF);
        }
        return pF.aXJ;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hX + map.size();
        if (this.wy.length < size) {
            Object obj = this.wy;
            Object obj2 = this.wz;
            super.dp(size);
            if (this.hX > 0) {
                System.arraycopy(obj, 0, this.wy, 0, this.hX);
                System.arraycopy(obj2, 0, this.wz, 0, this.hX << 1);
            }
            q.b(obj, obj2, this.hX);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        p pF = pF();
        if (pF.aXK == null) {
            pF.aXK = new e(pF);
        }
        return pF.aXK;
    }
}
