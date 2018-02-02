package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.an;

class t$1 implements Runnable {
    final /* synthetic */ bjv qUr;
    final /* synthetic */ af qUs;
    final /* synthetic */ t qUt;

    t$1(t tVar, bjv com_tencent_mm_protocal_c_bjv, af afVar) {
        this.qUt = tVar;
        this.qUr = com_tencent_mm_protocal_c_bjv;
        this.qUs = afVar;
    }

    public final void run() {
        if (!this.qUr.vIy.equals(t.a(this.qUt))) {
            g.Dk();
            if (g.Dh().Cy()) {
                g.Dk();
                String str = (String) g.Dj().CU().get(68377, null);
                g.Dk();
                if (!(bh.a((Integer) g.Dj().CU().get(68400, null), 0) == this.qUr.pbl && (bh.ov(str) || str.equals(this.qUr.vIy)))) {
                    g.Dk();
                    g.Dj().CU().set(68377, this.qUr.vIy);
                    g.Dk();
                    g.Dj().CU().set(68400, Integer.valueOf(this.qUr.pbl));
                    g.Dk();
                    g.Dj().CU().set(68418, i.eq(this.qUr.vPO));
                }
                for (an GU : t.acW()) {
                    GU.GU();
                }
            } else {
                x.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                return;
            }
        }
        this.qUs.sendEmptyMessage(0);
    }
}
