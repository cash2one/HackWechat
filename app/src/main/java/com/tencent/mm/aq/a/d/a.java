package com.tencent.mm.aq.a.d;

import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V> {
    private f<K, V> hEh;

    public a(int i) {
        this.hEh = new f(i);
    }

    public final void clear() {
        if (this.hEh == null) {
            throw new NullPointerException("mData == null");
        }
        this.hEh.trimToSize(-1);
    }

    public final V get(K k) {
        if (this.hEh != null) {
            return this.hEh.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.hEh != null) {
            return this.hEh.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized Map<K, V> snapshot() {
        if (this.hEh == null) {
            throw new NullPointerException("mData == null");
        }
        return this.hEh.snapshot();
    }

    public final synchronized String toString() {
        if (this.hEh == null) {
            throw new NullPointerException("mData == null");
        }
        return this.hEh.toString();
    }
}
