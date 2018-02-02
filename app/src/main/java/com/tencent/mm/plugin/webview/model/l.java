package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$b;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k, c$b {
    private final b gJQ;
    private e gOB;
    public c$a tsa;
    public String tsb;
    private final int tsc;
    public String url;

    public l(c$a com_tencent_mm_plugin_webview_ui_tools_jsapi_c_a, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i, String str8, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8});
        this.tsa = com_tencent_mm_plugin_webview_ui_tools_jsapi_c_a;
        this.tsb = str3;
        this.url = str;
        this.tsc = i2;
        a aVar = new a();
        aVar.hmj = new als();
        aVar.hmk = new alt();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        aVar.hmi = 1095;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        als com_tencent_mm_protocal_c_als = (als) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_als.url = str;
        com_tencent_mm_protocal_c_als.nfn = str2;
        com_tencent_mm_protocal_c_als.wsE = str3;
        com_tencent_mm_protocal_c_als.fqD = str4;
        com_tencent_mm_protocal_c_als.wsG = str5;
        com_tencent_mm_protocal_c_als.signature = str6;
        com_tencent_mm_protocal_c_als.wsH = str7;
        com_tencent_mm_protocal_c_als.wsI = com.tencent.mm.bq.b.bc(bArr);
        com_tencent_mm_protocal_c_als.wsJ = i;
        com_tencent_mm_protocal_c_als.scope = str8;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1095;
    }

    public final als bQC() {
        if (this.gJQ == null) {
            return null;
        }
        return (als) this.gJQ.hmg.hmo;
    }

    public final alt bQD() {
        if (this.gJQ == null) {
            return null;
        }
        return (alt) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int bQE() {
        return this.tsc;
    }
}
