package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;

class GameMenuView$2 implements OnClickListener {
    final /* synthetic */ GameMenuView tGt;

    GameMenuView$2(GameMenuView gameMenuView) {
        this.tGt = gameMenuView;
    }

    public final void onClick(View view) {
        if (GameMenuView.b(this.tGt) != null) {
            GameMenuView.b(this.tGt).g((o) view.getTag());
        }
        if (GameMenuView.c(this.tGt) != null) {
            GameMenuView.c(this.tGt).onDismiss();
        }
    }
}
