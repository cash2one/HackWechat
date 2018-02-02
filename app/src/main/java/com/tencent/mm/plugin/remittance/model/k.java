package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public iy pKy;

    public k(cd cdVar, String str) {
        a aVar = new a();
        aVar.hmj = new ix();
        aVar.hmk = new iy();
        aVar.hmi = 2702;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        ix ixVar = (ix) this.hNJ.hmg.hmo;
        ixVar.vOU = cdVar;
        ixVar.vPd = str;
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[]{cdVar.vHq, cdVar.vHr, Integer.valueOf(cdVar.vHv)});
    }

    public final int getType() {
        return 2702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKy = (iy) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pKy.kLO), this.pKy.kLP});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
