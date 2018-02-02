package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.c.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.91;
import com.tencent.mm.ui.base.h;

class g$91$1 implements c {
    final /* synthetic */ String tIx;
    final /* synthetic */ 91 tJn;

    g$91$1(91 91, String str) {
        this.tJn = 91;
        this.tIx = str;
    }

    public final void n(Bitmap bitmap) {
        if (g.D(this.tJn.tIj) != null) {
            g.D(this.tJn.tIj).dismiss();
        }
        com.tencent.mm.ag.a.c ag = y.Mh().ag(this.tJn.tIw);
        synchronized (e.hqR) {
            String HD = e.HD();
            e.d(ag);
            g.a(this.tJn.tIj, this.tJn.tIp, this.tJn.fgU, this.tJn.fgO, this.tJn.hAS, null, null, this.tIx, null);
            e.ks(HD);
        }
        g.a(this.tJn.tIj, this.tJn.tIg, "sendEnterpriseChat:ok", null);
        if (g.i(this.tJn.tIj) != null) {
            h.bu(g.i(this.tJn.tIj), g.i(this.tJn.tIj).getResources().getString(R.l.dGG));
        }
    }
}
