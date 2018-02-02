package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.az;
import com.tencent.mm.plugin.game.c.ba;
import com.tencent.mm.sdk.platformtools.x;

public final class at extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public at(String str) {
        this(str, 0, 0);
    }

    public at(String str, int i, int i2) {
        a aVar = new a();
        aVar.hmj = new az();
        aVar.hmk = new ba();
        aVar.uri = "/cgi-bin/mmgame-bin/gamemsgblock";
        aVar.hmi = 1221;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        az azVar = (az) this.lMW.hmg.hmo;
        azVar.nfn = str;
        azVar.nhu = i;
        azVar.nhv = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameMsgBlock", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1221;
    }
}
