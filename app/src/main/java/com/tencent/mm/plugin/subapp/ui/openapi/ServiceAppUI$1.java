package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ServiceAppUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ServiceAppUI rXV;

    ServiceAppUI$1(ServiceAppUI serviceAppUI) {
        this.rXV = serviceAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rXV.finish();
        return true;
    }
}
