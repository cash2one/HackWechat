package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b hMV;

    public t() {
        a aVar = new a();
        aVar.hmj = new afn();
        aVar.hmk = new afo();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        aVar.hmi = 725;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hMV = aVar.JZ();
        ((afn) this.hMV.hmg.hmo).ktN = 0;
        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[]{Integer.valueOf(0), bh.cgy()});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            g.pQN.a(405, 2, 1, true);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 725;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        g.pQN.a(405, 1, 1, true);
        return a(eVar, this.hMV, this);
    }
}
