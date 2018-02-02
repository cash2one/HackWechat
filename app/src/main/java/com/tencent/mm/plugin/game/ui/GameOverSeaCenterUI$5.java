package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class GameOverSeaCenterUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ GameOverSeaCenterUI ntQ;

    GameOverSeaCenterUI$5(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.ntQ = gameOverSeaCenterUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ap.a(this.ntQ.mController.xIM, 10, 1008, AuthorizedGameListUI.nkO, c.ac(this.ntQ.mController.xIM, GameOverSeaCenterUI.d(this.ntQ)), this.ntQ.ndn, null);
        return true;
    }
}
