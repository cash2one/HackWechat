package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ic;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public h(String str, String str2, int i, String str3, int i2, int i3) {
        a aVar = new a();
        aVar.hmj = new ic();
        aVar.hmk = new id();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        aVar.hmi = 1064;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ic icVar = (ic) this.gJQ.hmg.hmo;
        icVar.vOf = d.vAt;
        icVar.vOg = d.vAs;
        icVar.vOh = d.vAv;
        icVar.vOi = d.vAw;
        icVar.vOj = w.cfi();
        icVar.pQs = 11294;
        icVar.vOk = null;
        icVar.pSy = str;
        icVar.pSx = str2;
        icVar.type = i;
        icVar.value = str3;
        icVar.count = i2;
        icVar.oXw = i3;
        x.v("MircoMsg.NetSceneScanProductReport", "statid:" + str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1064;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
