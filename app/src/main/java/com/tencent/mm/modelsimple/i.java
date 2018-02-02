package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public i(String str) {
        x.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[]{str});
        a aVar = new a();
        aVar.hmj = new ql();
        aVar.hmk = new qm();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        aVar.hmi = 1067;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ql qlVar = (ql) this.gJQ.hmg.hmo;
        qlVar.vNg = str;
        qlVar.vYR = com.tencent.mm.bq.b.bc(new byte[0]);
    }

    public final int getType() {
        return 1067;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
