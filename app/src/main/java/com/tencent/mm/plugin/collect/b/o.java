package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhj;
import com.tencent.mm.protocal.c.bhk;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private bhj liY;

    public o(String str) {
        a aVar = new a();
        aVar.hmj = new bhj();
        aVar.hmk = new bhk();
        aVar.hmi = 304;
        aVar.uri = "/cgi-bin/micromsg-bin/setpushsound";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.liY = (bhj) this.hNJ.hmg.hmo;
        this.liY.ktN = 3;
        this.liY.wLd = str;
        x.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[]{Integer.valueOf(3), str});
    }

    public final int getType() {
        return 304;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
