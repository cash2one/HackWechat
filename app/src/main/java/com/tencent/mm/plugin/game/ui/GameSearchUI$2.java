package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class GameSearchUI$2 implements OnTouchListener {
    final /* synthetic */ GameSearchUI nvN;

    GameSearchUI$2(GameSearchUI gameSearchUI) {
        this.nvN = gameSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        GameSearchUI.a(this.nvN).clearFocus();
        this.nvN.aWs();
        return false;
    }
}
