package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public String fAf;
    public b gJQ;
    private e gJT;
    public String lEM;

    public c(String str, String str2, String str3, String str4, String str5) {
        this.fAf = str2;
        this.lEM = str3;
        a aVar = new a();
        aVar.hmj = new vz();
        aVar.hmk = new wa();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        aVar.hmi = 1555;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        vz vzVar = (vz) this.gJQ.hmg.hmo;
        vzVar.wgs = str;
        vzVar.vMb = str2;
        vzVar.pbQ = str3;
        vzVar.wgt = str4;
        vzVar.wgu = str5;
        vzVar.vZK = com.tencent.mm.plugin.wallet_core.model.mall.c.bMe().Na(str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
