package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;
    public String hrt;

    public m(String str, String str2, String str3, Object obj) {
        a aVar = new a();
        aVar.hmj = new pe();
        aVar.hmk = new pf();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        this.gJQ = aVar.JZ();
        pe peVar = (pe) this.gJQ.hmg.hmo;
        peVar.vYi = str;
        peVar.vYk = str2;
        peVar.vYj = str3;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1315;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final pf My() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (pf) this.gJQ.hmh.hmo;
    }
}
