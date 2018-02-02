package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.8;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;

class CleanNewUI$6 implements c {
    final /* synthetic */ CleanNewUI lhD;

    CleanNewUI$6(CleanNewUI cleanNewUI) {
        this.lhD = cleanNewUI;
    }

    public final void cj(int i, int i2) {
        if (!CleanNewUI.f(this.lhD)) {
            this.lhD.cm(i, i2);
        }
    }

    public final void a(long j, long j2, long j3, HashSet<String> hashSet, HashMap<String, Long> hashMap) {
        CleanNewUI.a(this.lhD, bh.Wp());
        CleanNewUI cleanNewUI = this.lhD;
        j.ayv().leW = j;
        j.ayv().leX = j2;
        j.ayv().leY = j3;
        j.ayv().lfJ = hashMap;
        j.ayv().lfx = hashSet;
        ag.y(new 8(cleanNewUI, j));
        g.pQN.a(714, 53, 1, false);
        long g = CleanNewUI.g(this.lhD) - CleanNewUI.h(this.lhD);
        long i = CleanNewUI.i(this.lhD) - CleanNewUI.j(this.lhD);
        x.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[]{Long.valueOf(CleanNewUI.g(this.lhD)), Long.valueOf(CleanNewUI.h(this.lhD)), Long.valueOf(g), Long.valueOf(CleanNewUI.i(this.lhD)), Long.valueOf(CleanNewUI.j(this.lhD)), Long.valueOf(i), Long.valueOf(g + i)});
        g.pQN.h(14556, new Object[]{Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.h(this.lhD)), Long.valueOf(CleanNewUI.g(this.lhD)), Long.valueOf(g)});
        g.pQN.h(14556, new Object[]{Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.j(this.lhD)), Long.valueOf(CleanNewUI.i(this.lhD)), Long.valueOf(i)});
        g.pQN.h(14556, new Object[]{Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(g + i)});
    }
}
