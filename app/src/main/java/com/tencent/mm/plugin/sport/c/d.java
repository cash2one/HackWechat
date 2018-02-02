package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.protocal.c.agd;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hFi;
    agd rTP;
    age rTQ;
    c rTR;

    public d(long j, long j2, c cVar) {
        this.rTR = cVar;
        a aVar = new a();
        aVar.hmi = 1734;
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
        aVar.hmj = new agd();
        aVar.hmk = new age();
        this.hFi = aVar.JZ();
        this.rTP = (agd) this.hFi.hmg.hmo;
        this.rTP.vZj = (int) (j / 1000);
        this.rTP.vZk = (int) (j2 / 1000);
    }

    public final int getType() {
        return 1734;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.rTQ = (age) this.hFi.hmh.hmo;
        this.gJT.a(i2, i3, str, this);
    }
}
