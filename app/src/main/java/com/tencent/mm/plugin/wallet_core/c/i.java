package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adn;
import com.tencent.mm.protocal.c.ado;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private boolean sIo;
    private adn sIs;
    public ado sIt;

    public i(String str, boolean z) {
        this.sIo = z;
        a aVar = new a();
        aVar.hmj = new adn();
        aVar.hmk = new ado();
        if (z) {
            aVar.hmi = 2803;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";
        } else {
            aVar.hmi = 2508;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetlottery";
        }
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.sIs = (adn) this.hNJ.hmg.hmo;
        this.sIs.wme = str;
        x.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[]{str, Boolean.valueOf(z)});
    }

    public final int getType() {
        if (this.sIo) {
            return 2803;
        }
        return 2508;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sIt = (ado) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
