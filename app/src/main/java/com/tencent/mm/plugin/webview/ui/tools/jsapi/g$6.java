package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.aq.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;
import java.util.Map;

class g$6 implements c {
    final /* synthetic */ String fgO;
    final /* synthetic */ String fgU;
    final /* synthetic */ String hAS;
    final /* synthetic */ g tIj;
    final /* synthetic */ ProgressDialog tIo;
    final /* synthetic */ f tIp;
    final /* synthetic */ String tIq;
    final /* synthetic */ String tIr;
    final /* synthetic */ String tIs;
    final /* synthetic */ Map tIt;

    g$6(g gVar, ProgressDialog progressDialog, f fVar, String str, String str2, String str3, String str4, String str5, String str6, Map map) {
        this.tIj = gVar;
        this.tIo = progressDialog;
        this.tIp = fVar;
        this.fgU = str;
        this.fgO = str2;
        this.hAS = str3;
        this.tIq = str4;
        this.tIr = str5;
        this.tIs = str6;
        this.tIt = map;
    }

    public final void n(Bitmap bitmap) {
        if (this.tIo != null) {
            this.tIo.dismiss();
        }
        g.a(this.tIj, this.tIp, this.fgU, this.fgO, this.hAS, this.tIq, this.tIr, null, this.tIs);
        if (g.i(this.tIj) != null) {
            h.bu(g.i(this.tIj), g.i(this.tIj).getString(R.l.dGy));
        }
        g.a(this.tIj, g.j(this.tIj), "send_app_msg:ok", this.tIt);
    }
}
