package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class MusicMainUI$b extends a {
    final /* synthetic */ MusicMainUI oNP;

    private MusicMainUI$b(MusicMainUI musicMainUI) {
        this.oNP = musicMainUI;
    }

    public final void beP() {
        x.i("MicroMsg.Music.MusicMainUI", "shake %b", Boolean.valueOf(true));
        long bA = bh.bA(MusicMainUI.d(this.oNP));
        if (bA < 1200) {
            x.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:" + bA);
            return;
        }
        x.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:" + bA);
        MusicMainUI.a(this.oNP, bh.Wq());
        MusicMainUI.e(this.oNP);
        if (MusicMainUI.f(this.oNP) % 2 == 0) {
            e bdz = h.bdz();
            int g = MusicMainUI.g(this.oNP);
            g.pQN.a(285, 2, 1, false);
            b jsVar;
            if (bdz.mode != 1) {
                bdz.mode = 1;
                jsVar = new js();
                jsVar.fAz.action = 5;
                com.tencent.mm.sdk.b.a.xef.m(jsVar);
                f.S(2, 1, g);
            } else if (bdz.oJJ) {
                x.i("MicroMsg.Music.MusicPlayerManager", "already running get list");
            } else {
                bdz.mode = 2;
                if (bdz.oJB.size() <= 1) {
                    bdz.bdq();
                } else {
                    jsVar = new js();
                    jsVar.fAz.action = 5;
                    com.tencent.mm.sdk.b.a.xef.m(jsVar);
                }
                f.S(1, 2, g);
            }
        }
    }

    public final void onRelease() {
    }
}
