package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.x;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> gZT = new ConcurrentSkipListMap();
    private Vector<a> gZU = new Vector();
    protected long gZV = 0;

    public abstract long Eq();

    public abstract long Er();

    public abstract long aN(T t);

    public abstract S aO(T t);

    public abstract S b(S s);

    public abstract d<T, S> c(S s);

    public abstract T d(S s);

    static /* synthetic */ void a(e eVar) {
        while (eVar.gZU.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = (a) eVar.gZU.remove(0);
            d c = eVar.c(eVar.b(aVar.Ev()));
            long j = 0;
            int i = 0;
            long Ew = aVar.Ew();
            int Ex = aVar.Ex();
            x.i("MicroMsg.BucketPool", "%s preload start preloadSize: %s sizeInBytes: %s  preLoadBytes: %s and nums: %s", new Object[]{eVar, aVar.Ev(), eVar.b(aVar.Ev()), Long.valueOf(Ew), Integer.valueOf(Ex)});
            while (eVar.gZV < eVar.Eq() && ((Ew <= 0 || j < Ew) && (Ex <= 0 || i < Ex))) {
                Object d = eVar.d(aVar.Ev());
                c.put(d);
                j += eVar.aN(d);
                i++;
                eVar.aH(eVar.aN(d));
            }
            j = System.currentTimeMillis();
            x.d("MicroMsg.BucketPool", "%s preload finished, put %d elements, used %dms", new Object[]{eVar, Integer.valueOf(c.size()), Long.valueOf(j - currentTimeMillis)});
            eVar.gZT.put(eVar.b(aVar.Ev()), c);
        }
    }

    public final void a(a aVar) {
        this.gZU.add(aVar);
        x.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[]{this, aVar});
        Eu();
    }

    public final void Eu() {
        if (this.gZU.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new 1(this), "BucketPool_preload");
        }
    }

    public synchronized T a(S s) {
        T t;
        d dVar = (d) this.gZT.get(s);
        if (dVar == null || dVar.size() <= 0) {
            x.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", new Object[]{s});
            t = null;
        } else {
            T pop = dVar.pop();
            this.gZT.put(dVar.Et(), dVar);
            aI(aN(pop));
            t = pop;
        }
        return t;
    }

    public synchronized void aM(T t) {
        if (t != null) {
            Comparable aO = aO(t);
            long aN = aN(t);
            if (aN > Er()) {
                x.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[]{Long.valueOf(aN)});
            } else if (this.gZV + aN > Eq()) {
                x.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[]{Long.valueOf(aN), Long.valueOf(this.gZV)});
            } else {
                d dVar = (d) this.gZT.get(aO);
                if (dVar == null) {
                    dVar = c(aO);
                }
                dVar.put(t);
                this.gZT.put(aO, dVar);
                aH(aN);
            }
        }
    }

    private synchronized void aH(long j) {
        this.gZV += j;
    }

    protected final synchronized void aI(long j) {
        this.gZV -= j;
    }

    public void Es() {
        x.i("MicroMsg.BucketPool", "freeAll: %s", new Object[]{getClass().getName()});
        this.gZT.clear();
        this.gZV = 0;
    }
}
