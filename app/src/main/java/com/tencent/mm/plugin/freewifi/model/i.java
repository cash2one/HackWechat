package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bp;
import com.tencent.mm.protocal.c.bq;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private String fFm;
    private final b gJQ;
    private e gJT;

    private i() {
        a aVar = new a();
        aVar.hmj = new bp();
        aVar.hmk = new bq();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.hmi = 1703;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public i(String str, String str2, int i, String str3) {
        this();
        this.fFm = str;
        bp bpVar = (bp) this.gJQ.hmg.hmo;
        bpVar.nkv = str;
        bpVar.nfX = str2;
        bpVar.vDY = i;
        bpVar.vDZ = str3;
        x.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[]{str});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.fFm});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
