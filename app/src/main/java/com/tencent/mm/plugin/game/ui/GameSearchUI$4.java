package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class GameSearchUI$4 implements OnTouchListener {
    final /* synthetic */ GameSearchUI nvN;

    GameSearchUI$4(GameSearchUI gameSearchUI) {
        this.nvN = gameSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        GameSearchUI.e(this.nvN).clearFocus();
        this.nvN.aWs();
        return false;
    }
}
