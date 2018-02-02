package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private LinkedList<brp> nOF = new LinkedList();

    public d(LinkedList<brp> linkedList) {
        a aVar = new a();
        aVar.hmj = new ask();
        aVar.hmk = new asl();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.hmi = 638;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nOF = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.gJT = eVar2;
        ask com_tencent_mm_protocal_c_ask = (ask) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ask.wAd = this.nOF;
        com_tencent_mm_protocal_c_ask.wkd = this.nOF.size();
        return a(eVar, this.gJQ, this);
    }
}
