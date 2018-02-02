package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.an;

class t$2 implements Runnable {
    final /* synthetic */ af qUs;
    final /* synthetic */ t qUt;
    final /* synthetic */ boolean qUu;
    final /* synthetic */ bje qUv;

    t$2(t tVar, boolean z, bje com_tencent_mm_protocal_c_bje, af afVar) {
        this.qUt = tVar;
        this.qUu = z;
        this.qUv = com_tencent_mm_protocal_c_bje;
        this.qUs = afVar;
    }

    public final void run() {
        if (this.qUu) {
            for (an anVar : t.acW()) {
                x.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                anVar.GT();
            }
        }
        this.qUs.sendEmptyMessage(0);
    }
}
