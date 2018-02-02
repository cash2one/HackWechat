package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;
    private anu nOG = null;

    public e(int i, String str) {
        a aVar = new a();
        aVar.hmj = new bpg();
        aVar.hmk = new bph();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.hmi = 637;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        if (i >= 0 && !bh.ov(str)) {
            this.nOG = new anu();
            this.nOG.wuI = i;
            this.nOG.wuH = str;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 637;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        bpg com_tencent_mm_protocal_c_bpg = (bpg) this.gJQ.hmg.hmo;
        if (this.nOG != null) {
            com_tencent_mm_protocal_c_bpg.wRv = this.nOG;
            return a(eVar, this.gJQ, this);
        }
        x.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        eVar2.a(3, -1, "[doScene]empty label pair.", this);
        return 0;
    }
}
