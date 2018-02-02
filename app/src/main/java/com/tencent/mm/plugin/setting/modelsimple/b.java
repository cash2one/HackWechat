package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.protocal.c.qo;

public final class b extends k implements com.tencent.mm.network.k {
    public final String appId;
    private e gJT;
    private final int scene;

    public b(String str, int i) {
        this.appId = str;
        this.scene = i;
    }

    public final int getType() {
        return 1127;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        com.tencent.mm.bq.a qnVar = new qn();
        qnVar.fFm = this.appId;
        qnVar.fGW = this.scene;
        aVar.hmj = qnVar;
        aVar.uri = "/cgi-bin/mmbiz-bin/deluserauth";
        aVar.hmk = new qo();
        aVar.hmi = 1127;
        aVar.hml = 0;
        aVar.hmm = 0;
        return a(eVar, aVar.JZ(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        qo qoVar = (qo) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        this.gJT.a(i2, qoVar.vYS.fts, qoVar.vYS.ftt, this);
    }
}
