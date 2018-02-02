package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public int fut;
    private e gJT;
    private final com.tencent.mm.ae.b hFi;

    public b(int i) {
        this.fut = i;
        a aVar = new a();
        com.tencent.mm.bq.a tjVar = new tj();
        com.tencent.mm.bq.a tkVar = new tk();
        aVar.hmj = tjVar;
        aVar.hmk = tkVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        aVar.hmi = 792;
        aVar.hml = 0;
        aVar.hmm = 0;
        tjVar.nhx = i;
        tjVar.wbw = 1;
        this.hFi = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 792;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }
}
