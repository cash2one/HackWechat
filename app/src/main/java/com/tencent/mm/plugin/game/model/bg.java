package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bb;
import com.tencent.mm.plugin.game.c.bc;
import com.tencent.mm.sdk.platformtools.x;

public final class bg extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final b lMW;

    public bg(String str, int i, int i2, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new bb();
        aVar.hmk = new bc();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        aVar.hmi = 1223;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bb bbVar = (bb) this.lMW.hmg.hmo;
        bbVar.nfn = str;
        bbVar.nhx = i;
        bbVar.nhy = i2;
        bbVar.nhz = str2;
        bbVar.nhA = str3;
        bbVar.nhw = (int) (System.currentTimeMillis() / 1000);
    }

    public final int getType() {
        return 1223;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
