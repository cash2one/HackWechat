package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$2 extends af {
    final /* synthetic */ g htl;

    g$2(g gVar, Looper looper) {
        this.htl = gVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1 && g.a(this.htl) != 0) {
            x.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[]{Integer.valueOf(message.arg1), Long.valueOf(g.a(this.htl)), Long.valueOf(bh.bz(g.a(this.htl)))});
            g.CG().a(new e(r0), 0);
        }
    }
}
