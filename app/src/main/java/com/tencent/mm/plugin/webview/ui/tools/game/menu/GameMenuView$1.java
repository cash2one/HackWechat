package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.database.DataSetObserver;

class GameMenuView$1 extends DataSetObserver {
    final /* synthetic */ GameMenuView tGt;

    GameMenuView$1(GameMenuView gameMenuView) {
        this.tGt = gameMenuView;
    }

    public final void onInvalidated() {
        GameMenuView.a(this.tGt);
    }

    public final void onChanged() {
        GameMenuView.a(this.tGt);
    }
}
