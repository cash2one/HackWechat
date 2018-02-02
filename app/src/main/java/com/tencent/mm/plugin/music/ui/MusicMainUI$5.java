package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.ui.base.h.c;

class MusicMainUI$5 implements c {
    final /* synthetic */ String fgU;
    final /* synthetic */ int iCP;
    final /* synthetic */ MusicMainUI oNP;
    final /* synthetic */ String oNS;

    MusicMainUI$5(MusicMainUI musicMainUI, String str, String str2, int i) {
        this.oNP = musicMainUI;
        this.fgU = str;
        this.oNS = str2;
        this.iCP = i;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                g.C(this.fgU, this.oNS, this.iCP);
                return;
            default:
                return;
        }
    }
}
