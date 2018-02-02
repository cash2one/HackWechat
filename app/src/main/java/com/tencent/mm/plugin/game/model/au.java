package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class au extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public au(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i) {
        a aVar = new a();
        aVar.hmj = new wr();
        aVar.hmk = new ws();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        aVar.hmi = 1328;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        wr wrVar = (wr) this.lMW.hmg.hmo;
        wrVar.nhF = str;
        wrVar.wha = linkedList;
        wrVar.wgT = linkedList2;
        wrVar.whb = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1328;
    }
}
