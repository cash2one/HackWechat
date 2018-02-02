package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.ui.base.h.c;

class MusicMainUI$6 implements c {
    final /* synthetic */ asv hHS;
    final /* synthetic */ MusicMainUI oNP;

    MusicMainUI$6(MusicMainUI musicMainUI, asv com_tencent_mm_protocal_c_asv) {
        this.oNP = musicMainUI;
        this.hHS = com_tencent_mm_protocal_c_asv;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                g.A(this.oNP);
                f.tn(MusicMainUI.g(this.oNP));
                f.tq(2);
                return;
            case 1:
                g.c(this.hHS, this.oNP);
                f.to(MusicMainUI.g(this.oNP));
                f.tq(1);
                return;
            case 2:
                g.a(this.hHS, this.oNP);
                f.tq(3);
                return;
            case 3:
                g.b(this.hHS, this.oNP);
                f.tq(4);
                return;
            default:
                return;
        }
    }
}
