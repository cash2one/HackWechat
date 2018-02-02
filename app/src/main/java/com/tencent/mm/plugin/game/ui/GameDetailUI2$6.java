package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.n.b;

class GameDetailUI2$6 implements b {
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$6(GameDetailUI2 gameDetailUI2) {
        this.npz = gameDetailUI2;
    }

    public final void h(int i, String str, boolean z) {
        if (GameDetailUI2.l(this.npz) != null) {
            GameDetailUI2.i(this.npz).cP(this.npz);
            GameDetailUI2.i(this.npz).aQj();
            if (z) {
                GameDetailUI2.m(this.npz).a(GameDetailUI2.j(this.npz), GameDetailUI2.k(this.npz), GameDetailUI2.l(this.npz), GameDetailUI2.i(this.npz));
            }
        }
    }
}
