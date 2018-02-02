package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c$b;
import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends k implements com.tencent.mm.network.k, c$b {
    public final b gJQ;
    private e gOB;
    public String jIW;
    public c$a tsa;
    private final int tsc;

    public m(c$a com_tencent_mm_plugin_webview_ui_tools_jsapi_c_a, String str, String str2, LinkedList<String> linkedList, String str3, String str4, String str5, String str6, int i, String str7, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6});
        this.tsa = com_tencent_mm_plugin_webview_ui_tools_jsapi_c_a;
        this.jIW = str;
        this.tsc = i2;
        a aVar = new a();
        aVar.hmj = new ama();
        aVar.hmk = new amb();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        aVar.hmi = 1093;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ama com_tencent_mm_protocal_c_ama = (ama) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ama.url = str;
        com_tencent_mm_protocal_c_ama.fFm = str2;
        com_tencent_mm_protocal_c_ama.wsV = linkedList;
        com_tencent_mm_protocal_c_ama.fqD = str3;
        com_tencent_mm_protocal_c_ama.wsG = str4;
        com_tencent_mm_protocal_c_ama.signature = str5;
        com_tencent_mm_protocal_c_ama.wsH = str6;
        com_tencent_mm_protocal_c_ama.scene = i;
        com_tencent_mm_protocal_c_ama.wsW = str7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1093;
    }

    public final amb bQF() {
        if (this.gJQ == null) {
            return null;
        }
        return (amb) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int bQE() {
        return this.tsc;
    }
}
