package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    public String hqf;

    public t(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new anf();
        aVar.hmk = new ang();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        this.gJQ = aVar.JZ();
        anf com_tencent_mm_protocal_c_anf = (anf) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_anf.wuq = str;
        com_tencent_mm_protocal_c_anf.wur = str2;
        this.hqf = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 674;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final ang Ma() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (ang) this.gJQ.hmh.hmo;
    }
}
