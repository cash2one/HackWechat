package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private ro sIm;
    public rp sIn;
    private boolean sIo;

    public g(String str, int i, boolean z) {
        this.sIo = z;
        a aVar = new a();
        aVar.hmj = new ro();
        aVar.hmk = new rp();
        if (z) {
            aVar.hmi = 1859;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";
        } else {
            aVar.hmi = 2547;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawlottery";
        }
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.sIm = (ro) this.hNJ.hmg.hmo;
        this.sIm.vZA = str;
        this.sIm.vZB = i;
        x.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)});
    }

    public final int getType() {
        if (this.sIo) {
            return 1859;
        }
        return 2547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sIn = (rp) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
