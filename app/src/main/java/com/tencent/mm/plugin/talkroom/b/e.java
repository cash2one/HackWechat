package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends f {
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;
    private final String nUx;
    private int sceneType = 0;

    public e(String str, int i, long j, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.hmj = new bne();
        aVar.hmk = new bnf();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.hmi = 335;
        aVar.hml = f.CTRL_INDEX;
        aVar.hmm = 1000000149;
        this.gJQ = aVar.JZ();
        bne com_tencent_mm_protocal_c_bne = (bne) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bne.wbh = i;
        com_tencent_mm_protocal_c_bne.wbi = j;
        com_tencent_mm_protocal_c_bne.vGO = (int) bh.Wo();
        this.nUx = str;
        com_tencent_mm_protocal_c_bne.rYW = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        x.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 335;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final String bEY() {
        return this.nUx;
    }

    public final int bEZ() {
        return this.sceneType;
    }
}
