package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class w extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public w(LinkedList<bcd> linkedList) {
        a aVar = new a();
        aVar.hmj = new bce();
        aVar.hmk = new bcf();
        aVar.uri = "/cgi-bin/micromsg-bin/reportcommand";
        this.gJQ = aVar.JZ();
        ((bce) this.gJQ.hmg.hmo).vXe = linkedList;
        x.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", Integer.valueOf(r0.vXe.size()));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 359;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
