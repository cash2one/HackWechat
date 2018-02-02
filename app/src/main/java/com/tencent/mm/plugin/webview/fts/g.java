package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    public int fDl = -1;
    b gJQ;
    private e gJT;

    public g() {
        a aVar = new a();
        aVar.hmj = new bxh();
        aVar.hmk = new bxi();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
        aVar.hmi = 1866;
        this.gJQ = aVar.JZ();
        aoh Je = com.tencent.mm.plugin.aj.a.g.Je();
        bxh com_tencent_mm_protocal_c_bxh = (bxh) this.gJQ.hmg.hmo;
        if (Je != null) {
            com_tencent_mm_protocal_c_bxh.wYa = (double) Je.vQu;
            com_tencent_mm_protocal_c_bxh.wYb = (double) Je.vQt;
        }
        com_tencent_mm_protocal_c_bxh.wYc = com.tencent.mm.plugin.aj.a.g.bfF();
    }

    public final int getType() {
        return this.gJQ.hmi;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
