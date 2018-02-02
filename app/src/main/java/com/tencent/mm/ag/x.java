package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.protocal.c.hr;

public final class x extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;

    public x(hr hrVar, Object obj) {
        a aVar = new a();
        aVar.hmj = new bgx();
        aVar.hmk = new bgy();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        this.gJQ = aVar.JZ();
        bgx com_tencent_mm_protocal_c_bgx = (bgx) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bgx.wjh = hrVar;
        com_tencent_mm_protocal_c_bgx.mask = 1;
        com_tencent_mm_protocal_c_bgx.wjf = 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1228;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
