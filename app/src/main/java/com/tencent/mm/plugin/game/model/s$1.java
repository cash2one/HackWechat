package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class s$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ s nbZ;

    s$1(s sVar, k kVar) {
        this.nbZ = sVar;
        this.flZ = kVar;
    }

    public final void run() {
        String str;
        s.a(this.nbZ, s.a(this.nbZ) + s.JM());
        bes com_tencent_mm_protocal_c_bes = (bes) ((bh) this.flZ).lMW.hmh.hmo;
        if (com_tencent_mm_protocal_c_bes == null) {
            x.e("MicroMsg.NetSceneSearchGameList", "resp == null");
            str = null;
        } else {
            str = com_tencent_mm_protocal_c_bes.wgV;
        }
        k lVar = new l(str);
        lVar.aQf();
        s.asA().add(lVar);
        x.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[]{Integer.valueOf(lVar.nbI.optInt("remainingCount"))});
        if (lVar.nbI.optInt("remainingCount") > 0) {
            ar.CG().a(new bh(s.a(this.nbZ), s.JM()), 0);
            return;
        }
        s.b(this.nbZ);
        ar.Hg();
        c.CU().a(a.xnd, Long.valueOf(System.currentTimeMillis()));
        Object asA = s.asA();
        if (!bh.cA(asA)) {
            ar.Dm().F(new l$1(asA));
        }
    }
}
