package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.g.a.ji;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class CleanNewUI$9 extends c<ji> {
    final /* synthetic */ CleanNewUI lhD;

    CleanNewUI$9(CleanNewUI cleanNewUI) {
        this.lhD = cleanNewUI;
        this.xen = ji.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ji jiVar = (ji) bVar;
        if (!(jiVar == null || jiVar.fzK == null)) {
            x.i("MicroMsg.CleanNewUI", "%s manual scan [%d %d %b]", CleanNewUI.a(this.lhD), Long.valueOf(jiVar.fzK.fzL), Long.valueOf(jiVar.fzK.fzM), Boolean.valueOf(jiVar.fzK.fdb));
            if (jiVar.fzK.fdb) {
                CleanNewUI.b(this.lhD, bh.Wp());
                CleanNewUI.l(this.lhD);
                g.pQN.a(714, 51, 1, false);
            } else {
                int i = (int) (((((float) jiVar.fzK.fzL) * 1.0f) / ((float) jiVar.fzK.fzM)) * 100.0f);
                CleanNewUI cleanNewUI = this.lhD;
                if (i <= 0) {
                    i = 0;
                }
                cleanNewUI.cm(i, 100);
            }
        }
        return false;
    }
}
