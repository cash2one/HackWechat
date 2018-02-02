package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public c(int i, String str) {
        a aVar = new a();
        aVar.hmj = new aui();
        aVar.hmk = new auj();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        this.gJQ = aVar.JZ();
        aui com_tencent_mm_protocal_c_aui = (aui) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aui.nhx = i;
        com_tencent_mm_protocal_c_aui.wCn = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1740;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
