package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private e gJT;
    private WakerLock gxW = new WakerLock(ac.getContext());
    private final q hnp;

    public k() {
        this.gxW.lock(3000, "NetSceneSynCheck");
        this.hnp = new a();
        g.Dk();
        if (g.Dj() != null) {
            g.Dk();
            if (g.Dj().CU() != null) {
                g.Dk();
                a aVar = (a) this.hnp.Kb();
                aVar.hFw = bh.VD((String) g.Dj().CU().get(8195, null));
                a aVar2 = (a) this.hnp.Kb();
                g.Dk();
                g.Dh();
                aVar2.uin = com.tencent.mm.kernel.a.Cg();
                ((a) this.hnp.Kb()).netType = com.tencent.mm.protocal.a.getNetType(ac.getContext());
                ((a) this.hnp.Kb()).vBs = com.tencent.mm.protocal.a.cdq();
                x.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                return;
            }
        }
        x.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        int a = a(eVar, this.hnp, this);
        if (a == -1 && this.gxW.isLocking()) {
            this.gxW.unLock();
        }
        return a;
    }

    public final boolean Kd() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        b bVar = (b) qVar.Hp();
        x.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.vBW);
        if (g.Dh().Cy() && !com.tencent.mm.kernel.a.Cs()) {
            byte[] bArr2 = ((a) qVar.Kb()).gPQ;
            if (bh.bw(bArr2)) {
                x.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.gPQ = bArr2;
            ((com.tencent.mm.plugin.zero.b.b) g.h(com.tencent.mm.plugin.zero.b.b.class)).Qc().a(bVar.vBW, 2, bVar.cdK());
        }
        this.gJT.a(i2, i3, str, this);
        this.gxW.unLock();
    }
}
