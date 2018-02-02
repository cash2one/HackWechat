package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

class GameCenterActivity$2 implements OnApplyWindowInsetsListener {
    final /* synthetic */ GameCenterActivity nmt;
    final /* synthetic */ ViewGroup nmu;

    GameCenterActivity$2(GameCenterActivity gameCenterActivity, ViewGroup viewGroup) {
        this.nmt = gameCenterActivity;
        this.nmu = viewGroup;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.nmt.a(this.nmu, windowInsets);
        return windowInsets.consumeSystemWindowInsets();
    }
}
