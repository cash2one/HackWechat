package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private kx pKA;
    public ky pKB;

    public m(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6) {
        a aVar = new a();
        aVar.hmj = new kx();
        aVar.hmk = new ky();
        aVar.hmi = 2773;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.pKA = (kx) this.hNJ.hmg.hmo;
        this.pKA.vHq = str;
        this.pKA.vHr = str2;
        this.pKA.nZd = i;
        this.pKA.pLh = str3;
        this.pKA.pLg = str4;
        this.pKA.fCR = i2;
        this.pKA.pKd = i3;
        this.pKA.vTJ = str5;
        this.pKA.vTK = str6;
    }

    public final int getType() {
        return 2773;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKB = (ky) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pKB.liH), this.pKB.liI});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
