package com.tencent.mm.ad;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.protocal.c.fw;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.k {
    private e gJT;
    LinkedList<bdo> hlC = null;
    LinkedList<ald> hlD = null;

    public j(LinkedList<bdo> linkedList) {
        this.hlC = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.hlC == null || this.hlC.size() <= 0) {
            x.e("MicroMsg.NetSceneBatchGetHeadImg", g.zh() + "doScene ReqSize==0");
            return -1;
        }
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new fv();
        aVar.hmk = new fw();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.hmi = 123;
        aVar.hml = 15;
        aVar.hmm = 1000000015;
        q JZ = aVar.JZ();
        fv fvVar = (fv) JZ.hmg.hmo;
        fvVar.vLm = this.hlC;
        fvVar.ksO = this.hlC.size();
        return a(eVar, JZ, this);
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 20;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.hlD = ((fw) ((b) qVar).hmh.hmo).vLp;
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 123;
    }
}
