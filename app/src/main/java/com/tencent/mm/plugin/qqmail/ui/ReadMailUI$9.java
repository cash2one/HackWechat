package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ReadMailUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$9(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.puG.finish();
        return true;
    }
}
