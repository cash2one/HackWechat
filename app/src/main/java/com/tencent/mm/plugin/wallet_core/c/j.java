package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private boolean sIo;
    private tg sIu;
    public th sIv;

    public j(String str, boolean z) {
        this.sIo = z;
        a aVar = new a();
        aVar.hmj = new tg();
        aVar.hmk = new th();
        if (z) {
            aVar.hmi = 2529;
            aVar.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";
        } else {
            aVar.hmi = 2888;
            aVar.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure";
        }
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.sIu = (tg) this.hNJ.hmg.hmo;
        this.sIu.wbs = str;
    }

    public final int getType() {
        if (this.sIo) {
            return 2529;
        }
        return 2888;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sIv = (th) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
