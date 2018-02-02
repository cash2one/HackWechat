package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.av.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.h;

class MusicMainUI$a implements Runnable {
    final /* synthetic */ MusicMainUI oNP;
    int position;

    public MusicMainUI$a(MusicMainUI musicMainUI, int i) {
        this.oNP = musicMainUI;
        this.position = i;
    }

    public final void run() {
        e bdz = h.bdz();
        int i = this.position;
        if (bdz.oJB.size() != 0) {
            i = (i - 100000) % bdz.oJB.size();
            if (i < 0) {
                i += bdz.oJB.size();
            }
            if (i != bdz.oJA) {
                bdz.oJA = i;
                bdz.e(null);
            }
        }
        a bdo = h.bdz().bdo();
        if (bdo != null) {
            if (bdo.Ql()) {
                this.oNP.q(bdo);
            }
            if (h.bdz().bdt()) {
                MusicMainUI.i(this.oNP).DN = true;
            }
            MusicMainUI.a(this.oNP, bdo);
        }
    }
}
