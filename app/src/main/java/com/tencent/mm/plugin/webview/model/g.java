package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b lMW;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new yd();
        aVar.hmk = new ye();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        aVar.hmi = 1097;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        yd ydVar = (yd) this.lMW.hmg.hmo;
        ydVar.fFm = str;
        ydVar.signature = str2;
    }

    public final int getType() {
        return 1097;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
