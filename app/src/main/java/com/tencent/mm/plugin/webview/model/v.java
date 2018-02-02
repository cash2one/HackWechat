package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bog;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;

    public v(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bog();
        aVar.hmk = new boh();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        aVar.hmi = 1142;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bog com_tencent_mm_protocal_c_bog = (bog) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bog.fFm = str;
        com_tencent_mm_protocal_c_bog.wQP = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1142;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
