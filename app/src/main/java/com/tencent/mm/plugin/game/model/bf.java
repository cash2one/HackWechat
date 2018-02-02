package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class bf extends k implements com.tencent.mm.network.k {
    private String appId;
    private e gJT;
    final b lMW;

    public bf(String str) {
        a aVar = new a();
        aVar.hmj = new ajp();
        aVar.hmk = new ajq();
        aVar.uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
        aVar.hmi = 1369;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.appId = str;
        this.lMW = aVar.JZ();
        ajp com_tencent_mm_protocal_c_ajp = (ajp) this.lMW.hmg.hmo;
        com_tencent_mm_protocal_c_ajp.nhF = w.cfi();
        com_tencent_mm_protocal_c_ajp.hvC = bh.cgv();
        com_tencent_mm_protocal_c_ajp.ngo = str;
        x.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[]{com_tencent_mm_protocal_c_ajp.nhF, com_tencent_mm_protocal_c_ajp.hvC, com_tencent_mm_protocal_c_ajp.ngo});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.gJT.a(i2, i3, str, this);
        } else if (((ajq) ((b) qVar).hmh.hmo) == null) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1369;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }
}
