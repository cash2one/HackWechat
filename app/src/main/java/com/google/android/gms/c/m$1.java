package com.google.android.gms.c;

import java.util.Map;

class m$1 extends p<K, V> {
    final /* synthetic */ m aXB;

    m$1(m mVar) {
        this.aXB = mVar;
    }

    protected final void X(int i) {
        this.aXB.removeAt(i);
    }

    protected final V a(int i, V v) {
        q qVar = this.aXB;
        int i2 = (i << 1) + 1;
        V v2 = qVar.wz[i2];
        qVar.wz[i2] = v;
        return v2;
    }

    protected final void a(K k, V v) {
        this.aXB.put(k, v);
    }

    protected final int bB() {
        return this.aXB.hX;
    }

    protected final Map<K, V> bC() {
        return this.aXB;
    }

    protected final void bD() {
        this.aXB.clear();
    }

    protected final int h(Object obj) {
        return obj == null ? this.aXB.bH() : this.aXB.indexOf(obj, obj.hashCode());
    }

    protected final int i(Object obj) {
        return this.aXB.indexOfValue(obj);
    }

    protected final Object n(int i, int i2) {
        return this.aXB.wz[(i << 1) + i2];
    }
}
