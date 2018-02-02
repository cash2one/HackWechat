package com.tencent.mm.modelstat;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;

class l$1 implements Runnable {
    final /* synthetic */ long hSg;
    final /* synthetic */ l hSh;

    l$1(l lVar, long j) {
        this.hSh = lVar;
        this.hSg = j;
    }

    public final void run() {
        long Wp = bh.Wp();
        long a = l.a(new File(g.Dj().cachePath), this.hSg);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Dj().cachePath});
        a = l.a(new File(g.Dj().gQh), this.hSg);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Dj().gQh});
        a = l.a(new File(g.Dj().gQh), this.hSg);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Dj().gQh});
        a = l.a(new File(g.Dj().gQi), this.hSg);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Dj().gQi});
        a = l.a(new File(w.gZK), this.hSg);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), w.gZK});
        x.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[]{Long.valueOf(bh.Wp() - Wp)});
    }
}
