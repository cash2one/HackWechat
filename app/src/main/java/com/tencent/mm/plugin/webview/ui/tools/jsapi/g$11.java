package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.c.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.h;

class g$11 implements c {
    final /* synthetic */ String fgO;
    final /* synthetic */ String fgU;
    final /* synthetic */ String hAS;
    final /* synthetic */ g tIj;
    final /* synthetic */ f tIp;
    final /* synthetic */ String tIq;
    final /* synthetic */ String tIr;
    final /* synthetic */ String tIs;
    final /* synthetic */ long tIw;
    final /* synthetic */ String tIx;

    g$11(g gVar, long j, f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.tIj = gVar;
        this.tIw = j;
        this.tIp = fVar;
        this.fgU = str;
        this.fgO = str2;
        this.hAS = str3;
        this.tIq = str4;
        this.tIr = str5;
        this.tIx = str6;
        this.tIs = str7;
    }

    public final void n(Bitmap bitmap) {
        if (g.D(this.tIj) != null) {
            g.D(this.tIj).dismiss();
        }
        if (this.tIw >= 0) {
            com.tencent.mm.ag.a.c ag = y.Mh().ag(this.tIw);
            synchronized (e.hqR) {
                String HD = e.HD();
                e.d(ag);
                g.a(this.tIj, this.tIp, this.fgU, this.fgO, this.hAS, this.tIq, this.tIr, this.tIx, this.tIs);
                e.ks(HD);
            }
        } else {
            g.a(this.tIj, this.tIp, this.fgU, this.fgO, this.hAS, this.tIq, this.tIr, this.tIx, this.tIs);
        }
        if (g.i(this.tIj) != null) {
            h.bu(g.i(this.tIj), g.i(this.tIj).getString(R.l.dUd));
        }
        g.a(this.tIj, g.j(this.tIj), "send_app_msg:ok", null);
    }
}
