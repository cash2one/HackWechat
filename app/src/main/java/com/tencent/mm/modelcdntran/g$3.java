package com.tencent.mm.modelcdntran;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$3 implements e {
    final /* synthetic */ g htl;

    g$3(g gVar) {
        this.htl = gVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof e) {
            x.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(g.a(this.htl))});
            if ("doScene failed".equals(str)) {
                x.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[]{Integer.valueOf(hashCode())});
                return;
            }
            g.pQN.a(546, (long) (i + 10), 1, true);
            if (i == 0) {
                if (g.a(this.htl) > 0) {
                    g.pQN.a(546, 52, 1, true);
                    g.a(this.htl, 0);
                    return;
                }
                return;
            } else if (i == 4) {
                return;
            } else {
                if (g.a(this.htl) == 0) {
                    int i3 = ((e) kVar).scene;
                    g.a(this.htl, bh.Wp());
                    g.b(this.htl).removeMessages(1);
                    g.b(this.htl).sendMessageDelayed(g.b(this.htl).obtainMessage(1, i3, 0), 30000);
                    g.pQN.a(546, 50, 1, true);
                    return;
                }
                g.a(this.htl, 0);
                g.pQN.a(546, 51, 1, true);
                return;
            }
        }
        x.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
    }
}
