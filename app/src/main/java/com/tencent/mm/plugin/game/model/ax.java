package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bg;
import com.tencent.mm.plugin.game.c.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ax extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public ax(String str, String str2, boolean z) {
        a aVar = new a();
        aVar.hmj = new bg();
        aVar.hmk = new bh();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        aVar.hmi = 1217;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bg bgVar = (bg) this.lMW.hmg.hmo;
        bgVar.nhF = str;
        bgVar.nfn = str2;
        bgVar.nhP = z;
        bgVar.nhR = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1217;
    }
}
