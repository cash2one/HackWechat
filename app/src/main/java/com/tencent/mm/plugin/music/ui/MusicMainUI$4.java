package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.ui.base.h.c;

class MusicMainUI$4 implements c {
    final /* synthetic */ String fgU;
    final /* synthetic */ asv hHS;
    final /* synthetic */ int iCP;
    final /* synthetic */ MusicMainUI oNP;
    final /* synthetic */ String oNS;

    MusicMainUI$4(MusicMainUI musicMainUI, asv com_tencent_mm_protocal_c_asv, String str, String str2, int i) {
        this.oNP = musicMainUI;
        this.hHS = com_tencent_mm_protocal_c_asv;
        this.fgU = str;
        this.oNS = str2;
        this.iCP = i;
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
                g.C(this.fgU, this.oNS, this.iCP);
                return;
            default:
                return;
        }
    }
}
