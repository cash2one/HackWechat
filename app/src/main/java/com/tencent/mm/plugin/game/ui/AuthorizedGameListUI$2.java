package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AuthorizedGameListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AuthorizedGameListUI nkT;

    AuthorizedGameListUI$2(AuthorizedGameListUI authorizedGameListUI) {
        this.nkT = authorizedGameListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nkT.finish();
        return true;
    }
}
