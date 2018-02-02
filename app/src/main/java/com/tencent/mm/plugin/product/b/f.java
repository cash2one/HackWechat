package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.jx;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public f(LinkedList<bds> linkedList, String str) {
        int i = 0;
        a aVar = new a();
        aVar.hmj = new jx();
        aVar.hmk = new jy();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        this.gJQ = aVar.JZ();
        jx jxVar = (jx) this.gJQ.hmg.hmo;
        jxVar.vQN = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        jxVar.pbw = i;
        jxVar.vQO = str;
        x.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId " + str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        jy jyVar = (jy) ((b) qVar).hmh.hmo;
        if (i3 == 0 && jyVar.vQP != 0) {
            i3 = jyVar.vQP;
            str = jyVar.vQQ;
        }
        x.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
