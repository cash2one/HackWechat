package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class SnsOnlineVideoActivity$2 implements c {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$2(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(n nVar) {
        int i = 1;
        if (bh.VI(g.zY().getValue("SIGHTCannotTransmitForFav")) == 0) {
            x.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.bO(SnsOnlineVideoActivity.n(this.rEF))), Boolean.valueOf(FileOp.bO(SnsOnlineVideoActivity.o(this.rEF)))});
            nVar.add(0, 3, 0, this.rEF.getString(j.qKc));
            if (FileOp.bO(SnsOnlineVideoActivity.n(this.rEF))) {
            }
        }
        i = 0;
        if (d.OQ("favorite")) {
            nVar.add(0, 2, 0, this.rEF.getString(j.eAd));
        }
        nVar.add(0, 5, 0, this.rEF.getString(j.eHh));
        if (i != 0) {
            b dhVar = new dh();
            dhVar.frQ.frH = SnsOnlineVideoActivity.p(this.rEF);
            a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                nVar.add(0, 4, 0, this.rEF.getString(j.qJu));
            }
        }
    }
}
