package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class GameDropdownView$1 implements OnClickListener {
    final /* synthetic */ GameDropdownView npZ;

    GameDropdownView$1(GameDropdownView gameDropdownView) {
        this.npZ = gameDropdownView;
    }

    public final void onClick(View view) {
        if (GameDropdownView.a(this.npZ).getContentView() == null || !(GameDropdownView.a(this.npZ).getContentView() instanceof ViewGroup)) {
            GameDropdownView.a(this.npZ).dismiss();
            return;
        }
        GameDropdownView.a(this.npZ, ((ViewGroup) GameDropdownView.a(this.npZ).getContentView()).indexOfChild(view));
        GameDropdownView.a(this.npZ).dismiss();
    }
}
