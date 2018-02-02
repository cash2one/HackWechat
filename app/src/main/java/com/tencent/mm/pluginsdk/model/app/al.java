package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class al extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private int hQu;
    private String nec;

    public al(int i, String str) {
        a aVar = new a();
        aVar.hmj = new wx();
        aVar.hmk = new wy();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.hmi = 427;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        wx wxVar = (wx) this.gJQ.hmg.hmo;
        wxVar.vOf = d.vAt;
        wxVar.vOg = d.vAs;
        wxVar.vOh = d.vAv;
        wxVar.vOi = d.vAw;
        wxVar.vOj = w.cfi();
        wxVar.pQs = i;
        wxVar.vOk = str;
        this.hQu = i;
        this.nec = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetsceneGameKVReport", "errType = " + i2 + ", errCode = " + i3 + ", logId = " + this.hQu + ", logExt = " + this.nec);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 427;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
