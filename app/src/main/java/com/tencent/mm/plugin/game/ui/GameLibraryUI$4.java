package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.sdk.platformtools.ag;

class GameLibraryUI$4 implements Runnable {
    final /* synthetic */ byte[] npB;
    final /* synthetic */ GameLibraryUI nsw;

    GameLibraryUI$4(GameLibraryUI gameLibraryUI, byte[] bArr) {
        this.nsw = gameLibraryUI;
        this.npB = bArr;
    }

    public final void run() {
        final al alVar = new al(this.npB);
        ag.y(new Runnable(this) {
            final /* synthetic */ GameLibraryUI$4 nsy;

            public final void run() {
                GameLibraryUI.a(this.nsy.nsw, alVar, false);
            }
        });
    }
}
