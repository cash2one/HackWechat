package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g implements b, c<Object>, d<Object> {
    public volatile Class<?>[] gSA;
    public Map<Class, Object> gSB = new ConcurrentHashMap();
    private int gSC = 0;
    private Queue<com.tencent.mm.kernel.a.b.f.a> gSD = new ConcurrentLinkedQueue();
    public ConcurrentHashMap<Object, a> gSE = new ConcurrentHashMap();
    public Map<Class<?>, f<Object>> gSy = new ConcurrentHashMap();
    private Class<?>[] gSz;

    private static class a {
        byte[] gSF;

        private a() {
            this.gSF = new byte[1];
        }

        public final boolean DR() {
            boolean z = false;
            synchronized (this.gSF) {
                if (this.gSF[0] == (byte) 2) {
                    z = true;
                }
            }
            return z;
        }
    }

    public final void a(Class... clsArr) {
        int i = 0;
        this.gSz = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.gSz, 0, clsArr.length);
        while (i < this.gSz.length) {
            this.gSy.put(this.gSz[i], new f(this.gSz[i], this, this));
            i++;
        }
    }

    public final <T> f<T> p(Class<T> cls) {
        return (f) this.gSy.get(cls);
    }

    public final void b(Class cls, boolean z) {
        int i = 0;
        while (i < this.gSz.length) {
            if (this.gSz[i] == cls) {
                break;
            }
            i++;
        }
        i = -1;
        int min = Math.min(i, this.gSz.length - 1);
        if (min >= 0 && this.gSC > min) {
            for (int i2 = min; i2 < this.gSC; i2++) {
                for (com.tencent.mm.kernel.a.a.a.a aVar : p(this.gSz[i2]).gRQ.values()) {
                    com.tencent.mm.kernel.a.b.f.a aVar2 = (com.tencent.mm.kernel.a.b.f.a) aVar;
                    if (z) {
                        aVar2.gRU = false;
                    }
                    synchronized (aVar2) {
                        aVar2.gSp = aVar2.Dy();
                        aVar2.gSr = false;
                    }
                }
            }
            this.gSC = min;
        }
    }

    public final void prepare() {
        int i;
        j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
        synchronized (this.gSz) {
            if (this.gSz.length > this.gSC) {
                i = this.gSC;
                this.gSC++;
            } else {
                i = -1;
            }
        }
        if (i != -1) {
            p(this.gSz[i]).prepare();
        }
    }

    public final void DQ() {
        while (true) {
            synchronized (this.gSz) {
                if (this.gSz.length <= this.gSC) {
                    return;
                }
            }
            prepare();
        }
    }

    public final com.tencent.mm.kernel.a.b.f.a DD() {
        com.tencent.mm.kernel.a.b.f.a aVar;
        synchronized (this.gSD) {
            aVar = (com.tencent.mm.kernel.a.b.f.a) this.gSD.poll();
        }
        return aVar;
    }

    public final void a(com.tencent.mm.kernel.a.b.f.a aVar) {
        x.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", aVar, aVar.gSu.gRX, aVar.gSu.gSH);
        p(aVar.gSu.gRX).a(aVar);
        if (aVar.gSu.gSH != null) {
            f p = p(aVar.gSu.gSH);
            com.tencent.mm.kernel.a.b.f.a aVar2 = (com.tencent.mm.kernel.a.b.f.a) p.gRQ.get(aVar);
            if (aVar2.gRT != aVar.gRT) {
                x.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", aVar2, aVar2.gRT, aVar, p.gRQ.get(aVar));
            }
            if (p.gSo && aVar2.DM()) {
                p.gSm.b(aVar2);
            }
        }
    }

    public final void b(com.tencent.mm.kernel.a.b.f.a<Object> aVar) {
        synchronized (this.gSD) {
            this.gSD.offer(aVar);
        }
        x.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", aVar, aVar.gSu.gRX);
    }

    public final void a(Class cls, Object obj, Object obj2) {
        int i;
        f p;
        if (this.gSA != null) {
            Class[] clsArr = this.gSA;
            int length = clsArr.length;
            i = 0;
            while (i < length) {
                if (clsArr[i] != cls) {
                    i++;
                }
            }
            i = 0;
            if (i == 0) {
                p = p(cls);
                if (p != null) {
                    p.o(obj, obj2);
                }
            }
            j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
            return;
        }
        i = 1;
        if (i == 0) {
            j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
            return;
        }
        p = p(cls);
        if (p != null) {
            p.o(obj, obj2);
        }
    }

    public final void aL(Object obj) {
        int i = 0;
        if (!this.gSE.containsKey(obj)) {
            this.gSE.putIfAbsent(obj, new a());
        }
        a aVar = (a) this.gSE.get(obj);
        synchronized (aVar.gSF) {
            if (aVar.gSF[0] == (byte) 2) {
            } else {
                if (aVar.gSF[0] == (byte) 1) {
                    try {
                        aVar.gSF.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    aVar.gSF[0] = (byte) 1;
                }
            }
        }
        if (aVar.DR()) {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", obj);
            return;
        }
        j.i("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", obj, Integer.valueOf(obj.hashCode()));
        if (obj instanceof b) {
            a.start();
            ((b) obj).parallelsDependency();
            b DC = a.DC();
            if (DC.gRZ != null) {
                for (com.tencent.mm.kernel.a.b.a.a aVar2 : DC.gRZ.values()) {
                    for (Object next : aVar2.gRY) {
                        if (p(aVar2.gRX).aG(next) == null) {
                            j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", next, obj);
                            aL(next);
                        }
                        a(aVar2.gRX, obj, next);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Class cls : this.gSz) {
            Class cls2;
            if (cls2.isInstance(obj)) {
                arrayList.add(cls2);
            }
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        com.tencent.mm.kernel.a.b.f.a aVar3 = null;
        com.tencent.mm.kernel.a.b.f.a aVar4 = null;
        while (i < clsArr.length) {
            Class cls3 = clsArr[i];
            cls2 = i < clsArr.length + -1 ? clsArr[i + 1] : null;
            com.tencent.mm.kernel.a.b.f.a a = aVar3 != null ? aVar3 : a(cls3, obj);
            aVar3 = cls2 != null ? a(cls2, obj) : null;
            a.gSs = aVar4;
            a.gSt = aVar3;
            if (aVar4 != null) {
                a.gSu.gSG = aVar4.gSu.gRX;
            }
            if (aVar3 != null) {
                a.gSu.gSH = aVar3.gSu.gRX;
            }
            i++;
            aVar4 = a;
        }
        synchronized (aVar.gSF) {
            if (aVar.gSF[0] == (byte) 1) {
                aVar.gSF[0] = (byte) 2;
                aVar.gSF.notifyAll();
            }
        }
    }

    private com.tencent.mm.kernel.a.b.f.a a(Class cls, Object obj) {
        f p = p(cls);
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) p.aG(obj);
        x.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", cls, obj, p);
        if (aVar != null) {
            return aVar;
        }
        Object obj2 = this.gSB.get(cls);
        if (obj2 == null) {
            obj2 = obj;
        }
        p.o(obj, obj2);
        return (com.tencent.mm.kernel.a.b.f.a) p.aG(obj);
    }
}
