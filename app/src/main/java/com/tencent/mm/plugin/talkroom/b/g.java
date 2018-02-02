package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.protocal.c.bni;
import com.tencent.mm.protocal.c.bnj;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public g(LinkedList<bni> linkedList, int i) {
        a aVar = new a();
        aVar.hmj = new bnj();
        aVar.hmk = new bnk();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.hmi = r.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bnj com_tencent_mm_protocal_c_bnj = (bnj) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bnj.wQg = linkedList.size();
        com_tencent_mm_protocal_c_bnj.wQh = linkedList;
        com_tencent_mm_protocal_c_bnj.rYW = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return r.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
