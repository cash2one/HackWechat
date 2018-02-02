package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gJT;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.hmC = i;
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 869;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new agt();
        aVar.hmk = new agu();
        aVar.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        aVar.hmi = 869;
        aVar.hml = 0;
        aVar.hml = 0;
        return a(eVar, aVar.JZ(), this);
    }
}
