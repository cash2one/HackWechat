package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleBeachUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BottleBeachUI kBA;

    BottleBeachUI$3(BottleBeachUI bottleBeachUI) {
        this.kBA = bottleBeachUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kBA.aWs();
        this.kBA.finish();
        return false;
    }
}
