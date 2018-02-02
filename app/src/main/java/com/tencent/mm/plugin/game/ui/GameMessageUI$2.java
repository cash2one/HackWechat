package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class GameMessageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameMessageUI ntK;

    GameMessageUI$2(GameMessageUI gameMessageUI) {
        this.ntK = gameMessageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameMessageUI.a(this.ntK, new 1(this));
        GameMessageUI.b(this.ntK, new 2(this));
        h.a(this.ntK.mController.xIM, R.l.elS, 0, GameMessageUI.c(this.ntK), GameMessageUI.d(this.ntK));
        return false;
    }
}
