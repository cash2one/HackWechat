package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.im;
import com.tencent.mm.protocal.c.in;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public in pKm;

    public f(String str, String str2, String str3, int i, com.tencent.mm.bq.b bVar, String str4) {
        a aVar = new a();
        aVar.hmj = new im();
        aVar.hmk = new in();
        aVar.hmi = 1680;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2factqry";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        im imVar = (im) this.hNJ.hmg.hmo;
        imVar.pLn = str3;
        imVar.vHq = str;
        imVar.vHr = str2;
        imVar.vHv = i;
        imVar.vOL = bVar;
        imVar.vHs = str4;
        x.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[]{str, str2, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1680;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKm = (in) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pKm.kLO), this.pKm.kLP});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
