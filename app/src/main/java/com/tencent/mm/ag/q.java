package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bc;
import java.util.LinkedList;

public final class q extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public q(String str, int i, String str2, LinkedList<oc> linkedList) {
        a aVar = new a();
        aVar.hmj = new od();
        aVar.hmk = new oe();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        this.gJQ = aVar.JZ();
        od odVar = (od) this.gJQ.hmg.hmo;
        odVar.vXc = i;
        odVar.vXd = str2;
        odVar.vNg = str;
        odVar.vHc = bc.HD();
        if (linkedList != null) {
            odVar.vXe = linkedList;
        }
        x.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d", str, Integer.valueOf(i), str2, odVar.vHc, Integer.valueOf(odVar.vXe.size()));
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
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
