package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bnp;

class b$1 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$1(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getTag() != null) {
            m cK = b.cK(view);
            if (cK != null && cK.xl(32)) {
                boolean z2;
                if (cK.byB().bxR().bwA()) {
                    int i;
                    int en = u.en(cK.byB().bxR().bww(), cK.byA());
                    Object obj = en > 0 ? 1 : null;
                    String bww = cK.byB().bxR().bww();
                    String byA = cK.byA();
                    g.Dh();
                    String Ch = a.Ch();
                    if (obj != null) {
                        i = en;
                    } else {
                        i = 1;
                    }
                    u.f(bww, byA, Ch, i, obj != null ? 0 : 1);
                    if (obj == null) {
                        z = true;
                    }
                    z2 = z;
                } else {
                    z2 = false;
                }
                bnp bxV = cK.bxV();
                if (bxV.wQo.vYc == 15 && bxV.wQv != 1) {
                    b.a(this.rPY, view, cK, 1001, cK.byB().bxR().bwB(), z2);
                } else if ((bxV.wQo.vYc == 1 && bxV.wQo.vYd.size() == 1) || bxV.wQo.vYc == 7) {
                    b.b(this.rPY, view, cK, 1001, cK.byB().bxR().bwB(), z2);
                }
            }
        }
    }
}
