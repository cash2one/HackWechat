package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tl;
import com.tencent.mm.protocal.c.tm;

public final class c extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final b hFi;

    public c(String str) {
        a aVar = new a();
        com.tencent.mm.bq.a tlVar = new tl();
        com.tencent.mm.bq.a tmVar = new tm();
        aVar.hmj = tlVar;
        aVar.hmk = tmVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        aVar.hmi = 973;
        aVar.hml = 0;
        aVar.hmm = 0;
        tlVar.wbx = str;
        this.hFi = aVar.JZ();
    }

    public final int getType() {
        return 973;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
