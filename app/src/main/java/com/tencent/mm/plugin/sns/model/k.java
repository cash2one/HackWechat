package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    private LinkedList<bh> qTI;

    public k(LinkedList<bh> linkedList) {
        a aVar = new a();
        aVar.hmj = new bb();
        aVar.hmk = new bc();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.hmi = 1295;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((bb) this.gJQ.hmg.hmo).vGj = linkedList;
        this.qTI = linkedList;
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
