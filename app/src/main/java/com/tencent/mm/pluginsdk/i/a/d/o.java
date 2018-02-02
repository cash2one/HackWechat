package com.tencent.mm.pluginsdk.i.a.d;

import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public final class o {
    public final af handler;
    private volatile ag hmW;
    public final boolean iYd;
    public final r vhU;
    public final m vhV;
    public final i vhW;

    private static final class a {
        private static final o vhX = new o();
    }

    private static class b implements Runnable {
        private final Runnable hXj;

        private b(Runnable runnable) {
            this.hXj = runnable;
        }

        public final void run() {
            if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.hXj != null) {
                this.hXj.run();
            }
        }
    }

    private o() {
        this.hmW = null;
        p.init();
        this.vhU = r.bZE();
        if (this.vhU == null) {
            this.iYd = false;
            this.vhV = null;
            this.handler = null;
            this.vhW = null;
            return;
        }
        this.iYd = true;
        t tVar = new t();
        this.handler = new af(Looper.getMainLooper());
        this.vhW = new i(Dm().cfF());
        this.vhV = new m(tVar, this.vhW);
    }

    public final void A(Runnable runnable) {
        Dm().F(new b(runnable));
    }

    final ag Dm() {
        if (this.hmW == null) {
            this.hmW = new ag("ResDownloader-WorkerThread");
        }
        return this.hmW;
    }

    public final void a(String str, d dVar) {
        x.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[]{str, dVar});
        if (this.iYd) {
            i iVar = this.vhW;
            x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + dVar);
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (iVar.vhF) {
                    List list = (List) iVar.vhE.get(hashCode);
                    if (list == null) {
                        list = new LinkedList();
                    }
                    list.add(dVar);
                    iVar.vhE.put(hashCode, list);
                }
            }
        }
    }

    static com.tencent.mm.pluginsdk.i.a.d.m.a c(k kVar) {
        x.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = kVar.aab().hashCode();
        for (g gVar : p.bZD()) {
            x.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[]{gVar.getClass().getSimpleName(), gVar.aab()});
            if (gVar.aab().hashCode() == hashCode) {
                return gVar.c(kVar);
            }
        }
        return null;
    }

    public final void e(q qVar) {
        if (this.iYd) {
            long Wp = bh.Wp();
            if (this.vhU.RW(qVar.field_urlKey) != null) {
                x.i("MicroMsg.ResDownloaderCore", "doUpdate: update existing record");
                this.vhU.f(qVar);
            } else {
                x.i("MicroMsg.ResDownloaderCore", "doUpdate: insert new record");
                this.vhU.g(qVar);
            }
            x.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, cost = %d", new Object[]{qVar.field_urlKey, Long.valueOf(bh.bz(Wp))});
        }
    }

    public final q RW(String str) {
        if (!this.iYd) {
            return null;
        }
        long Wp = bh.Wp();
        q RW = this.vhU.RW(str);
        String str2 = "MicroMsg.ResDownloaderCore";
        String str3 = "doQuery: urlKey = %s, cost = %d";
        Object[] objArr = new Object[2];
        objArr[0] = RW == null ? "null" : RW.field_urlKey;
        objArr[1] = Long.valueOf(bh.bz(Wp));
        x.i(str2, str3, objArr);
        return RW;
    }

    public final int d(k kVar) {
        if (!this.iYd) {
            return -1;
        }
        if (bh.ov(kVar.url)) {
            x.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[]{kVar.vgd});
            return 3;
        }
        x.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[]{kVar.vgd});
        return this.vhV.b(kVar);
    }

    public final boolean RX(String str) {
        if (!this.iYd) {
            return false;
        }
        if (this.vhV.isDownloading(str) || this.vhV.RU(str)) {
            return true;
        }
        return false;
    }

    public final void RY(String str) {
        if (this.iYd) {
            f fVar = this.vhV;
            Future future = (Future) fVar.vhA.remove(str);
            if (future != null) {
                future.cancel(true);
            }
            fVar.vhz.remove(str);
        }
    }
}
