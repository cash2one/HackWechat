package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.dx;
import com.tencent.mm.plugin.game.c.dy;
import com.tencent.mm.sdk.platformtools.x;

public final class bi extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public bi(String str, String str2, String str3, boolean z) {
        a aVar = new a();
        aVar.hmj = new dx();
        aVar.hmk = new dy();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        aVar.hmi = 1219;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        dx dxVar = (dx) this.lMW.hmg.hmo;
        dxVar.nfn = str;
        dxVar.nhF = str2;
        dxVar.nfl = str3;
        dxVar.nfA = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1219;
    }
}
