package com.tencent.mm.modelcdntran;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 extends a {
    final /* synthetic */ c hsz;

    c$3(c cVar) {
        this.hsz = cVar;
    }

    public final void eq(int i) {
        x.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
        if ((i == 4 || i == 6) && g.Dh().Cy()) {
            this.hsz.hsp.removeMessages(1);
            BaseEvent.onNetworkChange();
        }
    }
}
