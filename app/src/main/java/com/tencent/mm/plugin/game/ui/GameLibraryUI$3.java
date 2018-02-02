package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.n.a;

class GameLibraryUI$3 implements a {
    final /* synthetic */ GameLibraryUI nsw;

    GameLibraryUI$3(GameLibraryUI gameLibraryUI) {
        this.nsw = gameLibraryUI;
    }

    public final void qQ(int i) {
        int firstVisiblePosition = GameLibraryUI.b(this.nsw).getFirstVisiblePosition() - GameLibraryUI.c(this.nsw);
        int lastVisiblePosition = GameLibraryUI.b(this.nsw).getLastVisiblePosition() - GameLibraryUI.c(this.nsw);
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            GameLibraryUI.d(this.nsw).x(GameLibraryUI.b(this.nsw).getChildAt(i - firstVisiblePosition), i);
        }
    }
}
