package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class GameCenterUI2$10 implements OnMenuItemClickListener {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$10(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ap.a(this.nnh, 10, 1008, AuthorizedGameListUI.nkO, c.ac(this.nnh.mController.xIM, GameCenterUI2.o(this.nnh)), GameCenterUI2.f(this.nnh), null);
        return true;
    }
}
