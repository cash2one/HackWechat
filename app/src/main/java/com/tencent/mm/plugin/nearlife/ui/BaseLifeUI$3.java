package com.tencent.mm.plugin.nearlife.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BaseLifeUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BaseLifeUI oQu;

    BaseLifeUI$3(BaseLifeUI baseLifeUI) {
        this.oQu = baseLifeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oQu.a(-1, false, "");
        this.oQu.finish();
        return true;
    }
}
