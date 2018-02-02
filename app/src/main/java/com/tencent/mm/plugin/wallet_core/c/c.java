package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.of;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public c(LinkedList<String> linkedList) {
        x.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        a aVar = new a();
        aVar.hmj = new yv();
        aVar.hmk = new yw();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        aVar.hmi = 1650;
        this.gJQ = aVar.JZ();
        this.gJQ.hmx = true;
        yv yvVar = (yv) this.gJQ.hmg.hmo;
        yvVar.wiN = linkedList;
        yvVar.vQS = i.bLf();
        if (!f.ccT()) {
            yvVar.vUz = f.ccU();
        }
        com.tencent.mm.wallet_core.ui.e.HF(42);
    }

    public final int getType() {
        return 1650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            yw ywVar = (yw) ((b) qVar).hmh.hmo;
            x.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[]{ywVar.wiP});
            LinkedList linkedList = ywVar.wiO;
            if (linkedList == null || linkedList.size() == 0) {
                x.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                com.tencent.mm.sdk.b.b ofVar = new of();
                ofVar.fGc.fGe = linkedList;
                com.tencent.mm.sdk.b.a.xef.m(ofVar);
            }
            g.Dk();
            g.Dj().CU().a(w.a.xrm, bh.az(ywVar.wiP, ""));
            g.Dk();
            g.Dj().CU().a(w.a.xrn, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            com.tencent.mm.wallet_core.ui.e.HF(43);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
