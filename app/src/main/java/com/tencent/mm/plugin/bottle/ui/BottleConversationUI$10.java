package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleConversationUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ BottleConversationUI kBS;

    BottleConversationUI$10(BottleConversationUI bottleConversationUI) {
        this.kBS = bottleConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.kBS, BottleBeachUI.class);
        this.kBS.startActivity(intent);
        this.kBS.finish();
        return true;
    }
}
