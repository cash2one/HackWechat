package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public is pKv;

    public h(cd cdVar, String str) {
        a aVar = new a();
        aVar.hmj = new ir();
        aVar.hmk = new is();
        aVar.hmi = 1241;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        ir irVar = (ir) this.hNJ.hmg.hmo;
        irVar.vOU = cdVar;
        irVar.vOV = str;
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[]{cdVar.vHq, cdVar.vHr, Integer.valueOf(cdVar.vHv), a.a(cdVar)});
    }

    public final int getType() {
        return 1241;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKv = (is) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pKv.kLO), this.pKv.kLP});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
