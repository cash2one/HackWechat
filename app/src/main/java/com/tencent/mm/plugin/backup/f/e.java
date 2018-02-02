package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;

    public e(String str) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[]{str, bh.cgy()});
        a aVar = new a();
        aVar.hmj = new aba();
        aVar.hmk = new abb();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        aVar.hml = 0;
        aVar.hmm = 0;
        aVar.hmi = 595;
        this.gJQ = aVar.JZ();
        ((aba) this.gJQ.hmg.hmo).URL = str;
    }

    public final int getType() {
        return 595;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final abb apY() {
        return (abb) this.gJQ.hmh.hmo;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abb apY = apY();
            d.X(apY.vJC.wJD.oz);
            x.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", new Object[]{apY.ID, apY.vJY, apY.vJZ, apY.vJQ, apY.vJR, Integer.valueOf(apY.rYW), apY.wkc});
            com.tencent.mm.bq.b bVar = apY.vJC.wJD;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
