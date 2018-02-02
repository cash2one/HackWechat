package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsPermissionUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsPermissionUI rEO;

    SnsPermissionUI$1(SnsPermissionUI snsPermissionUI) {
        this.rEO = snsPermissionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rEO.aWs();
        this.rEO.setResult(-1, new Intent());
        this.rEO.finish();
        return true;
    }
}
