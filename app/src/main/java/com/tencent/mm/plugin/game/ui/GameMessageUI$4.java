package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameMessageUI$4 implements OnScrollListener {
    final /* synthetic */ GameMessageUI ntK;

    GameMessageUI$4(GameMessageUI gameMessageUI) {
        this.ntK = gameMessageUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !GameMessageUI.b(this.ntK).awe()) {
            o b = GameMessageUI.b(this.ntK);
            if (!b.awe()) {
                b.kUH += 15;
                if (b.kUH > b.hKb) {
                    b.kUH = b.hKb;
                }
            } else if (b.xIi != null) {
                b.xIi.Xv();
            }
            GameMessageUI.b(this.ntK).a(null, null);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
