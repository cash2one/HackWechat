package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ae.b gJQ;
    private e gJT;
    private String qpE;
    private int scene;

    public b(String str, int i) {
        this.qpE = str;
        this.scene = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new agl();
        aVar.hmk = new agm();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.hmi = 552;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        agl com_tencent_mm_protocal_c_agl = (agl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_agl.wnW = this.qpE;
        com_tencent_mm_protocal_c_agl.rYW = this.scene;
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        agl com_tencent_mm_protocal_c_agl = (agl) ((com.tencent.mm.ae.b) qVar).hmg.hmo;
        if (com_tencent_mm_protocal_c_agl.rYW >= 0 && com_tencent_mm_protocal_c_agl.wnW != null && com_tencent_mm_protocal_c_agl.wnW.length() > 0) {
            return com.tencent.mm.ae.k.b.hmP;
        }
        x.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_agl.rYW)});
        return com.tencent.mm.ae.k.b.hmQ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 552;
    }
}
