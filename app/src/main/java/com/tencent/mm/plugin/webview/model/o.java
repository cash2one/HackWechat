package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class o extends k implements com.tencent.mm.network.k, b {
    public final com.tencent.mm.ae.b gJQ;
    private e gOB;
    private final int tsc;
    public alr tsd;

    public o(alr com_tencent_mm_protocal_c_alr, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tencent.mm.bq.b bVar, int i, LinkedList<ams> linkedList, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i)});
        this.tsd = com_tencent_mm_protocal_c_alr;
        this.tsc = i2;
        a aVar = new a();
        aVar.hmj = new ame();
        aVar.hmk = new amf();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        aVar.hmi = 1096;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ame com_tencent_mm_protocal_c_ame = (ame) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ame.url = str;
        com_tencent_mm_protocal_c_ame.fFm = str2;
        com_tencent_mm_protocal_c_ame.wsE = str3;
        com_tencent_mm_protocal_c_ame.fqD = str4;
        com_tencent_mm_protocal_c_ame.wsG = str5;
        com_tencent_mm_protocal_c_ame.signature = str6;
        com_tencent_mm_protocal_c_ame.wsH = str7;
        com_tencent_mm_protocal_c_ame.wsJ = i;
        com_tencent_mm_protocal_c_ame.wsI = bVar;
        com_tencent_mm_protocal_c_ame.wsN = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1096;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int bQE() {
        return this.tsc;
    }
}
