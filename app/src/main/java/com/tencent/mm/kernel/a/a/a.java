package com.tencent.mm.kernel.a.a;

import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T> {
    public final ConcurrentHashMap<T, a<T>> gRQ = new ConcurrentHashMap();

    public static class a<T> {
        private HashSet<a> gRR;
        private HashSet<a> gRS;
        public T gRT;
        public volatile boolean gRU = false;
        private boolean gRV = true;

        public a(T t) {
            this.gRT = t;
        }

        public final synchronized HashSet<a> Dw() {
            return this.gRS == null ? null : new HashSet(this.gRS);
        }

        public final synchronized HashSet<a> Dx() {
            return this.gRR == null ? null : new HashSet(this.gRR);
        }

        public final synchronized int Dy() {
            return this.gRR == null ? 0 : this.gRR.size();
        }

        public final synchronized boolean Dz() {
            return this.gRV;
        }

        public final synchronized void DA() {
            if (this.gRR == null || this.gRR.size() == 0) {
                this.gRV = true;
            }
        }

        public final synchronized boolean DB() {
            boolean z;
            z = this.gRR != null && this.gRR.size() > 0;
            return z;
        }

        public String toString() {
            return "Ref-" + this.gRT.toString();
        }

        public void a(a aVar) {
            b(aVar);
            aVar.c(this);
        }

        private synchronized void b(a aVar) {
            this.gRV = false;
            if (this.gRR == null) {
                this.gRR = new HashSet(4);
            }
            this.gRR.add(aVar);
        }

        private synchronized void c(a aVar) {
            if (this.gRS == null) {
                this.gRS = new HashSet(4);
            }
            this.gRS.add(aVar);
        }

        public int hashCode() {
            return this.gRT.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.gRT.equals(((a) obj).gRT);
            }
            return this.gRT.equals(obj);
        }
    }

    public a<T> aF(T t) {
        if (!this.gRQ.containsKey(t)) {
            this.gRQ.putIfAbsent(t, new a(t));
        }
        return (a) this.gRQ.get(t);
    }

    public final a<T> aG(T t) {
        return (a) this.gRQ.get(t);
    }

    private static void aH(T t) {
        Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", t);
        Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.aA(t));
    }

    public final void o(T t, T t2) {
        Object[] objArr = new Object[]{t, t2};
        aH(t);
        aH(t2);
        if (t == t2) {
            aF(t).DA();
        } else {
            aF(t).a(aF(t2));
        }
    }
}
