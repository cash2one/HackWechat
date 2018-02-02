package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsMsgUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$3(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", SnsMsgUI.k(this.rDE));
        this.rDE.setResult(-1, intent);
        this.rDE.finish();
        return true;
    }
}
