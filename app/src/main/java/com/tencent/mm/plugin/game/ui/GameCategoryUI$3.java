package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.n.a;

class GameCategoryUI$3 implements a {
    final /* synthetic */ GameCategoryUI nmk;

    GameCategoryUI$3(GameCategoryUI gameCategoryUI) {
        this.nmk = gameCategoryUI;
    }

    public final void qQ(int i) {
        int firstVisiblePosition = GameCategoryUI.b(this.nmk).getFirstVisiblePosition();
        int lastVisiblePosition = GameCategoryUI.b(this.nmk).getLastVisiblePosition();
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            GameCategoryUI.c(this.nmk).x(GameCategoryUI.b(this.nmk).getChildAt(i - firstVisiblePosition), i);
        }
    }
}
