package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.u;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private u ihc;
    public v ihd;

    public j(String str, int i, String str2, String str3, int i2) {
        a aVar = new a();
        aVar.hmj = new u();
        aVar.hmk = new v();
        aVar.hmi = 1695;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.ihc = (u) this.hNJ.hmg.hmo;
        this.ihc.vCW = str;
        this.ihc.scene = i;
        this.ihc.vCX = str2;
        if (i == 5) {
            x.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
            this.ihc.sign = str3;
            this.ihc.ver = i2;
        }
        x.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[]{str, Integer.valueOf(i), str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.ihd = (v) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.ihd.liH), this.ihd.liI});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1695;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }
}
