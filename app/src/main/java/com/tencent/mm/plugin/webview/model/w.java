package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.app;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    String appId;
    String fus;
    final b gJQ;
    private e gOB;

    public w(String str, String str2, apk com_tencent_mm_protocal_c_apk) {
        this.appId = str;
        this.fus = str2;
        a aVar = new a();
        aVar.hmj = new app();
        aVar.hmk = new apq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        aVar.hmi = 1034;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        app com_tencent_mm_protocal_c_app = (app) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_app.fFm = str;
        com_tencent_mm_protocal_c_app.www = com_tencent_mm_protocal_c_apk;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1034;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
