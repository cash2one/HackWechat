package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.protocal.c.uk;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public String mFileName = "";

    public r(String str, long j, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hmj = new uj();
        aVar.hmk = new uk();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        aVar.hmi = 1197;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.mFileName = str;
        uj ujVar = (uj) this.gJQ.hmg.hmo;
        ujVar.fFm = str2;
        ujVar.wck = j;
        ujVar.wcl = str4;
        ujVar.wcp = str3;
    }

    public final int getType() {
        return 1197;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
