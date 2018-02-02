package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.ja;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class c$2 extends c<ja> {
    final /* synthetic */ c hsz;

    c$2(c cVar) {
        this.hsz = cVar;
        this.xen = ja.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (an.isConnected(ac.getContext())) {
            x.i("MicroMsg.CdnTransportService", "cdntra mm on network change callback ");
            this.hsz.hsp.removeMessages(1);
            this.hsz.hsp.sendEmptyMessageDelayed(1, 10000);
        }
        return false;
    }
}
