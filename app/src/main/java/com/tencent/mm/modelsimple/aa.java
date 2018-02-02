package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final b hFi;
    public Object tag;

    public aa(String str) {
        a aVar = new a();
        aVar.hmj = new anc();
        aVar.hmk = new and();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        aVar.hmi = 666;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        ((anc) this.hFi.hmg.hmo).nfX = str;
    }

    public final int getType() {
        return 666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final and Sm() {
        return (and) this.hFi.hmh.hmo;
    }
}
