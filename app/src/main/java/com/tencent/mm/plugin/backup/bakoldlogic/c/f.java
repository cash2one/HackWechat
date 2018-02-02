package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public f(String str) {
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

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final abb aqE() {
        return (abb) this.gJQ.hmh.hmo;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abb com_tencent_mm_protocal_c_abb = (abb) this.gJQ.hmh.hmo;
            d.X(com_tencent_mm_protocal_c_abb.vJC.wJD.oz);
            x.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", new Object[]{com_tencent_mm_protocal_c_abb.ID, com_tencent_mm_protocal_c_abb.vJY, com_tencent_mm_protocal_c_abb.vJZ, com_tencent_mm_protocal_c_abb.vJQ, com_tencent_mm_protocal_c_abb.vJR, Integer.valueOf(com_tencent_mm_protocal_c_abb.rYW)});
            x.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", new Object[]{com_tencent_mm_protocal_c_abb.wkc});
            com.tencent.mm.bq.b bVar = com_tencent_mm_protocal_c_abb.vJC.wJD;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
