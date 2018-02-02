package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bc.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hFi;
    private int scene;
    private String tmN;

    public j(bcp com_tencent_mm_protocal_c_bcp) {
        a aVar = new a();
        aVar.hmi = 1134;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.hmj = com_tencent_mm_protocal_c_bcp;
        aVar.hmk = new bcq();
        this.hFi = aVar.JZ();
        this.scene = com_tencent_mm_protocal_c_bcp.rYW;
        this.tmN = com_tencent_mm_protocal_c_bcp.wIO;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
            g.iq(6);
            g.a(this.scene, 5, i2, i3, this.tmN);
            return;
        }
        this.gJT.a(i2, i3, str, this);
        g.iq(7);
    }

    public final int getType() {
        return 1134;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[]{Integer.valueOf(this.scene)});
        g.iq(5);
        g.c(this.scene, 4, this.tmN);
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }
}
