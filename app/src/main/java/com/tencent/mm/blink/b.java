package com.tencent.mm.blink;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private static b gxs = new b();
    private final Queue<a> gxt = new LinkedList();
    private boolean gxu = false;
    private volatile boolean gxv = false;
    private boolean gxw = true;
    private volatile c gxx = g.czW();
    private AtomicBoolean gxy = new AtomicBoolean(false);
    private ag gxz = new ag("pending-stage");

    private enum b {
        Now,
        Timeout,
        FirstScreen
    }

    private static class a implements e {
        private d ffh;
        private Runnable mRunnable;

        public a(Runnable runnable, d dVar) {
            this.mRunnable = runnable;
            this.ffh = dVar;
        }

        public final Object call(Object obj) {
            x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", this.mRunnable, this.ffh.getType());
            this.mRunnable.run();
            return null;
        }

        public final String wx() {
            if (!(this.ffh instanceof com.tencent.mm.vending.h.c)) {
                return this.ffh.getType();
            }
            if (d.czY() instanceof com.tencent.mm.vending.h.c) {
                return d.zCO.mType;
            }
            return d.czY().getType();
        }
    }

    public static b wo() {
        return gxs;
    }

    public final synchronized void wp() {
        this.gxu = true;
    }

    public final synchronized void wq() {
        this.gxw = true;
        if (this.gxu) {
            wu();
        }
    }

    public final synchronized void wr() {
        this.gxw = false;
    }

    public final synchronized void ws() {
        if (this.gxu) {
            this.gxu = false;
            wu();
        }
    }

    public final synchronized void f(Runnable runnable) {
        d czY = d.czY();
        if (!(czY instanceof com.tencent.mm.vending.h.c)) {
            com.tencent.mm.vending.h.g.a(czY.getType(), czY);
        }
        if (wt()) {
            x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement arrange runnable postToMainThread %s", runnable);
            this.gxx.b(new a(runnable, czY));
        } else {
            x.i("MicroMsg.FirstScreenArrangement", "arrange first screen runnable: %s, %s, %s, %s", Boolean.valueOf(this.gxu), Boolean.valueOf(this.gxw), Boolean.valueOf(this.gxv), this.gxt);
            this.gxt.add(new a(runnable, czY));
        }
    }

    private synchronized boolean wt() {
        boolean z;
        z = (!this.gxu || this.gxw) && this.gxv;
        return z;
    }

    private void wu() {
        a(b.FirstScreen);
        wv();
    }

    private synchronized void wv() {
        if (wt()) {
            while (true) {
                a aVar = (a) this.gxt.poll();
                if (aVar == null) {
                    break;
                }
                x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", aVar.mRunnable, aVar.ffh.getType());
                this.gxx.b(aVar);
            }
        }
    }

    private void a(final b bVar) {
        if (!this.gxy.compareAndSet(false, true)) {
            return;
        }
        if (bVar == b.Now) {
            x.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
            com.tencent.mm.kernel.a.c.Dt().Du();
            synchronized (this) {
                this.gxv = true;
                wv();
            }
            return;
        }
        d hVar = new h(new com.tencent.mm.cd.d(this.gxz.cfF()), "pending-stage");
        synchronized (this) {
            this.gxx.a(hVar).b(new com.tencent.mm.vending.c.a<Object, Void>(this) {
                final /* synthetic */ b gxB;

                public final /* synthetic */ Object call(Object obj) {
                    return ww();
                }

                private Object ww() {
                    x.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
                    com.tencent.mm.kernel.a.c.Dt().Du();
                    synchronized (this) {
                        this.gxB.gxv = true;
                        this.gxB.wv();
                    }
                    return null;
                }
            });
        }
    }

    public final synchronized void aR(boolean z) {
        x.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", Boolean.valueOf(z));
        if (z) {
            a(b.Now);
        } else {
            ag.h(new Runnable(this) {
                final /* synthetic */ b gxB;

                {
                    this.gxB = r1;
                }

                public final void run() {
                    this.gxB.a(b.Timeout);
                }
            }, 1000);
        }
    }
}
