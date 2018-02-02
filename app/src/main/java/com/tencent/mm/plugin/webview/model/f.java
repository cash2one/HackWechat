package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    String appId;
    final b gJQ;
    private e gOB;
    String iLv;

    public f(String str, String str2) {
        this.appId = str;
        this.iLv = str2;
        a aVar = new a();
        aVar.hmj = new apl();
        aVar.hmk = new apm();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        aVar.hmi = 1035;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        apl com_tencent_mm_protocal_c_apl = (apl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_apl.fFm = str;
        com_tencent_mm_protocal_c_apl.wwv = str2;
        x.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[]{str, str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1035;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
