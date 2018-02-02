package com.tencent.mm.bc;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public i(String str) {
        a aVar = new a();
        aVar.hmi = 1944;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
        aVar.hmj = new bez();
        aVar.hmk = new bfa();
        this.gJQ = aVar.JZ();
        bez com_tencent_mm_protocal_c_bez = (bez) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bez.wKh = str;
        com_tencent_mm_protocal_c_bez.rYW = 25;
        com_tencent_mm_protocal_c_bez.lOo = w.eL(ac.getContext());
        com_tencent_mm_protocal_c_bez.wwI = g.Je();
    }

    public final int getType() {
        return this.gJQ.hmi;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchLocalPage", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
