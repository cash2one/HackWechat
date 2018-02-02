package com.tencent.mm.modelmulti;

import com.tencent.mm.g.a.qg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.b;
import com.tencent.mm.modelmulti.r.e;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class r$e$1 implements b {
    final /* synthetic */ atj hHB;
    final /* synthetic */ int hHC;
    final /* synthetic */ e hHD;

    r$e$1(e eVar, atj com_tencent_mm_protocal_c_atj, int i) {
        this.hHD = eVar;
        this.hHB = com_tencent_mm_protocal_c_atj;
        this.hHC = i;
    }

    public final boolean ie(int i) {
        g.Dk();
        g.Dj().CU().set(8196, Long.valueOf((long) this.hHB.vPq));
        boolean z = (this.hHB.vPq & this.hHD.cLl) != 0;
        x.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", new Object[]{this.hHD, Integer.valueOf(this.hHB.vPq), Boolean.valueOf(z), Integer.valueOf(this.hHB.vPq & 256)});
        if (!(z || (this.hHB.vPq & 256) == 0)) {
            a.xef.m(new qg());
        }
        if (z) {
            if (i == 0 && this.hHD.hHz) {
                x.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[]{this.hHD});
            } else {
                r.a(this.hHD.hHn, this.hHD.scene, this.hHD.cLl);
            }
        }
        this.hHD.hHy.a(0, 0, "", this.hHD);
        r.b(this.hHD.hHn, this.hHD);
        HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.hHC);
        return true;
    }
}
