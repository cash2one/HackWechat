package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.protocal.c.ts;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    public final b hFi;
    public boolean tOn;

    public e(String str, String str2, boolean z) {
        this.tOn = z;
        a aVar = new a();
        com.tencent.mm.bq.a trVar = new tr();
        com.tencent.mm.bq.a tsVar = new ts();
        aVar.hmj = trVar;
        aVar.hmk = tsVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        aVar.hmi = 972;
        aVar.hml = 0;
        aVar.hmm = 0;
        trVar.wbx = str;
        trVar.wbI = str2;
        trVar.wbK = z;
        this.hFi = aVar.JZ();
    }

    public final int getType() {
        return 972;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
