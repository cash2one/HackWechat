package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.l;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private l igY;
    public m igZ;

    public h() {
        a aVar = new a();
        aVar.hmj = new l();
        aVar.hmk = new m();
        aVar.hmi = 1698;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.igY = (l) this.hNJ.hmg.hmo;
    }

    public final int getType() {
        return 1698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.igZ = (m) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(this.igZ.liH), this.igZ.liI, Integer.valueOf(this.igZ.vDk), Integer.valueOf(this.igZ.vDl), Integer.valueOf(this.igZ.vDm), Long.valueOf(this.igZ.vDn), Long.valueOf(this.igZ.vDo), this.igZ.liT, this.igZ.liU});
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
