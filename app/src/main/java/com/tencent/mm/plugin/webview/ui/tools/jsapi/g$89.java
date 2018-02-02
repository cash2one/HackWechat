package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

class g$89 implements e {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ g tJk;

    g$89(g gVar, i iVar, g gVar2) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.tJk = gVar2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        zo bQB;
        int i3 = -1;
        if (g.k(this.tIj) != null && g.k(this.tIj).isShowing()) {
            g.k(this.tIj).dismiss();
            g.a(this.tIj, null);
        }
        ar.CG().b(1393, this);
        String str2 = "selectEnterpriseContact:fail";
        if (i == 0 && i2 == 0) {
            bQB = ((i) kVar).bQB();
            if (!(bQB == null || bQB.vNw == null)) {
                i3 = bQB.vNw.ret;
                if (bQB.vNw.ftt != null && bQB.vNw.ftt.length() > 0) {
                    str2 = bQB.vNw.ftt;
                }
            }
        } else {
            bQB = null;
        }
        if (i3 != 0) {
            g.a(this.tIj, this.tIg, str2, null);
            return;
        }
        str2 = bQB.vUP;
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("useJs", true);
        ((MMActivity) g.i(this.tIj)).jwN = this.tJk;
        d.b(g.i(this.tIj), "webview", ".ui.tools.WebViewUI", intent, 53);
    }
}
