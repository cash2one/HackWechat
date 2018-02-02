package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.ui.GameLibraryUI.9;

class GameLibraryUI$9$1 implements Runnable {
    final /* synthetic */ al nsx;
    final /* synthetic */ 9 nsz;

    GameLibraryUI$9$1(9 9, al alVar) {
        this.nsz = 9;
        this.nsx = alVar;
    }

    public final void run() {
        GameLibraryUI.a(this.nsz.nsw, this.nsx, GameLibraryUI.m(this.nsz.nsw) != 0);
        GameLibraryUI.p(this.nsz.nsw);
        GameLibraryUI.l(this.nsz.nsw).setVisibility(8);
        GameLibraryUI.b(this.nsz.nsw, GameLibraryUI.m(this.nsz.nsw) + 15);
        if (GameLibraryUI.q(this.nsz.nsw) != null) {
            GameLibraryUI.q(this.nsz.nsw).dismiss();
        }
    }
}
