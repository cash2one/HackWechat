package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class GameDownloadGuidanceUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ GameDownloadGuidanceUI npI;

    GameDownloadGuidanceUI$4(GameDownloadGuidanceUI gameDownloadGuidanceUI) {
        this.npI = gameDownloadGuidanceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ap.a(this.npI.mController.xIM, 10, 1008, AuthorizedGameListUI.nkO, c.ac(this.npI.mController.xIM, GameDownloadGuidanceUI.c(this.npI)), this.npI.ndn, null);
        return true;
    }
}
