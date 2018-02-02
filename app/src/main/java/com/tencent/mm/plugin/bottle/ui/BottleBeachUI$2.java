package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleBeachUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BottleBeachUI kBA;

    BottleBeachUI$2(BottleBeachUI bottleBeachUI) {
        this.kBA = bottleBeachUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.kBA, BottlePersonalInfoUI.class);
        intent.putExtra("is_allow_set", false);
        this.kBA.startActivity(intent);
        return false;
    }
}
