package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bw;
import com.tencent.mm.plugin.game.c.bx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class be extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public be(int i, int i2, int i3) {
        x.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.hmj = new bw();
        aVar.hmk = new bx();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        aVar.hmi = 1220;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bw bwVar = (bw) this.lMW.hmg.hmo;
        bwVar.niD = i;
        bwVar.niE = 15;
        bwVar.nhF = w.cfi();
        bwVar.niL = i2;
        bwVar.niM = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1220;
    }
}
