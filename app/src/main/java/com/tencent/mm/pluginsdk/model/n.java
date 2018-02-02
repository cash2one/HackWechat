package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public n(String str, String str2) {
        this(str, str2, 0);
    }

    public n(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new bfr();
        aVar.hmk = new bfs();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.hmi = 153;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bfr com_tencent_mm_protocal_c_bfr = (bfr) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bfr.wKC = str;
        com_tencent_mm_protocal_c_bfr.nje = str2;
        com_tencent_mm_protocal_c_bfr.wuD = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 153;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
