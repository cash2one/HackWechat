package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.sdk.platformtools.x;

public final class af extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public af(int i, String str) {
        a aVar = new a();
        aVar.hmj = new aph();
        aVar.hmk = new api();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        aVar.hmi = 1060;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aph com_tencent_mm_protocal_c_aph = (aph) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aph.offset = i;
        com_tencent_mm_protocal_c_aph.asN = 20;
        com_tencent_mm_protocal_c_aph.lang = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1060;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
