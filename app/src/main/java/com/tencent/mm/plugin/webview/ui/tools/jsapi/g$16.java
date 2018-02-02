package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.tencent.mm.aq.c.c;
import com.tencent.mm.pluginsdk.model.app.f;

class g$16 implements c {
    final /* synthetic */ String fgO;
    final /* synthetic */ String hAS;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ ProgressDialog tIo;
    final /* synthetic */ f tIp;

    g$16(g gVar, ProgressDialog progressDialog, f fVar, String str, String str2, i iVar) {
        this.tIj = gVar;
        this.tIo = progressDialog;
        this.tIp = fVar;
        this.fgO = str;
        this.hAS = str2;
        this.tIg = iVar;
    }

    public final void n(Bitmap bitmap) {
        if (this.tIo != null) {
            this.tIo.dismiss();
        }
        g.a(this.tIj, this.tIp, "", this.fgO, this.hAS, null, null, null, null);
        g.a(this.tIj, this.tIg, "send_service_app_msg:ok", null);
        g.dP(this.tIj, this.tIg);
    }
}
