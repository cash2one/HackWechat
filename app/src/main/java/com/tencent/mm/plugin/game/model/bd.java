package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bu;
import com.tencent.mm.plugin.game.c.bv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class bd extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public bd(int i, LinkedList<String> linkedList, int i2, boolean z) {
        a aVar = new a();
        aVar.hmj = new bu();
        aVar.hmk = new bv();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        aVar.hmi = 1218;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bu buVar = (bu) this.lMW.hmg.hmo;
        buVar.niD = i;
        buVar.niE = 15;
        buVar.nhF = w.cfi();
        buVar.hvC = bh.cgv();
        buVar.niF = i2;
        buVar.nic = linkedList;
        buVar.niG = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1218;
    }
}
