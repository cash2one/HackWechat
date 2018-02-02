package android.support.v4.e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends j<K, V> implements Map<K, V> {
    g<K, V> wb;

    public a(int i) {
        super(i);
    }

    private g<K, V> bA() {
        if (this.wb == null) {
            this.wb = new g<K, V>(this) {
                final /* synthetic */ a wc;

                {
                    this.wc = r1;
                }

                protected final int bB() {
                    return this.wc.hX;
                }

                protected final Object n(int i, int i2) {
                    return this.wc.wz[(i << 1) + i2];
                }

                protected final int h(Object obj) {
                    return this.wc.indexOfKey(obj);
                }

                protected final int i(Object obj) {
                    return this.wc.indexOfValue(obj);
                }

                protected final Map<K, V> bC() {
                    return this.wc;
                }

                protected final void a(K k, V v) {
                    this.wc.put(k, v);
                }

                protected final V a(int i, V v) {
                    return this.wc.setValueAt(i, v);
                }

                protected final void X(int i) {
                    this.wc.removeAt(i);
                }

                protected final void bD() {
                    this.wc.clear();
                }
            };
        }
        return this.wb;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hX + map.size();
        if (this.wy.length < size) {
            Object obj = this.wy;
            Object obj2 = this.wz;
            super.ac(size);
            if (this.hX > 0) {
                System.arraycopy(obj, 0, this.wy, 0, this.hX);
                System.arraycopy(obj2, 0, this.wz, 0, this.hX << 1);
            }
            j.a(obj, obj2, this.hX);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        g bA = bA();
        if (bA.wk == null) {
            bA.wk = new b(bA);
        }
        return bA.wk;
    }

    public Set<K> keySet() {
        g bA = bA();
        if (bA.wl == null) {
            bA.wl = new c(bA);
        }
        return bA.wl;
    }

    public Collection<V> values() {
        g bA = bA();
        if (bA.wm == null) {
            bA.wm = new e(bA);
        }
        return bA.wm;
    }
}
