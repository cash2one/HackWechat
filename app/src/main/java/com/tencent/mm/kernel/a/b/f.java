package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class f<T> extends com.tencent.mm.kernel.a.a.a<T> implements c<T> {
    private c<T> gSg;
    d<T> gSm;
    public Class gSn;
    volatile boolean gSo = false;

    public static class b {
        public com.tencent.mm.cd.b gSx = new com.tencent.mm.cd.b();
    }

    public static class a<T> extends com.tencent.mm.kernel.a.a.a.a<T> {
        volatile int gSp;
        private boolean gSq;
        volatile boolean gSr;
        public volatile a gSs;
        public volatile a gSt;
        public h gSu;
        private c gSv;
        public b gSw;

        private a(T t, Class cls, c cVar) {
            super(t);
            this.gSp = 0;
            this.gSq = false;
            this.gSr = false;
            this.gSu = new h();
            this.gSw = new b();
            this.gSu.gRX = cls;
            this.gSv = cVar;
        }

        public final void a(com.tencent.mm.kernel.a.a.a.a aVar) {
            super.a(aVar);
            synchronized (this) {
                this.gSp++;
            }
        }

        public final void a(com.tencent.mm.vending.c.a aVar) {
            if (!this.gRU) {
                if (!DN()) {
                    boolean z;
                    HashSet Dx = Dx();
                    Assert.assertNotNull(Dx);
                    Iterator it = Dx.iterator();
                    while (it.hasNext()) {
                        if (!((a) ((com.tencent.mm.kernel.a.a.a.a) it.next())).gRU) {
                            x.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", this, (com.tencent.mm.kernel.a.a.a.a) it.next());
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        DO();
                    }
                }
                this.gSw.gSx.cCp();
                if (!this.gRU) {
                    j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", this, this.gSu.gRX);
                    aVar.call(this);
                    this.gRU = true;
                }
                this.gSw.gSx.done();
            }
        }

        private boolean DL() {
            return this.gSp == 0 && (this.gSs == null || this.gSs.gRU);
        }

        public final synchronized boolean DM() {
            boolean z = false;
            synchronized (this) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolvedAndSwallowIt for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.gRT;
                objArr[1] = this.gSu.gRX;
                objArr[2] = Boolean.valueOf(this.gSr);
                objArr[3] = Integer.valueOf(this.gSp);
                objArr[4] = this.gSs;
                objArr[5] = this.gSs != null ? Boolean.valueOf(this.gSs.gRU) : "";
                objArr[6] = this.gSu.gSG;
                x.i(str, str2, objArr);
                if (!this.gSr && DL()) {
                    x.d("MMSkeleton.ParallelsDependencies", "checkIfResolvedAndSwallowIt node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.gRU), this.gSu.gRX);
                    this.gSr = true;
                    notify();
                    z = true;
                }
            }
            return z;
        }

        private synchronized boolean DN() {
            boolean z = true;
            synchronized (this) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolved for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.gRT;
                objArr[1] = this.gSu.gRX;
                objArr[2] = Boolean.valueOf(this.gSr);
                objArr[3] = Integer.valueOf(this.gSp);
                objArr[4] = this.gSs;
                objArr[5] = this.gSs != null ? Boolean.valueOf(this.gSs.gRU) : "";
                objArr[6] = this.gSu.gSG;
                x.i(str, str2, objArr);
                if (!this.gSr) {
                    z = DL();
                }
            }
            return z;
        }

        private synchronized void DO() {
            try {
                if (this.gSr) {
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.gRU), this.gSu.gRX);
                } else {
                    x.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", this, Boolean.valueOf(this.gRU), this.gSu.gRX);
                    wait();
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", this, Boolean.valueOf(this.gRU), this.gSu.gRX);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMSkeleton.ParallelsDependencies", e, "", new Object[0]);
            }
        }

        public final synchronized boolean DP() {
            this.gSp--;
            return DM();
        }

        public final String toString() {
            return super.toString() + " - with type " + this.gSu.gRX;
        }
    }

    public f(Class cls, d<T> dVar, c cVar) {
        this.gSn = cls;
        this.gSm = dVar;
        if (cVar == null) {
            cVar = this;
        }
        this.gSg = cVar;
    }

    protected final com.tencent.mm.kernel.a.a.a.a<T> aF(T t) {
        if (!this.gRQ.containsKey(t)) {
            this.gRQ.putIfAbsent(t, new a(t, this.gSn, this.gSg));
        }
        return (com.tencent.mm.kernel.a.a.a.a) this.gRQ.get(t);
    }

    public final a<T> aK(T t) {
        return (a) this.gRQ.get(t);
    }

    public final void prepare() {
        x.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", this.gSn);
        Assert.assertNotNull(this.gSm);
        this.gSo = true;
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.gRQ.values()) {
            if (aVar.Dz()) {
                a aVar2 = (a) aVar;
                x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", aVar2);
                if (aVar2.DM()) {
                    this.gSm.b(aVar2);
                }
                x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", aVar2);
            }
        }
        x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", this.gSn);
    }

    public final a<T> DD() {
        return this.gSm.DD();
    }

    public final void a(a<T> aVar) {
        HashSet Dw = aVar.Dw();
        if (Dw != null) {
            Iterator it = Dw.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) ((com.tencent.mm.kernel.a.a.a.a) it.next());
                if (aVar2.DP()) {
                    this.gSm.b(aVar2);
                }
            }
        }
    }

    public final List<com.tencent.mm.kernel.a.a.a.a> DK() {
        List<com.tencent.mm.kernel.a.a.a.a> arrayList = new ArrayList(1);
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.gRQ.values()) {
            if (!((a) aVar).gRU) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s";
                Object[] objArr = new Object[4];
                objArr[0] = aVar;
                objArr[1] = Integer.valueOf(((a) aVar).gSp);
                objArr[2] = ((a) aVar).gSs;
                objArr[3] = ((a) aVar).gSs != null ? Boolean.valueOf(((a) aVar).gSs.gRU) : "";
                x.e(str, str2, objArr);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
