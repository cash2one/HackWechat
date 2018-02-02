package com.tencent.mm.plugin.ext.c.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mp;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    public String mUrl = null;
    public int mbw = -1;

    public a(String str, int i, int i2) {
        this.mUrl = str;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new mp();
        aVar.hmk = new mq();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
        aVar.hmi = 782;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[]{str});
        mp mpVar = (mp) this.gJQ.hmg.hmo;
        mpVar.URL = this.mUrl;
        mpVar.vVn = i;
        mpVar.vVo = i2;
    }

    public final int getType() {
        return 782;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        mq mqVar = (mq) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            this.mbw = mqVar.ktN;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
