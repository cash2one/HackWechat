package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.d;
import com.tencent.mm.u.a.d$a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

class g$116 implements d$a<d> {
    final /* synthetic */ int iTc;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ g$a tIk;

    g$116(g gVar, i iVar, g$a com_tencent_mm_plugin_webview_ui_tools_jsapi_g_a, int i) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.tIk = com_tencent_mm_plugin_webview_ui_tools_jsapi_g_a;
        this.iTc = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        d dVar = (d) kVar;
        x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            g.a(this.tIj, this.tIg, "login:fail", null);
            this.tIk.afC();
        } else if (!(dVar instanceof d)) {
        } else {
            if (this.iTc == 2) {
                x.d("MicroMsg.MsgHandler", "press reject button");
                this.tIk.afC();
                return;
            }
            aml BY = dVar.BY();
            int i3 = BY.wte.fts;
            String str2 = BY.wte.ftt;
            x.i("MicroMsg.MsgHandler", "stev NetSceneJSLoginConfirm jsErrcode %d", Integer.valueOf(i3));
            if (i3 == 0) {
                String str3 = BY.wth;
                Map hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str3);
                g.a(this.tIj, this.tIg, "login:ok", hashMap);
                this.tIk.afC();
                x.d("MicroMsg.MsgHandler", "resp data code [%s]", str3);
                return;
            }
            g.a(this.tIj, this.tIg, "login:fail", null);
            this.tIk.afC();
            x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLoginConfirm %s", str2);
        }
    }
}
