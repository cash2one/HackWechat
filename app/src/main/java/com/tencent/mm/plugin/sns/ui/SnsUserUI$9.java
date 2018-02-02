package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsUserUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUserUI rMb;

    SnsUserUI$9(SnsUserUI snsUserUI) {
        this.rMb = snsUserUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.rMb, SnsMsgUI.class);
        intent.putExtra("sns_msg_force_show_all", true);
        this.rMb.startActivityForResult(intent, 8);
        return true;
    }
}
