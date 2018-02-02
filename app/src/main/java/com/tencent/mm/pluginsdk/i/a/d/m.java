package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.compatible.d.w;
import com.tencent.mm.pluginsdk.i.a.d.f.a;
import com.tencent.mm.pluginsdk.i.a.d.f.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class m extends f<k> {
    private final a vhP;
    public final c vhQ;

    public m(t tVar, c cVar) {
        this(tVar, cVar, (byte) 0);
    }

    private m(t tVar, c cVar, byte b) {
        this.vhP = new a(this, 4, 4, 3000, TimeUnit.MILLISECONDS, new c(), tVar);
        this.vhP.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.vhP.allowCoreThreadTimeOut(true);
        this.vhQ = cVar;
    }

    public int b(k kVar) {
        int i = 0;
        if (RU(kVar.vgd) || isDownloading(kVar.vgd)) {
            x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[]{kVar.vgd});
            return 0;
        }
        int yV = w.yV();
        x.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[]{Integer.valueOf(yV), Integer.valueOf(kVar.networkType)});
        if (yV != 0) {
            if (2 == kVar.networkType) {
                yV = 1;
            } else if (yV == 1) {
                yV = 1;
            }
            if (yV != 0) {
                x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[]{kVar.vgd});
                return 1;
            }
            if (this.vhP.isShutdown() || this.vhP.isTerminated() || this.vhP.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                return 4;
            }
            super.b(kVar);
            return 2;
        }
        yV = 0;
        if (yV != 0) {
            i = 1;
            if (i != 0) {
                return 4;
            }
            super.b(kVar);
            return 2;
        }
        x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[]{kVar.vgd});
        return 1;
    }

    public final boolean isDownloading(String str) {
        return this.vhA.containsKey(str);
    }

    protected final a bZq() {
        return this.vhP;
    }

    public d a(k kVar) {
        x.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + kVar.getClass().getSimpleName());
        a.vhX;
        d c = o.c(kVar);
        if (c == null) {
            x.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new b(kVar);
        }
        c.vhT = this.vhQ;
        return c;
    }

    public void shutdown() {
        this.vhP.shutdownNow();
        for (String str : this.vhA.keySet()) {
            Future future = (Future) this.vhA.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.vhz.clear();
        this.vhA.clear();
    }
}
