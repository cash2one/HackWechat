package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.n;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private n iha;
    public o ihb;

    public i(String str, long j, int i, String str2) {
        a aVar = new a();
        aVar.hmj = new n();
        aVar.hmk = new o();
        aVar.hmi = 1629;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.iha = (n) this.hNJ.hmg.hmo;
        this.iha.vCW = str;
        this.iha.vDp = j;
        this.iha.scene = i;
        this.iha.vCX = str2;
        x.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[]{this.iha.vCW, Long.valueOf(this.iha.vDp), Integer.valueOf(this.iha.scene), this.iha.vCX});
    }

    public final int getType() {
        return 1629;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.ihb = (o) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[]{Integer.valueOf(this.ihb.liH), this.ihb.liI, this.ihb.fEn});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
