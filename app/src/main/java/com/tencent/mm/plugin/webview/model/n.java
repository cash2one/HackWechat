package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$b;
import com.tencent.mm.protocal.c.amc;
import com.tencent.mm.protocal.c.amd;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k, c$b {
    private final b gJQ;
    private e gOB;
    public c$a tsa;
    private final int tsc;

    public n(c$a com_tencent_mm_plugin_webview_ui_tools_jsapi_c_a, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i) {
        x.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7});
        this.tsa = com_tencent_mm_plugin_webview_ui_tools_jsapi_c_a;
        this.tsc = i;
        a aVar = new a();
        aVar.hmj = new amc();
        aVar.hmk = new amd();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        aVar.hmi = 1094;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        amc com_tencent_mm_protocal_c_amc = (amc) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_amc.url = str;
        com_tencent_mm_protocal_c_amc.fFm = str2;
        com_tencent_mm_protocal_c_amc.wsE = str3;
        com_tencent_mm_protocal_c_amc.fqD = str4;
        com_tencent_mm_protocal_c_amc.wsG = str5;
        com_tencent_mm_protocal_c_amc.signature = str6;
        com_tencent_mm_protocal_c_amc.wsH = str7;
        com_tencent_mm_protocal_c_amc.wsI = com.tencent.mm.bq.b.bc(bArr);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1094;
    }

    public final amd bQG() {
        if (this.gJQ == null) {
            return null;
        }
        return (amd) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int bQE() {
        return this.tsc;
    }
}
