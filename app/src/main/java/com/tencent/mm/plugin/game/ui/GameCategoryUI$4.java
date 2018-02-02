package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameCategoryUI$4 implements OnScrollListener {
    final /* synthetic */ GameCategoryUI nmk;

    GameCategoryUI$4(GameCategoryUI gameCategoryUI) {
        this.nmk = gameCategoryUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameCategoryUI.d(this.nmk) && !GameCategoryUI.e(this.nmk)) {
            GameCategoryUI.f(this.nmk).setVisibility(0);
            GameCategoryUI.g(this.nmk);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
