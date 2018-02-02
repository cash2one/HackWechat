package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private lk pKz;

    public l(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hmj = new lk();
        aVar.hmk = new ll();
        aVar.hmi = 1273;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.pKz = (lk) this.hNJ.hmg.hmo;
        this.pKz.vHq = str;
        this.pKz.vHr = str2;
        this.pKz.vUk = str3;
        this.pKz.vUl = str4;
        this.pKz.nZd = i;
        x.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[]{str, str2, str3, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1273;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
