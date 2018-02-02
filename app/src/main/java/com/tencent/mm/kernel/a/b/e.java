package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T> {
    private static e gSh = null;
    private Queue<c> gSa = new LinkedList();
    private int gSb;
    private volatile a gSc;
    private volatile boolean gSd = false;
    private final byte[] gSe = new byte[0];
    private volatile com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gSf;
    private volatile c<T> gSg;

    public interface a {
        void DG();

        void DJ();
    }

    public static class c {
        public HandlerThread ffg;
        h gSl;
        Handler handler;
    }

    public static class b implements a {
        private final byte[] gOg = new byte[]{(byte) 0};

        public final void DG() {
            try {
                synchronized (this.gOg) {
                    if (this.gOg[0] == (byte) 0) {
                        j.i("MMSkeleton.Parallels", "Waiting for lock(%s)", this.gOg);
                        this.gOg.wait();
                    } else {
                        j.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", this.gOg);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMSkeleton.Parallels", e, "", new Object[0]);
            }
        }

        public final void DJ() {
            synchronized (this.gOg) {
                this.gOg[0] = (byte) 1;
                this.gOg.notify();
                j.i("MMSkeleton.Parallels", "Lock(%s) notified", this.gOg);
            }
        }
    }

    public static e DE() {
        return gSh;
    }

    public static e DF() {
        if (gSh == null) {
            gSh = new e();
        }
        return gSh;
    }

    private e() {
    }

    public final synchronized void init(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Queue queue = this.gSa;
            HandlerThread handlerThread = new HandlerThread("parallels-" + i2, -8);
            handlerThread.start();
            c cVar = new c();
            cVar.ffg = handlerThread;
            queue.add(cVar);
        }
        this.gSb = i;
    }

    public final synchronized void prepare() {
        for (int i = 0; i < this.gSb; i++) {
            c cVar = (c) ((LinkedList) this.gSa).get(i);
            Handler handler = new Handler(cVar.ffg.getLooper());
            h hVar = new h(handler, cVar.ffg.getName());
            cVar.handler = handler;
            cVar.gSl = hVar;
        }
    }

    public final boolean a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar) {
        synchronized (this.gSe) {
            if (this.gSd) {
                x.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
                Assert.assertTrue(false);
                return false;
            }
            this.gSc = aVar;
            this.gSf = aVar2;
            this.gSg = cVar;
            return true;
        }
    }

    public final void a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar, String str) {
        if (a(aVar, (com.tencent.mm.vending.c.a) aVar2, (c) cVar)) {
            cVar.prepare();
            start(str);
            DG();
        }
    }

    public final void DG() {
        this.gSc.DG();
    }

    public final void start(String str) {
        j.i("MMSkeleton.Parallels", "Start working. For %s", str);
        synchronized (this.gSe) {
            this.gSd = true;
        }
        active();
    }

    public final synchronized List<c> DH() {
        return new LinkedList(this.gSa);
    }

    private synchronized c DI() {
        return (c) this.gSa.poll();
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            this.gSa.add(cVar);
            j.d("MMSkeleton.Parallels", "Parallels check threads idle. %s of %s", Integer.valueOf(this.gSa.size()), Integer.valueOf(this.gSb));
            if (this.gSa.size() != this.gSb) {
                z = false;
            }
        }
        return z;
    }

    private void b(c cVar) {
        if (a(cVar)) {
            synchronized (this.gSe) {
                if (this.gSd) {
                    j.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
                }
                this.gSd = false;
                this.gSc.DJ();
            }
        }
    }

    private void active() {
        while (true) {
            c DI = DI();
            if (DI != null) {
                com.tencent.mm.kernel.a.b.f.a DD = this.gSg.DD();
                if (DD != null) {
                    a(DI, DD);
                } else {
                    b(DI);
                    return;
                }
            }
            return;
        }
    }

    private void a(final c cVar, final com.tencent.mm.kernel.a.b.f.a<T> aVar) {
        cVar.gSl.f(new Runnable(this) {
            final /* synthetic */ e gSk;

            public final void run() {
                com.tencent.mm.kernel.a.a.a.a aVar = aVar;
                com.tencent.mm.vending.c.a a = this.gSk.gSf;
                if (!aVar.gRU) {
                    aVar.gSw.gSx.cCp();
                    if (!aVar.gRU) {
                        a.call(aVar);
                        x.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", a, aVar);
                        aVar.gRU = true;
                    }
                    aVar.gSw.gSx.done();
                }
                this.gSk.gSg.a(aVar);
                com.tencent.mm.kernel.a.b.f.a DD = this.gSk.gSg.DD();
                if (DD == null) {
                    this.gSk.b(cVar);
                    return;
                }
                this.gSk.a(cVar, DD);
                this.gSk.active();
            }
        });
    }
}
