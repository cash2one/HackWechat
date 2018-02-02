package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class j$a$2 implements d {
    final /* synthetic */ a rrS;

    j$a$2(a aVar) {
        this.rrS = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 4;
        switch (menuItem.getItemId()) {
            case 0:
                this.rrS.rrK.mxl.setText(a.a(this.rrS));
                h.bu(j.c(this.rrS.rrK), j.c(this.rrS.rrK).getString(j.dEt));
                if (a.b(this.rrS) != null) {
                    String fL = bh.fL(u.LF(a.c(this.rrS).fzW));
                    int i3 = com.tencent.mm.plugin.secinforeport.a.a.qff;
                    com.tencent.mm.plugin.secinforeport.a.a.d(4, fL + ":" + a.b(this.rrS).wMw, bh.Vy(a.a(this.rrS).toString()));
                    return;
                }
                return;
            case 1:
                x.e("MicroMsg.BaseTimeLine", "del snsId:" + a.c(this.rrS).fzW + " commentId:" + a.b(this.rrS));
                long LF = u.LF(a.c(this.rrS).fzW);
                if (u.LE(a.c(this.rrS).fzW)) {
                    i2 = 6;
                }
                k qVar = new q(LF, i2, a.b(this.rrS));
                g.Dk();
                g.Di().gPJ.a(qVar, 0);
                j jVar = this.rrS.rrK;
                Context c = j.c(this.rrS.rrK);
                j.c(this.rrS.rrK).getString(j.dGO);
                jVar.rrH = h.a(c, j.c(this.rrS.rrK).getString(j.qKt), true, new 1(this, qVar));
                return;
            default:
                return;
        }
    }
}
