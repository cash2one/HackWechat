package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ber;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.x;

public final class bh extends k implements com.tencent.mm.network.k {
    private e gJT;
    final b lMW;

    public bh(int i, int i2) {
        x.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.hmj = new ber();
        aVar.hmk = new bes();
        aVar.uri = "/cgi-bin/mmgame-bin/searchgamelist";
        aVar.hmi = 1215;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        ber com_tencent_mm_protocal_c_ber = (ber) this.lMW.hmg.hmo;
        com_tencent_mm_protocal_c_ber.niD = i;
        com_tencent_mm_protocal_c_ber.niE = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1215;
    }
}
