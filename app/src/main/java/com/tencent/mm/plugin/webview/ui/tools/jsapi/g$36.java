package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

class g$36 implements OnClickListener {
    final /* synthetic */ String fgU;
    final /* synthetic */ i tIg;
    final /* synthetic */ JsapiPermissionWrapper tIh;
    final /* synthetic */ g tIj;
    final /* synthetic */ String txs;
    final /* synthetic */ String val$url;

    g$36(g gVar, String str, String str2, String str3, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.tIj = gVar;
        this.fgU = str;
        this.txs = str2;
        this.val$url = str3;
        this.tIg = iVar;
        this.tIh = jsapiPermissionWrapper;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14217, new Object[]{this.fgU, Integer.valueOf(5), this.txs, this.val$url, Integer.valueOf(3)});
        g.dL(this.tIj, this.tIg);
        dialogInterface.dismiss();
    }
}
