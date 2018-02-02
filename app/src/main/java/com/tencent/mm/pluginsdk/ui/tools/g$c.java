package com.tencent.mm.pluginsdk.ui.tools;

import java.util.HashMap;

abstract class g$c<K, V> {
    private HashMap<K, a> qks;
    final /* synthetic */ g vxl;
    private final int vxq;
    private a vxw;
    private a vxx;
    private int vxy;

    protected abstract void bT(V v);

    public g$c(g gVar, int i) {
        this.vxl = gVar;
        this.vxq = Math.max(1, i);
        this.qks = new HashMap();
        this.vxw = new a(this);
        this.vxx = new a(this);
        this.vxw.vxA = this.vxx;
        this.vxx.vxz = this.vxw;
        this.vxy = 0;
    }

    private void a(a aVar) {
        aVar.vxA = this.vxw.vxA;
        aVar.vxA.vxz = aVar;
        this.vxw.vxA = aVar;
        aVar.vxz = this.vxw;
    }

    private static void b(a aVar) {
        aVar.vxz.vxA = aVar.vxA;
        aVar.vxA.vxz = aVar.vxz;
        aVar.vxA = null;
        aVar.vxz = null;
    }

    public final void clear() {
        while (this.vxy > 0) {
            a aVar = this.vxx.vxz;
            b(aVar);
            this.qks.remove(aVar.vxB);
            bT(aVar.jRK);
            this.vxy--;
        }
    }

    public final V put(K k, V v) {
        synchronized (this) {
            a aVar = (a) this.qks.get(k);
            if (aVar != null) {
                b(aVar);
                V v2 = aVar.jRK;
                aVar.jRK = v;
                a(aVar);
                return v2;
            }
            aVar = new a(this, k, v);
            a(aVar);
            this.qks.put(k, aVar);
            this.vxy++;
            while (this.vxq < this.vxy) {
                aVar = this.vxx.vxz;
                b(aVar);
                this.qks.remove(aVar.vxB);
                bT(aVar.jRK);
                this.vxy--;
            }
            return null;
        }
    }

    public final V get(K k) {
        V v;
        synchronized (this) {
            a aVar = (a) this.qks.get(k);
            if (aVar != null) {
                b(aVar);
                a(aVar);
                v = aVar.jRK;
            } else {
                v = null;
            }
        }
        return v;
    }

    public String toString() {
        String stringBuilder;
        synchronized (this) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (a aVar = this.vxw.vxA; aVar != this.vxx; aVar = aVar.vxA) {
                stringBuilder2.append("[key:").append(aVar.vxB).append(", value:").append(aVar.jRK).append("]");
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
