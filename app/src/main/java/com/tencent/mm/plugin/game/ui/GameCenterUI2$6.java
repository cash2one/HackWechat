package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.n.a;

class GameCenterUI2$6 implements a {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$6(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final void qQ(int i) {
        int headerViewsCount = GameCenterUI2.g(this.nnh).getHeaderViewsCount();
        int firstVisiblePosition = GameCenterUI2.g(this.nnh).getFirstVisiblePosition() - headerViewsCount;
        headerViewsCount = GameCenterUI2.g(this.nnh).getLastVisiblePosition() - headerViewsCount;
        if (i >= firstVisiblePosition && i <= headerViewsCount) {
            GameCenterUI2.h(this.nnh).x(GameCenterUI2.g(this.nnh).getChildAt(i - firstVisiblePosition), i);
        }
    }
}
