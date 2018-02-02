package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.sdk.platformtools.ag;

class GameDetailUI2$12 implements Runnable {
    final /* synthetic */ byte[] npB;
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$12(GameDetailUI2 gameDetailUI2, byte[] bArr) {
        this.npz = gameDetailUI2;
        this.npB = bArr;
    }

    public final void run() {
        final af afVar = new af(this.npB);
        ag.y(new Runnable(this) {
            final /* synthetic */ GameDetailUI2$12 npD;

            public final void run() {
                GameDetailUI2.a(this.npD.npz, afVar);
            }
        });
    }
}
