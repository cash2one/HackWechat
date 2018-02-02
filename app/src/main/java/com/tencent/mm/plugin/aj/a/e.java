package com.tencent.mm.plugin.aj.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzs;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    private b hFi;
    bzs tkj = new bzs();
    bzt tkk;

    public e(List<String> list, int i, long j, List<or> list2) {
        a aVar = new a();
        aVar.hmi = 1948;
        aVar.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        aVar.hmj = new bzs();
        aVar.hmk = new bzt();
        this.hFi = aVar.JZ();
        this.tkj = (bzs) this.hFi.hmg.hmo;
        this.tkj.wwH = g.zN(0);
        this.tkj.lOo = w.eL(ac.getContext());
        this.tkj.whF = g.bfF();
        this.tkj.wwI = g.Je();
        this.tkj.rYW = i;
        this.tkj.vPp = 0;
    }

    public final int getType() {
        return 1948;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tkk = (bzt) this.hFi.hmh.hmo;
            if (this.tkk != null) {
                x.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", this.tkk.vOe);
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
