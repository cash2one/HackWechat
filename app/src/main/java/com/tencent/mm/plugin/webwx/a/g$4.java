package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class g$4 implements q<bw> {
    final /* synthetic */ g tOt;

    g$4(g gVar) {
        this.tOt = gVar;
    }

    public final /* synthetic */ void e(a aVar) {
        bw bwVar = (bw) aVar;
        if (bwVar.ngq != 51 && com.tencent.mm.z.q.FS().equals(bwVar.vGX.wJF)) {
            ar.Hg();
            cf F = c.Fa().F(bwVar.vGY.wJF, bwVar.vHe);
            if (F.field_msgSvrId == 0) {
                x.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(bwVar.vHe));
                return;
            }
            x.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] selfSend msg, svrID:%d, localId:%d", Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId));
            g.bVr().bVt().fm(F.field_msgId);
        }
    }

    public final /* bridge */ /* synthetic */ void f(a aVar) {
    }
}
