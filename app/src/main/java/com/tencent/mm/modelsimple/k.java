package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public k(String str, int i, String str2) {
        x.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[]{str, Integer.valueOf(i), str2});
        a aVar = new a();
        aVar.hmj = new su();
        aVar.hmk = new sv();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        aVar.hmi = 1066;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32 && i != 19) {
            str2 = str2.substring(0, 32);
        }
        su suVar = (su) this.gJQ.hmg.hmo;
        suVar.vNg = str;
        suVar.vHW = i;
        suVar.wbm = com.tencent.mm.bq.b.Tl(str2);
        suVar.vYR = com.tencent.mm.bq.b.bc(new byte[0]);
        x.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(suVar.vYR.oz.length)});
    }

    public final int getType() {
        return 1066;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
