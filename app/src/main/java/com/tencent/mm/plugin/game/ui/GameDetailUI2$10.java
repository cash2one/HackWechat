package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class GameDetailUI2$10 implements OnGlobalLayoutListener {
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$10(GameDetailUI2 gameDetailUI2) {
        this.npz = gameDetailUI2;
    }

    public final void onGlobalLayout() {
        if (GameDetailUI2.b(this.npz).getLineCount() > 3) {
            GameDetailUI2.c(this.npz).setVisibility(0);
        } else {
            GameDetailUI2.c(this.npz).setVisibility(8);
        }
    }
}
