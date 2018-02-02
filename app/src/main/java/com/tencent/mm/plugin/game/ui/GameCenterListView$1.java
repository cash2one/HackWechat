package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameCenterListView$1 implements OnScrollListener {
    final /* synthetic */ GameCenterListView nmL;

    GameCenterListView$1(GameCenterListView gameCenterListView) {
        this.nmL = gameCenterListView;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 0 && GameCenterListView.a(this.nmL) != null && GameCenterListView.a(this.nmL).getTop() == 0) {
            GameCenterListView.a(this.nmL, true);
        } else {
            GameCenterListView.a(this.nmL, false);
        }
    }
}
