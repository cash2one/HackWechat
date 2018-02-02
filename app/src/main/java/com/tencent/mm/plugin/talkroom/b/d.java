package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.protocal.c.bnc;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends f {
    public int actionType;
    private final b gJQ;
    private e gJT;
    private final String nUx;
    public int sbS;
    private int sceneType = 0;

    public d(int i, long j, int i2, String str, int i3) {
        this.sceneType = i3;
        a aVar = new a();
        aVar.hmj = new bnc();
        aVar.hmk = new bnd();
        aVar.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        aVar.hmi = 334;
        aVar.hml = f.CTRL_INDEX;
        aVar.hmm = 1000000146;
        this.gJQ = aVar.JZ();
        bnc com_tencent_mm_protocal_c_bnc = (bnc) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bnc.wbh = i;
        com_tencent_mm_protocal_c_bnc.wbi = j;
        com_tencent_mm_protocal_c_bnc.wgQ = i2;
        com_tencent_mm_protocal_c_bnc.vGO = (int) bh.Wo();
        this.actionType = i2;
        this.nUx = str;
        com_tencent_mm_protocal_c_bnc.rYW = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 334;
    }

    public final String bEY() {
        return this.nUx;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.sbS = ((bnd) this.gJQ.hmh.hmo).wbj;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int bEZ() {
        return this.sceneType;
    }
}
