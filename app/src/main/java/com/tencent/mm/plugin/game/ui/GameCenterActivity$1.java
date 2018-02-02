package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class GameCenterActivity$1 implements OnLayoutChangeListener {
    final /* synthetic */ GameCenterActivity nmt;

    GameCenterActivity$1(GameCenterActivity gameCenterActivity) {
        this.nmt = gameCenterActivity;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.nmt.aRv();
    }
}
